package org.ysh.java.core.chapter6.proxy;

/**
 * 管理员接口
 * @author yshin1992
 *
 */
public interface UserManager {

	public void addUser(String userId);
	
	public String findUser(String userId);
	
}
