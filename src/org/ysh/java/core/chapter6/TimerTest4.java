package org.ysh.java.core.chapter6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * Java中内部类主要分为成员内部类、局部内部类、匿名内部类、静态内部类
 * 匿名内部类
 * 1.匿名内部类是没有访问修饰符的
 * 2.new 匿名内部类，这个类（接口或者抽象类）首先是要存在的
 * 3.匿名内部类是没有构造方法的,因为它连名字都没有何来构造方法
 * 4.匿名内部类中使用到的参数必须使用final修饰符修饰(注JDK1.8及以上去除了这个特性)
 * @author yshin1992
 *
 */
public class TimerTest4 {
	
	private int count = 0;
	
	public void beap(final boolean beap,String nonce){
		Timer timer = new Timer(1000,new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat(Const.DATE_PATTERN);
				System.out.println("当前时间:"+ sdf.format(new Date()));
				
				if(beap){
					//它可以访问外部的成员变量和类变量
					System.out.println("beep.........." + count++);
				}				
			}
		});
		timer.start();
		JOptionPane.showMessageDialog(null, "退出程序");
		System.exit(0);
	}
	public static void main(String[] args) {
		new TimerTest4().beap(true, "llll");
	}

}
