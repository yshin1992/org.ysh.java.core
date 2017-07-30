package org.ysh.java.core.chapter5;

import org.ysh.java.core.chapter4.Employee;

public class Manager extends Employee{
	public Manager(String name, double salary, int year, int month, int day) {
		super(name, salary, year, month, day);
	}

	private double bouns;//奖金

	public double getBouns() {
		return bouns;
	}

	public void setBouns(double bouns) {
		this.bouns = bouns;
	}
	
	public double getSalary()
	{
		//这里不能访问父类的私有成员变量salary,访问方法
		return this.bouns + super.getSalary();
	}
}
