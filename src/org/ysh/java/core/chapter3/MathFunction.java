package org.ysh.java.core.chapter3;

/**
 * Java中的数学函数和常量
 */
public class MathFunction{

	public static void main(String[] args) {
		//自然对数的底数e
		System.out.println(Math.E);
		//圆的周长与直径之比 PI
		System.out.println(Math.PI);

		//绝对值函数
		double d1 = Math.abs(-12.5);
		System.out.println(d1);
		//正弦
		double d2 = Math.sin(Math.PI);
		System.out.println(d2);
		//反正弦
		d2 = Math.asin(0.5);
		System.out.println(d2);


		//余弦
		double d3 = Math.cos(Math.PI);
		System.out.println(d3);
		//反余弦
		d3 = Math.acos(1);
		System.out.println(d3);

		//正切
		double d4 = Math.tan(Math.PI);
		System.out.println(d4);
		//反正切
		d4 = Math.atan(1);
		System.out.println(d4);

		//天花板函数
		double d5 = Math.ceil(-1.7);
		System.out.println(d5);
		//地板函数
		double d6 = Math.floor(12.5);
		System.out.println(d6);

		//四舍五入函数 -->最大的数接近
		double d7 = Math.round(-2.5);
		System.out.println(d7);
		d7 = Math.round(2.5);
		System.out.println(d7);

		//欧拉数 e 的 double 次幂的值
		double d8 = Math.exp(2);
		System.out.println(d8);

		//返回 ex -1
		d8 = Math.expm1(2);
		System.out.println(d8);

		//log 函数
		double d9 = Math.log(Math.E);
		System.out.println(d9);

		//log10 函数
		d9 = Math.log10(100);
		System.out.println(d9);

		//最大最小值函数
		System.out.println(Math.max(10,101));
		System.out.println(Math.min(10,101));

		//返回 0 - 100 之间的随机数
		int a = (int)(Math.random()*100);
		System.out.println(a);
	}
}