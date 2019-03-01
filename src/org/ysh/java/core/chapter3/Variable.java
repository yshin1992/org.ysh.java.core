package org.ysh.java.core.chapter3;

/**
* Java中变量的声明和定义
* Java中每一个变量都属于一种类型
* 变量名必须是以$ 、字母、下划线开头的，由$ 、字母、下划线和数字和组成
*/
public class Variable{
	
	public static void main(String[] args){
		
		double salary = 1.25d;
		int $work_days = 11;
		boolean _is_member = false;
		boolean _is_member_2 = true;
		
		System.out.println(salary);
		System.out.println($work_days);
		System.out.println(_is_member);
		System.out.println(_is_member_2);
		
		//注意,使用变量必须经过显示初始化（也就是赋值）之后，才能被使用
		//int i;
		//i=i+$work_days;//The local variable i may not have been initialized
		
		//不仅仅是基础数据类型，类也同样必须赋值后才能使用
		//Integer ia;
		//System.out.print(ia);//The local variable ia may not have been initialized
	}
}