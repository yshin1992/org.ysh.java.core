package org.ysh.java.core.chapter3;

import java.util.Date;
/**
* 格式化输出
*/
public class FormatOutput{

	public static void main(String[] args){
		String name = "Jave";
		int age = 26;
		System.out.printf("Hello , %s ,Next year you will be %d !\r\n",name,age); 
		
		//创建格式化的字符串
		String formatStr = String.format("Hello , %s ,Next year you will be %d !",name,age);
		System.out.println(formatStr); 
		
		//格式化输出日期
		System.out.printf("%tc",new Date());
	}
	
}
