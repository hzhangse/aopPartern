package com.train.dynamic.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import com.train.PeopleTalk;

public class DynamicTalkProxy implements InvocationHandler {
	
    /** 需要代理的目标类 */
    private Object target;
   
    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

	
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		
		Object result = null;
		System.out.println("切面之前执行");
		// 执行业务
		result = method.invoke(target, args);
		// 切面之后执行
		System.out.println("切面之后执行");
		return result;

	}

}
