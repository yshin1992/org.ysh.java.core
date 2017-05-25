package org.ysh.java.core.chapter6.proxy.sample.main;

import org.ysh.java.core.chapter6.proxy.sample.ServiceHandler;

public class AppContext {
	
	private static ServiceHandler handler = new ServiceHandler();
	
	public static Object getProxyBean(String beanClassName) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Object target = Class.forName(beanClassName).newInstance();
		return handler.newProxyInstance(target);
	}
	
}
