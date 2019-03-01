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
		
		//验证 float和long在一起运算时转换成什么数值:
		float f = 12.9f;
		long l = 1288832;
		
		//下面的表达式成立
		//也就是说float和long一起运算时，long转型为float
		f = f+l;//ok
		
	}
}