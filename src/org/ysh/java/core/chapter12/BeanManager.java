package org.ysh.java.core.chapter12;

public class BeanManager {
	
	public static <T> T getBean(String beanName,Class<T> clazz) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		return clazz.newInstance();
	}
	
	public static void main(String[] args) {
		try {
			String src = getBean("java.lang.String", String.class);
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
