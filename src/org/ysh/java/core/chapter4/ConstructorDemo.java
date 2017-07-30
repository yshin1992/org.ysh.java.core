package org.ysh.java.core.chapter4;

import java.util.Random;

/**
 * Java中关于构造器的一些概念
 * 	重载(同名不同参)
 * 		根据各个同名方法给出的参数类型与特定方法调用所使用的值类型进行匹配来挑选相应的方法
 * 	默认域初始化
 * 		如果在构造器中没有显示的给域赋值，那么域会被自动的赋予初值：数值为0，布尔为false，对象引用为null
 * 	默认构造器
 * 		没有参数的构造器。如果类中没有编写构造器，则系统会提供一个默认构造器。这个构造器会将所有的域设置默认值。
 * 	显示域初始化
 * 		在构造器中给域赋值
 * 	调用另一个构造器
 * 		使用this关键字
 * 	初始化块
 * 		在创建类的一个新的实例时，这些块就会被执行
 * 
 * 	调用构造器的具体处理步骤
 * 		1.所有数据域都被初始化默认值
 * 		2.按照在类声明中的顺序，依次执行所有域初始化语句和初始化块
 * 		3.如果构造器第一行调用了第二个构造器主体，则执行第二个构造器主体
 * 		4.执行这个构造器的主体
 * @author yshin1992
 *
 */
public class ConstructorDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] stus = new Student[3];
		stus[0] = new Student("Jane",89);
		stus[1] = new Student(88);
		stus[2] = new Student();
		for(Student stu : stus)
		{
			System.out.println(stu.getId() + " -- " + stu.getName() + " -- " + stu.getScore());
		}
	}
}
class Student{
	
	private int id;
	
	private String name;
	
	private int score;
	
	private static int nextId;
	
	//静态初始化块
	static{
		Random generator = new Random();
		nextId = generator.nextInt(1000);//0~999
	}
	
	//初始化块
	{
		id = nextId;
		nextId ++;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * 默认构造函数
	 */
	public Student()
	{
		
	}
	
	public Student(int score)
	{
		//this调用另一个构造函数
		this("Student "+ nextId,score);
	}
	
	public Student(String name,int score)
	{
		this.name = name;
		this.score = score;
	}
}