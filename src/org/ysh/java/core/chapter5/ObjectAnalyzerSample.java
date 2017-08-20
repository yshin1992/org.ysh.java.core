package org.ysh.java.core.chapter5;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * 通用toString()方法
 * @author liuliushouchun
 *
 */
public class ObjectAnalyzerSample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello";
		String res = toString(str);
		System.out.println(res);
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
}

