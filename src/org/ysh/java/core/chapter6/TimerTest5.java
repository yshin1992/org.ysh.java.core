package org.ysh.java.core.chapter6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * Java中内部类主要分为成员内部类、局部内部类、匿名内部类、静态内部类
 * 静态内部类
 * 如果只是出于将一个类隐藏于另一个中，那么静态内部类将是很好的选择
 * @author yshin1992
 *
 */
public class TimerTest5 {
	private static boolean beap;
	
	private int count = 0;
	public static class TimerPrinter5 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			SimpleDateFormat sdf = new SimpleDateFormat(Const.DATE_PATTERN);
			System.out.println("当前时间:"+ sdf.format(new Date()));
			if(beap){
//				System.out.println("beep.........." + count);//ERROR
				System.out.println("beep..........");
			}
		}
	}
	
	public static void main(String[] args) {
		//静态内部类可以直接初始化
		TimerPrinter5 tp5 = new TimerPrinter5();
		Timer timer = new Timer(1000,tp5);
		timer.start();
		JOptionPane.showMessageDialog(null, "退出程序");
		System.exit(0);
	}
}
