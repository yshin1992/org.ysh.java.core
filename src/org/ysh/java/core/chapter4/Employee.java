package org.ysh.java.core.chapter4;

import java.util.Date;
import java.util.GregorianCalendar;
/**
 * 构造函数:
 * 	构造函数与类同名
 * 	每个类都可以有一个以上的构造器
 * 	构造器可以有任意个参数
 * 	构造器没有返回值
 * 	构造器总是伴随着new一起调用
 * 还有这些名词
 * 	成员变量，成员常量
 * 	静态域，静态方法，静态常量
 * @author yshin1992
 *
 */
public class Employee {
	//静态 常量
		private static final double RATE = 0.35;
		
		private String name;
		
		private double salary;
		
		private Date hireDay;

		/**
		 * 静态方法
		 * @return
		 */
		public static double getRate(){
			return RATE;
		}
		
		/**
		 * 构造函数
		 * @param name
		 * @param salary
		 * @param hireDay
		 */
		public Employee(String name, double salary, int year,int month,int day) {
			this.name = name;
			this.salary = salary;
			GregorianCalendar cal = new GregorianCalendar(year,month -1,day);
			this.hireDay = cal.getTime();
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getSalary() {
			return salary;
		}
		
		public void setSalary(double salary) {
			this.salary = salary;
		}

		public Date getHireDay() {
			return hireDay;
		}

		public void setHireDay(Date hireDay) {
			this.hireDay = hireDay;
		}
}
