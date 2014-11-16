package proxypartern;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.train.ITalk;
import com.train.PeopleTalk;
import com.train.TalkProxy;
import com.train.dynamic.proxy.CglibDynamicTalkProxy;
import com.train.dynamic.proxy.DynamicTalkProxy;

public class TestProxyPartern {

	@Test
	public void testTalkProxy() {
		ITalk talk = new TalkProxy(new PeopleTalk());
		talk.talk();
		
	}
	
	@Test
	public void testDynamicTalkProxy() {
		DynamicTalkProxy proxy = new DynamicTalkProxy();
		PeopleTalk target = new PeopleTalk();		
		
		ITalk talk  = (ITalk)proxy.bind(target);;
		talk.talk();
		
	}
	
	
	@Test
	public void testCglibDynamicTalkProxy(){
		PeopleTalk target = new PeopleTalk();
    	target.setName("name");
    	target.setAge(18);
        PeopleTalk peopleTalk = (PeopleTalk) new CglibDynamicTalkProxy().getInstance(target);
        peopleTalk.talk();
        
        Class[] clazz = new Class[]{String.class,Integer.class};
        Object[] obj = new  Object[]{"name",18};
        
        peopleTalk = (PeopleTalk) new CglibDynamicTalkProxy().getInstance(PeopleTalk.class,clazz,obj);
        peopleTalk.talk();
       

	}

}
