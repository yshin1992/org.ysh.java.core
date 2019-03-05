package org.ysh.java.core.chapter6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * Java中内部类主要分为成员内部类、局部内部类、匿名内部类、静态内部类
 * 
 * 使用普通内部类
 * 第一：成员内部类中不能存在任何static的变量和方法（注意，可以定义常量）；
 * 第二：成员内部类是依附于外围类的，所以只有先创建了外围类才能够创建内部类
 * 第三：可以访问外部类的类成员、类方法、普通成员和普通方法
 * @author yshin1992
 *
 */
public class TimerTest2 {
	
	//定义外部成员变量，观察成员内部类是否有访问权限
	private boolean beap;
	
	private static int count = 0;
	
	private static void doNothing(){
		
	}
	
	class TimerPrinter2 implements ActionListener{
		
//		private static int beapCount = 0; //ERROR
		private static final int beapCount = 0;
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			SimpleDateFormat sdf = new SimpleDateFormat(Const.DATE_PATTERN);
			System.out.println("当前时间:"+ sdf.format(new Date()));
			//可以访问外部成员变量
			if(beap){
				System.out.println("beep.........."+count++);//也可访问外部静态变量
			}
			doNothing();
		}
	}
	
	public static void main(String[] args) {
		//创建外围对象
		TimerTest2 test = new TimerTest2();
		test.beap = true;
		//创建内部对象
		TimerPrinter2 p2 = test.new TimerPrinter2();
		Timer timer = new Timer(1000,p2);
		timer.start();
		JOptionPane.showMessageDialog(null, "退出程序");
		System.exit(0);
	}
	

}
