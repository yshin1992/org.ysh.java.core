package org.ysh.java.core.chapter5;

import java.util.*;

import org.ysh.java.core.chapter4.Employee;
/**
 * List实例
 * 
 * @author liuliushouchun
 *
 */
public class ListSample {
	public static void main(String[] args) {
		List<Employee> epList = new ArrayList<Employee>();
		epList.add(new Employee("EM1", 10000, 2017, 3, 10));
		epList.add(new Employee("EM2", 10000, 2017, 3, 10));
		epList.add(new Employee("EM3", 10000, 2017, 3, 10));
		epList.add(new Employee("EM4", 10000, 2017, 3, 10));
		epList.add(new Employee("EM5", 10000, 2017, 3, 10));
		for(Employee e : epList) {
			System.out.println(e);
		}
	}
}
