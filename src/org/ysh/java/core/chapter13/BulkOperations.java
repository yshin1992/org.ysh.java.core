package org.ysh.java.core.chapter13;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BulkOperations {

	public static void main(String[] args) {
		List<Integer> intList1 = Arrays.asList(1,2,3,5,8);
		List<Integer> intList2 = Arrays.asList(2,4,6,8,10);
		
		//交集
		List<Integer> intersection = new ArrayList<Integer>(intList1);
		intersection.retainAll(intList2);
		
		ViewSet.printCollection(intersection);
		
		Integer[] vals = intList1.toArray(new Integer[0]);
		printArr(vals);
		
		Comparator<Integer> intComparator = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o1-o2;
			}
		};
		
		Collections.sort(intList1,Collections.reverseOrder(intComparator));
		ViewSet.printCollection(intList1);
		
		int index = Collections.binarySearch(intList1, 5);
		System.out.println(index);
	}
	
	public static void printArr(Object obj) {
		Class<?> clazz = obj.getClass();
		if(!clazz.isArray()) {
			return ;
		}
		
		Class<?> type = clazz.getComponentType();
		int len = Array.getLength(obj);
		System.out.print(type.getTypeName() + "[" + len + "] = { ");
		for(int i=0;i<len;i++) {
			System.out.print(Array.get(obj, i) + " ");
		}
		System.out.println("}");
	}
}
