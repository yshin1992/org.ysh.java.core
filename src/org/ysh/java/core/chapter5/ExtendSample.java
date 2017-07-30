package org.ysh.java.core.chapter5;

import org.ysh.java.core.chapter4.Employee;

public class ExtendSample {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Manager boss = new Manager("boss", 10000, 1975, 11, 23);
		boss.setBouns(13000);
		
		Employee[] staffs = new Employee[3];
		staffs[0] = boss;
		staffs[1] = new Employee("Tom", 6000, 1990, 1, 30);
		staffs[2] = new Employee("Jane", 6500, 1991, 3, 23);
		
		for(Employee employee : staffs)
		{
			System.out.println(employee.getName() + " -- " + employee.getSalary() + " -- " + employee.getHireDay());
		}
		
		/**
		 * 这里在讲一下类型转化
		 */
		//这里需要使用强制类型转换
		Manager boss2 = (Manager) staffs[0];
		/**
		 * 但是上述类型转换并不安全，可能会报ClassCastException
		 * 合适的处理办法是在转换前先使用instanceof判断下，如下例所示
		 */
		if(staffs[1] instanceof Manager)
		{
			boss2 = (Manager) staffs[1];
		}
	}
}
