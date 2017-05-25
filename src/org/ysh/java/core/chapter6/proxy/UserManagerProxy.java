package org.ysh.java.core.chapter6.proxy;

/**
 * UserManager静态代理类
 * @author yshin1992
 *
 */
public class UserManagerProxy implements UserManager{

	private UserManager userManager = new UserManagerImpl();
	
	public void addUser(String userId){
		System.out.println("execute add start----------------------->");
		userManager.addUser(userId);
		System.out.println("execute add end------------------------->");
	}
	
	public String findUser(String userId){
		System.out.println("execute find start----------------------->");
		String result = userManager.findUser(userId);
		System.out.println("execute find end------------------------->");
		return result;
	}
	
	
}
