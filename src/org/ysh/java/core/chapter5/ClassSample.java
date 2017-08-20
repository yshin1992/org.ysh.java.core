package org.ysh.java.core.chapter5;

import java.sql.Date;

/**
 * 反射Class类
 * @author liuliushouchun
 *
 */
public class ClassSample {

	public static void main(String[] args) {
		//一个Class对象实际表示一个类型，而这个对象未必一定是一种类
		Class c1 = Date.class;
		System.out.println(c1.getName());
		Class c2 = int.class;
		System.out.println(c2.getName());
		Class c3 = Double[].class;
		System.out.println(c3.getName());
		
		try {
			Class c4 = Class.forName("java.lang.String");
			try {
				c4.newInstance();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
