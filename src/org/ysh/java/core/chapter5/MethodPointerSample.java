package org.ysh.java.core.chapter5;

import java.lang.reflect.Method;
import java.util.Date;

import org.ysh.java.core.chapter4.Employee;

/**
 * Java 方法指针的使用，准确的说，是反射某一个类的方法并调用
 * @author liuliushouchun
 *
 */
public class MethodPointerSample {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Method square = MethodPointerSample.class.getMethod("square", double.class);
		Method sqrt = Math.class.getMethod("sqrt", double.class);
		
		printTable(1,10,square);
		printTable(1,10,sqrt);
		
		Employee em = new Employee("Jane", 10000, 2013, 1, 12);
		
		Method setNameMthd = Employee.class.getMethod("setName", String.class);
		setNameMthd.invoke(em, "Salary");
		Method setHireDayMthd = Employee.class.getMethod("setHireDay", Date.class);
		setHireDayMthd.invoke(em, new Date());
		System.out.println(ObjectAnalyzerSample.toString3(em));
	}

	public static double square(double x) {
		return x*x;
	}
	
	public static void printTable(double from,double to,Method func) {
		for(double x = from;x<to;x ++) {
			try {
				double y = (double)func.invoke(null, x);
				System.out.printf("%10.4f | %10.4f\n",x,y);
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
	}
}
