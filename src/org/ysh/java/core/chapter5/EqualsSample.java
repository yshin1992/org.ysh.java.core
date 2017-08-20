package org.ysh.java.core.chapter5;

/**
 * Equals书写建议
 * 1.显示参数命名为otherObject，稍后转换为Other的变量
 * 2.检测this与OtherObject是否是引用的同一个对象
 * 3.检测otherObject为null，则返回false
 * 4.比较this和otherObject是否是同一个类
 * 5.将otherObject转换为相应类型的变量
 * 6.对所需要比对的域进行比较
 * @author liuliushouchun
 *
 */
public class EqualsSample {

	private String name;
	
	private int age;

	@Override
	public boolean equals(Object obj) {
		//判断是否是同一引用
		if(this == obj) {
			return true;
		}
		
		//判断obj是否为null
		if(null == obj) {
			return false;
		}
		
		//判断this和obj是否是同一类
		if(this.getClass() != obj.getClass()) {
			return false;
		}
		
		//将obj转换为相应的类，并比较对应的域
		EqualsSample es = (EqualsSample) obj;
		if(this.age == es.age && this.name.equals(es.name)) {
			return true;
		}
		
		return false;
	}
	
	
}
