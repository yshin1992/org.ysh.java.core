package org.ysh.java.core.chapter5;

/**
 * hash code是由对象导出的一个整数值
 * 由于hashCode方法定义在Object类中，因此每一个对象都有一个默认的hashCode，其值为对象的存储地址
 * @author liuliushouchun
 *
 */
public class HashCodeSample {
	private String hashVal;
	
	private int hashKey;
	
	@Override
	public int hashCode() {
		return hashVal.hashCode() + 3*hashKey;
	}



	public static void main(String[] args) {
		String s = "OK";
		StringBuilder sb = new StringBuilder(s);
		System.out.println(s.hashCode() + "\t" + sb.hashCode());
		String t = new String("OK");
		StringBuilder tb = new StringBuilder(t);
		System.out.println(t.hashCode() + "\t" + tb.hashCode());
	}
}
