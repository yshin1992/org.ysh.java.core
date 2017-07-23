package org.ysh.java.core.chapter3;

/**
 *  字符串每次拼接时都会生成一个新的字符串,消耗时间,浪费空间
 *  这里考虑使用StringBuilder类来构建字符串
 */
public class StringBuilderDemo{
	
	public static void main(String[] args)
	{
		StringBuilder builder = new StringBuilder();
		
		builder.append("床前明月光,").append("疑是地上霜。");//追加字符串
		builder.appendCodePoint('a');//追加一个代码点
		builder.setCharAt(2,'c');//将第2个单元设置为'c'
		builder.insert(0,"静夜思 李白");//在指定的offset位置插入字符串
		System.out.println(builder.toString() + "长度 : " + builder.length());
		builder.delete(3,6);//删除偏移量从StartIndex到endIndex-1的代码单元并返回this
		System.out.println(builder.toString() + "长度 : " + builder.length());
		
	}
}
