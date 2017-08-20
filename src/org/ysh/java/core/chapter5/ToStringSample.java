package org.ysh.java.core.chapter5;

/**
 * ToString方法是非常有用的方法，它可以使用户获得一些有关对象状态的必要信息
 * @author liuliushouchun
 *
 */
public class ToStringSample {

	private String attr1;
	
	private int attr2;

	@Override
	public String toString() {
		return "ToStringSample [attr1=" + attr1 + ", attr2=" + attr2 + "]";
	}
	
}
