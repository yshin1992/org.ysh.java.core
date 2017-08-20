package org.ysh.java.core.chapter5;
import java.util.*;
/**
 * 自动打包和对象包装器
 * int->Integer,byte->Byte,short->Short,long->Long,char->Character,bool->Boolean
 * float->Float,double->Double
 * 
 * @author liuliushouchun
 *
 */
public class AutoBoxSample {

	public static void main(String[] args) {
		List<Integer> iList = new ArrayList<Integer>();
		iList.add(5);// 这里等同于 iList.add(new Integer(5)); 也就是autobox
		iList.add(new Integer(122));
		
//		对应的自动拆箱
		int n = iList.get(1);
		//等同于下面的写法
		n = iList.get(1).intValue();//@1
		
		//一般来说new的包装对象在用等值比较时会根据引用是否一致进行判断
		//但是介于-128～127之间的short和int值被包装在固定的对象中，他们在比较时是相等的
		Integer i1 = 129;
		Integer i2 = 129;
		System.out.println(i1==i2);
		i1 = 127;
		i2= 127;
		System.out.println(i1 == i2);
		i1 = -129;
		i2= -129;
		System.out.println(i1 == i2);
		
		//拆包和打包是编译器认可的，不是虚拟机，编译器在生成类的字节码时会插入必要的方法调用, 例如@1
		Integer num = 3;
		num ++;//编译器会将其变为 int tmp=num.intValue();tmp++;n=new Integer(tmp);
		
		
		
	}
}
