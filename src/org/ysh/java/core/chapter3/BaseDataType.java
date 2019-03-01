package org.ysh.java.core.chapter3;

/**
* Java8种基本数据类型
*	整型 byte short int long
*	浮点型 float double
*	字符型 char
*	布尔型 boolean
*/
public class BaseDataType {
	public static void main(String[] args){
		
		byte b1 = Byte.MAX_VALUE;
		byte b2 = Byte.MIN_VALUE;

		short s1 = Short.MAX_VALUE;
		short s2 = Short.MIN_VALUE;

		int i1 = Integer.MAX_VALUE;
		int i2 = Integer.MIN_VALUE;

		long l1 = Long.MAX_VALUE;
		long l2 = Long.MIN_VALUE;

		float f1 = Float.MAX_VALUE;
		float f2 = Float.MIN_VALUE;

		double d1 = Double.MAX_VALUE;
		double d2 = Double.MIN_VALUE;
		
		char ch1 = Character.MIN_VALUE;
		char ch2 = Character.MAX_VALUE;

		System.out.println("byte MAX_VALUE = " + b1);
		System.out.println("byte MIN_VALUE = " + b2);

		System.out.println("short MAX_VALUE = " + s1);
		System.out.println("short MIN_VALUE = " + s2);

		System.out.println("int MAX_VALUE = " + i1);
		System.out.println("int MIN_VALUE = " + i2);

		System.out.println("long MAX_VALUE = " + l1);
		System.out.println("long MIN_VALUE = " + l2);

		System.out.println("float abs MAX_VALUE = " + f1);
		System.out.println("float abs MIN_VALUE = " + f2);

		System.out.println("double abs MAX_VALUE = " + d1);
		System.out.println("double abs MIN_VALUE = " + d2);

		System.out.println("char MAX_VALUE = " + (int)ch1);
		System.out.println("char MIN_VALUE = " + (int)ch2);
		
		boolean bool1 = false;

		System.out.println("Boolean : " + bool1);

		char c1 = '字';
		System.out.println("Char : " + c1);
	}
}
