package org.ysh.java.core.chapter13;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ViewSet {
	
	public static void main(String[] args) {
		List<String> origin = new ArrayList<String>();
		origin.add("Hello");
		origin.add("Seller");
		origin.add("Tempera");
		origin.add("Lancer");
		
		Collection<String> unmodifiableCollection = Collections.unmodifiableCollection(origin);
		printCollection(unmodifiableCollection);
		
		//attempt to rewrite <unmodifiableCollection> data
		//this will cause <java.lang.UnsupportedOperationException>
		//unmodifiableCollection.add("Korea");
		//printCollection(unmodifiableCollection);
		
		//被检验视图
//		ArrayList<String> strList = new ArrayList<String>();
//		ArrayList rawList = strList;
//		rawList.add(new Integer(5));//这部分代码实际上会有问题的，在get方法操作会提示异常
		
	}
	
	static <T> void printCollection(Collection<T>  collection){
		for(T data : collection){
			System.out.println(data);
		}
	}
}
