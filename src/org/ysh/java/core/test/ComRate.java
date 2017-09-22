package org.ysh.java.core.test;

public class ComRate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		double salary = 300000;
		double salary = 1;
		
//		double rate = 0.04/365;
		
		double rate = 0.1;
		for(int i=1;i<=7;i++){
			salary = salary * (1 + rate);
		}
		System.out.println(salary);
		
	}

}
