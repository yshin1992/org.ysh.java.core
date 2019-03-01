package org.ysh.java.core.chapter3;

import java.util.Arrays;

/**
 * 字符串示例
 */
public class StringDemo{

	public static void main(String[] args) {
		String str = new String("abcdefg");

		int len = str.length();//字符串长度

		for(int i=0;i<len;i++)
		{
			int codePoint = str.codePointAt(i);//返回指定位置的代码点
			System.out.println("codePoint = " + codePoint);
			char character = str.charAt(i);//返回指定的代码单元
			System.out.println("Character = " + character);
		}

		String str1 = "abdd";
		int compareResult = str1.compareTo(str);
		System.out.println("compare result = " + compareResult);

		boolean equals = str1.equals(str);
		System.out.println("字符串相等 = "+ equals);

		equals = str1.equalsIgnoreCase("AbDd");
		System.out.println("字符串相等 = "+ equals);

		boolean endsWith = str1.endsWith("dd");
		System.out.println("字符串以dd结尾 = "+ endsWith);

		boolean startsWith = str1.startsWith("Ab");
		System.out.println("字符串以Ab开始 = "+ startsWith);

		int index = str.indexOf("bc");
		System.out.println("bc在字符串"+str+"中的位置:"+index);

		index = str.lastIndexOf("bc");
		System.out.println("bc在字符串"+str+"中的位置:"+index);

		String subStr = str.substring(1,3);
		System.out.println("字符串"+str+"的子串 :" +subStr);

		String upperCase = str.toUpperCase();
		System.out.println("字符串"+str+"的大写形式 :" +upperCase);

		String lowerCase = str.toLowerCase();
		System.out.println("字符串"+str+"的小写形式 :" +lowerCase);

		String trimCase = str.trim();//删除原始字符串头部和尾部的空格
		System.out.println(trimCase);

		String replaceStr = str1.replace("dd","rc");
		System.out.println(replaceStr);
		
		System.out.println("1234".indexOf('1',-1222));
		
		System.out.println("1234".lastIndexOf('1',6565));
		
		System.out.println(Arrays.toString("1234".toCharArray()));
		
		System.out.println(Arrays.toString("1,3,ds,d".split(",")));
		
		
		final String str6 = "b";
		String str7 = "a" + str6;
		String str67 = "ab";
		System.out.println("str7 = str67 : "+ (str7 == str67));
	}
}