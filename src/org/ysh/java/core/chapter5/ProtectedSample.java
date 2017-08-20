package org.ysh.java.core.chapter5;

/**
 * Java访问修饰符
 * private 仅对本类可见
 * protected 对本包和所有子类可见
 * default 对本包可见
 * public 对所有类可见
 * protected一般不推荐使用，因为其他人在设计类时使用相同对包名，则该类对所有protected修饰对熟悉均对其是可见的
 * @author liuliushouchun
 *
 */
public class ProtectedSample {

	public static void main(String[] args) {
		ProtectedObj pObj = new ProtectedObj("name", 112);
		pObj.key = "Lala";
		System.out.println(pObj.key);
	}
}

class ProtectedObj{
	protected int value;
	
	protected String key;
	
	public ProtectedObj(String key,int value) {
		this.key = key;
		this.value = value;
	}
}