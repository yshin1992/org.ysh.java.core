package org.ysh.java.core.chapter4;

/**
 * Java中方法参数的总结
 * 	方法不能改变基本数据类型的参数
 * 	方法能改变一个对象的状态
 *	方法不能修实参数对象的引用(这个不难理解，因为形参实际上是一个指向真实地址的引用，
 *	可以看作是实参（也是引用）的一个拷贝，所以这个拷贝的指向改变了，并不会改变实参的引用)
 * @author yshin1992
 *
 */
public class FunctionParams {
	class TestNumber{
		int value1;
		int value2;
	}
	
	/**
	 * 这里的参数是基本数据类型，它会将值复制到形参上
	 * 原来的数值不会改变
	 * @param value
	 */
	private static void tripleValue(double value)
	{
		value *= 3;
	}
	
	/**
	 * 方法能够修改对象的状态，如下例
	 * @param number
	 */
	private static void tripleValue(TestNumber number)
	{
		number.value1 *= 3;
	}
	
	/**
	 * 方法不能修改实参的引用
	 * @param number
	 */
	private static void replace(TestNumber number)
	{
		FunctionParams fp = new FunctionParams();
		number = fp.new TestNumber();//重新指向新的引用
		number.value1 = number.value2= -1;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 8;
		tripleValue(x);
		System.out.println(x); //这里x的值仍然是8
		
		FunctionParams instance = new FunctionParams();
		TestNumber tNum = instance.new TestNumber();
		tNum.value1 = 8;
		tripleValue(tNum);
		System.out.println(tNum.value1);
		
		replace(tNum);
		System.out.println(tNum.value1);//这里的值并未变成-1
	}
}
