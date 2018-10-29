package org.ysh.java.core.chapter5;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectSample {
	
	public static void main(String[] args) {
		Class<?> clazz = Double.class;
		printConstructors(clazz);
		printFields(clazz);
		printMethods(clazz);
	}
	/**
	 * 构造函数
	 * @param clazz
	 */
	public static void printConstructors(Class<?> clazz) {
		Constructor<?>[] constructors = clazz.getConstructors();
		for(Constructor<?> cst : constructors) {
			System.out.print(" ");
			int modifiers = cst.getModifiers();
			String mod = Modifier.toString(modifiers);
			//修饰符
			if(mod.length() > 0) {
				System.out.print(mod + " ");
			}
			String name = cst.getName();
			System.out.print(name + "(");
			
			Class<?>[] parameterTypes = cst.getParameterTypes();
			if(null != parameterTypes && parameterTypes.length > 0) {
				for(int i=0;i<parameterTypes.length;i++) {
					Class<?> tmp = parameterTypes[i];
					System.out.print(tmp.getTypeName());
					if(i < parameterTypes.length - 1) {
						System.out.print(",");
					}
				}
			}
			System.out.print(")");
			
			//Exceptions
			Class<?>[] exceptions = cst.getExceptionTypes();
			if(null!=exceptions && exceptions.length>0) {
				System.out.print(" throws ");
				for(int i=0;i<exceptions.length;i++) {
					System.out.print(exceptions[i].getName());
					if(i<exceptions.length-1) {
						System.out.print(",");
					}
				}
			}
			System.out.println(";");
		}
	}
	
	/**
	 * 域
	 * @param clazz
	 */
	public static void printFields(Class<?> clazz) {
		Field[] fields = clazz.getFields();
		if(null != fields && fields.length > 0) {
			for(Field field : fields) {
				System.out.print(" ");
				String modifier = Modifier.toString(field.getModifiers());
				if(modifier.length() > 0) {
					System.out.print(modifier + " ");
				}
				String name = field.getName();
				String type = field.getType().getTypeName();
				System.out.println(type+ " " + name + ";");
			}
		}
	}
	
	public static void printMethods(Class<?> clazz) {
		Method[] methods = clazz.getMethods();
		if(null != methods && methods.length > 0) {
			for(Method m : methods) {
				System.out.print(" ");
				String returnType = m.getReturnType().getTypeName();
				String modifier = Modifier.toString(m.getModifiers());
				if(modifier.length() > 0) {
					System.out.print(modifier + " ");
				}
				String methodName = m.getName();
				System.out.print(returnType + " " + methodName+ "(");
				
				Class<?>[] parameterTypes = m.getParameterTypes();
				if(null != parameterTypes && parameterTypes.length > 0) {
					for(int i =0;i<parameterTypes.length;i++) {
						String paramType = parameterTypes[i].getTypeName();
						System.out.print(paramType);
						if(i < parameterTypes.length - 1) {
							System.out.print(",");
						}
					}
				}
				System.out.print(")");
				
				//Exceptions
				Class<?>[] exceptions = m.getExceptionTypes();
				if(null!=exceptions && exceptions.length>0) {
					System.out.print(" throws ");
					for(int i=0;i<exceptions.length;i++) {
						System.out.print(exceptions[i].getName());
						if(i<exceptions.length-1) {
							System.out.print(",");
						}
					}
				}
				System.out.println(";");
			}
		}
		
		
	}
}
