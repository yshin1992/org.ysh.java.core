package org.ysh.java.core.chapter5;

public class PreventExtendSample {

}
/**
 * 该类不能被继承
 * @author yshin1992
 *
 */
final class FinalNumber extends MediumNumber{
	int value;
	/**
	 * 父类的getValue方法无法被覆盖
	 */
	//Cannot override the final method from MediumNumber
//	public int getValue()
//	{
//		
//	}
}

class MediumNumber{
	int value;
	
	public final int getValue()
	{
		return this.value;
	}
}
