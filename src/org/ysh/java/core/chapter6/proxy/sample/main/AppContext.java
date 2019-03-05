package org.ysh.java.core.chapter6.proxy.sample.main;

import org.ysh.java.core.chapter6.proxy.sample.ServiceHandler;

public class AppContext {
	
	private static ServiceHandler handler = new ServiceHandler();
	
	public static <T> T getProxyBean(Class<T> clazz) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		T target = clazz.newInstance();
		return handler.newProxyInstance(clazz,target);
	}
	
}
