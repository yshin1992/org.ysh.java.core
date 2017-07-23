package org.ysh.java.core.chapter3;

import java.util.Scanner;
/**
* Java中控制台中读取输入
*/
public class ReadInput{
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		System.out.println("输入字符串:");
		String strLine = scan.nextLine();//读取输入的一行
		System.out.println("您输入的字符串:"+ strLine);
		System.out.println("输入一个单词:");
		String word = scan.next();
		System.out.println(word);
		
		System.out.println("输入一个整数:");
		int num1 = scan.nextInt();
		
		System.out.println("输入一个浮点数:");
		double num2 = scan.nextDouble();
		
		System.out.println(num1 + " + " + num2 + " = " + (num1+num2));
		scan.close();
	}
}
