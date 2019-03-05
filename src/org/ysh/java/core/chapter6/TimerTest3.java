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
 * 局部内部类适用于不想公用的，或者只是临时辅助解决问题的类
 * 局部内部类同样不能定义类变量和类方法
 * 局部内部类可以访问外部类的类成员和普通成员，也可以调用外部类的类方法和普通方法
 * 局部内部类访问局部变量时，局部变量需声明为final(JDK1.8后可以不用这么声明)
 * @author yshin1992
 *
 */
public class TimerTest3 {
	private boolean beap = true;
	
	private static int countdown = 0;
	
	private static void setCountdown(int countdown){
		TimerTest3.countdown = countdown;
	}
	
	private void doNothing(){
		
	}
	void beap(){
		final boolean doBeap = true;
		class TimerPrinter3 implements ActionListener{
			
//			private static int count = 0;//ERROR
			
			private int count = 0;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat(Const.DATE_PATTERN);
				System.out.println("当前时间:"+ sdf.format(new Date()));
				this.count ++ ;
				if(beap && doBeap){
					System.out.println("beep.........." + count);
				}
				
				countdown++;//可以访问外部类的普通成员和类成员
				setCountdown(1);//可以访问外部的类方法和普通方法
				doNothing();
			}
		}
		Timer timer = new Timer(1000,new TimerPrinter3());
		timer.start();
		JOptionPane.showMessageDialog(null, "退出程序");
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new TimerTest3().beap();
	}

}
