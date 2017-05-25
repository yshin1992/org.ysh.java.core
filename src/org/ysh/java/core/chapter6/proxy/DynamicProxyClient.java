package org.ysh.java.core.chapter6.proxy;

public class DynamicProxyClient {

	public static void main(String[] args) {
		UserManagerHandler proxyHandler = new UserManagerHandler();  
        UserManager userManager = (UserManager)proxyHandler.newProxyInstance(new UserManagerImpl());  
          
        userManager.findUser("0001");  
	}
}
