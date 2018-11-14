package org.ysh.java.core.chapter5;

import java.lang.reflect.Array;

public class ArrayGrowSample {

	public static void main(String[] args) {
		int[] a = {1,2,3};
		a = (int[]) goodGrow(a);
		printArr(a);
		
		String[] strs = {"Hello","world"};
		strs = (String[]) goodGrow(strs);
		printArr(strs);
	}
	/**
	 * 复制原来的数组，并返回一个数组长度增加的数组
	 * @param a
	 * @return
	 */
	static Object[] badGrow(Object[] a) {
		int newLen = a.length*11/10 + 10;
		Object[] newArr = new Object[newLen];
		System.arraycopy(a, 0, newArr, 0, a.length);
		return newArr;
	}
	
	static Object goodGrow(Object obj) {
		Class<?> clazz = obj.getClass();
		if(!clazz.isArray()) {
			return null;
		}
		Class<?> type = clazz.getComponentType();
		int len = Array.getLength(obj);
		int newLen = len*11/10 +10;
		Object arrInstance = Array.newInstance(type, newLen);
		System.arraycopy(obj, 0, arrInstance, 0, len);
		return arrInstance;
	}
	
	static void printArr(Object obj) {
		Class<?> clazz = obj.getClass();
		if(!clazz.isArray()) {
			return ;
		}
		
		Class<?> type = clazz.getComponentType();
		int len = Array.getLength(obj);
		System.out.print(type.getName() + "[" + len + "] = { ");
		for(int i=0;i<len;i++) {
			System.out.print(Array.get(obj, i) + " ");
		}
		System.out.println("}");
	}
}
