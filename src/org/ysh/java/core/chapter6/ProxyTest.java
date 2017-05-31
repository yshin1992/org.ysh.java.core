package org.ysh.java.core.chapter6;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

/**
 * 代理类
 * Java 提供的Proxy代理类，属于动态代理
 * @author yshin1992
 *
 */
public class ProxyTest {

	public static void main(String[] args) {

		Object[] elements = new Object[1000];
		
		for(int i = 0;i<elements.length;i++){
			Integer value = i + 1;
			InvocationHandler handler = new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
			elements[i] = proxy;
		}
		
		//构建一个随机数
		Integer key = new Random().nextInt(elements.length) + 1;

		//寻找key值所在的索引
		int binarySearch = Arrays.binarySearch(elements, key);
		
		System.out.println("elements["+binarySearch+"]");
		
	}

}

class TraceHandler implements InvocationHandler{

	private Object target;
	
	public TraceHandler(Object target){
		this.target = target;
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		//打印参数
		System.out.print(target + "." +method.getName() + "(");
		if(null != args){
			for(int i =0 ;i < args.length;i++){
				System.out.print(args[i]);
				if(i<args.length - 1){
					System.out.print(", ");
				}
			}
		}
		System.out.println(")");
		//执行实际的方法
		return method.invoke(target, args);
	}
	
}
