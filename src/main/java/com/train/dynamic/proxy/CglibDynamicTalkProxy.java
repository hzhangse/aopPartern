package com.train.dynamic.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibDynamicTalkProxy implements MethodInterceptor {
    private Object target;

    /**
     * 创建代理对象
     * 
     * @param target
     * @return
     */
    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
       
        // 回调方法
        enhancer.setCallback(this);
      
      
        // 创建代理对象
        return enhancer.create();
    }

    public Object getInstance(Class c, Class[] clazz, Object[] obj ) {
       
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(c);   
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
      return  enhancer.create(clazz,obj);
    
    }
    
   /*
    * (non-Javadoc)
    * @see net.sf.cglib.proxy.MethodInterceptor#intercept(java.lang.Object, java.lang.reflect.Method, java.lang.Object[], net.sf.cglib.proxy.MethodProxy)
    */
    public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        System.out.println("事物开始");
        result = methodProxy.invokeSuper(proxy, args);
        System.out.println("事物结束");
        return result;
    }


}
