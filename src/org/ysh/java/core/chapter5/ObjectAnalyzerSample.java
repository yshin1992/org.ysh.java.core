package org.ysh.java.core.chapter5;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.ysh.java.core.chapter4.Employee;

/**
 * 通用toString()方法
 * @author liuliushouchun
 *
 */
public class ObjectAnalyzerSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello";
		String res = toString3(str);
		System.out.println(res);
		
		Employee em1 = new Employee("Jane", 5000, 2014, 1, 13);
		System.out.println(toString3(em1));
		
		List<Employee> ems = new ArrayList<Employee>();
		ems.add(em1);
		ems.add(new Employee("Salary", 10000, 2013, 1, 10));
		System.out.println(toString3(ems));
	}

	/**
	 * 下面是一个存在bug的toString方法，它首先便利在自身定义的属性，然后设置为可访问，获取其设置的值
	 * 但是可能会存在循环引用，造成无限递归
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		StringBuilder builder = new StringBuilder();
		if(null == obj) {
			return "null";
		}
		Class<?> clazz = obj.getClass();
		builder.append(clazz.getName() + "");
		do {
			builder.append("[");
			Field[] fs = clazz.getDeclaredFields();
			AccessibleObject.setAccessible(fs, true);
			for(Field f:fs) {
				if(!Modifier.isStatic(f.getModifiers())) {
					if(!builder.toString().endsWith("[")) {
						builder.append(",");
					}
					builder.append(f.getName() + "=");
					
					try {
						Object val = f.get(obj);
						builder.append(val);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			builder.append("]");
			clazz = clazz.getSuperclass();
		}while(null != clazz);
		return builder.toString();
	}
	
	/**
	 * 解决数组显示[C@5c647e05,hash=0][]的问题
	 * @param obj
	 * @return
	 */
	public static String toString2(Object obj) {
		StringBuilder builder = new StringBuilder();
		if(null == obj) {
			return "null";
		}
		Class<?> clazz = obj.getClass();
		builder.append(clazz.getName() + "");
		do {
			builder.append("[");
			Field[] fs = clazz.getDeclaredFields();
			AccessibleObject.setAccessible(fs, true);
			for(Field f:fs) {
				if(!Modifier.isStatic(f.getModifiers())) {
					if(!builder.toString().endsWith("[")) {
						builder.append(",");
					}
					builder.append(f.getName() + "=");
					try {
						Object val = f.get(obj);
						Class<?> type = f.getType();
						if(type.isPrimitive()) {
							builder.append(val);
						}else if(type.isArray()) {
							Class<?> componentType = type.getComponentType();
							builder.append(componentType.getName()+"[]{");
							int arrLen = Array.getLength(val);
							for(int i=0;i<arrLen;i++) {
								Object arrVal = Array.get(val,i);
								if(componentType.isPrimitive()) {
									builder.append(arrVal);
								}else {
									//对于非原始类型暂时不做特殊处理
									builder.append(arrVal);
								}
								if(i<arrLen -1) {
									builder.append(",");
								}
							}
							builder.append("}");
						}
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			builder.append("]");
			clazz = clazz.getSuperclass();
		}while(null != clazz);
		return builder.toString();
	}
	
	/**
	 * 针对数组进行修正版本，同时为了防止递归，导致循环引用，加入存储已访问过的对象队列
	 * @param obj
	 * @return
	 */
	private static List<Object> visited = new ArrayList<Object>();
	
	public static String toString3(Object obj) {
		StringBuilder builder = new StringBuilder();
		if(null == obj) {
			return "null";
		}
		if(visited.contains(obj)) {
			return "...";
		}else {
			visited.add(obj);
		}
		Class<?> clazz = obj.getClass();
		//针对数组的情况做单独的处理
		if(clazz.isArray()) {
			builder.append(clazz.getComponentType().getTypeName() + "[]{");
			int len = Array.getLength(obj);
			for(int i=0;i<len;i++){
				Object val = Array.get(obj, i);
				if(clazz.getComponentType().isPrimitive()) {
					builder.append(val);
				}else {
					builder.append(toString3(val));
				}
				
				if(i<len-1) {
					builder.append(",");
				}
			}
			builder.append("}");
			return builder.toString();
		}
		
		builder.append(clazz.getName() + "");
		do {
			builder.append("[");
			Field[] fs = clazz.getDeclaredFields();
			AccessibleObject.setAccessible(fs, true);
			for(Field f:fs) {
				if(!Modifier.isStatic(f.getModifiers())) {
					if(!builder.toString().endsWith("[")) {
						builder.append(",");
					}
					builder.append(f.getName() + "=");
					try {
						Object val = f.get(obj);
						Class<?> type = f.getType();
						if(type.isPrimitive()) {
							builder.append(val);
						}else{
							builder.append(toString3(val));
						}
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}
			builder.append("]");
			clazz = clazz.getSuperclass();
		}while(null != clazz);
		return builder.toString();
	}
	
}

