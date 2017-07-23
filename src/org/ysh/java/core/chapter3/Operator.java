package org.ysh.java.core.chapter3;

/**
* Java中的运算符
*/
public class Operator{

	/**
	 * Java中的自增自减运算符
	 */
	private static void autoIncrement(){
		byte num1 = 1;
		//后++
		System.out.println("num1 = " + num1++);

		byte num2 = 1;
		//前++
		System.out.println("num1 = " + ++num1);

	}

	/**
	 * 关系运算符
	 * >,<,==,!=,<=,>=
	 */
	private static void relation(){

		boolean bool1 = 5 >= 3;
	}

	/**
	 * 布尔运算符
	 * &&,&,||,|,!
	 */
	private static void bool(){
		int a = 1;
		int b = 2;
		//短路与
		boolean b1 = a > b && ++a <= b;
		System.out.println(b1 + "\t"+ a); 
		//非短路与
		boolean b2 = a > b & ++a <= b;
		System.out.println(b2 + "\t"+ a); 
	}

	/**
	 * 位运算符
	 * &,|,>>,>>>,<<,~
	 */
	private static void bitOperator()
	{
		//算术与
		int a1 = 13 & 0x0C;
		System.out.println("a1 = " + a1);

		//算术或
		a1 = 13 | 0x0C;
		System.out.println("a1 = " + a1);

		//异或
		a1 = 13 ^ 0x0C;
		System.out.println("a1 = " + a1);

		//非
		a1 = ~13;
		System.out.println("a1 = " + a1);

		a1 = 13;
		//a1 扩大8倍
		a1 <<= 3;
		System.out.println("a1 = " + a1);

		//a1 右移5位
		a1 >>= 5;
		System.out.println("a1 = " + a1);

	}

	public static void main(String[] args) {
		// bool();
		bitOperator();
	}


}