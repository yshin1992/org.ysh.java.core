package org.ysh.java.core.chapter6.proxy;

/**
 * 静态代理类的实现
 * 优点
 * 1.直观
 * 2.效率高
 * 缺点
 * 1.代码编写量繁多
 * 2.重复量大
 * @author yshin1992
 *
 */
public class StaticProxyClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserManager um = new UserManagerProxy();
		um.addUser("Hahaha");
	}

}
