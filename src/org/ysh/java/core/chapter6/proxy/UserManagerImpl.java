package org.ysh.java.core.chapter6.proxy;

public class UserManagerImpl implements UserManager {

	@Override
	public void addUser(String userId) {
		System.out.println("add User------------>" + userId);
	}

	@Override
	public String findUser(String userId) {
		System.out.println("find User----------->" + userId);
		return userId;
	}

}
