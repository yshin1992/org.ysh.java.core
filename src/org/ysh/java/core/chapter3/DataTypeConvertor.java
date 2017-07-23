package org.ysh.java.core.chapter3;

/**
 * Java中的数据类型转换
 *  从低精度->高精度 自动转换
 *  反之 需要强转
 */
public class DataTypeConvertor{

	public static void main(String[] args) {
		int a1 = 128;
		byte b1 = (byte)a1;//这里需要强转
		System.out.println(b1);
	}
}