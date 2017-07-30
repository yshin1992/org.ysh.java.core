package org.ysh.java.core.chapter5;
/**
 * Java中的抽象类既可以包含（或不包含）未实现的方法
 * 也可以包含（或不包含）具体的实现
 * 抽象类和抽象方法使用abstract修饰
 * 抽象类是不能被实例化的,但它同样可以有构造方法
 * @author yshin1992
 *
 */
public class AbstractClassSample {

}
abstract class Person{
	
	private String name;
	
	public Person(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return name;
	}
	
	public abstract String getDescription();
	
}

class Teacher extends Person{

	public Teacher(String name,String desc) {
		super(name);//这行代码必须
		this.description = desc;
	}
	
	private String description;
	
	@Override
	public String getDescription() {
		return description;
	}
	
}