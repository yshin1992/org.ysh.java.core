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
 * 
 * @author yshin1992
 *
 */
public class TimerTest3 {
	private boolean beap = true;
	
	void beap(){
		class TimerPrinter3 implements ActionListener{
			
//			private static int count = 0;//ERROR
			
			private int count = 0;
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SimpleDateFormat sdf = new SimpleDateFormat(Const.DATE_PATTERN);
				System.out.println("当前时间:"+ sdf.format(new Date()));
				this.count ++ ;
				if(beap){
					System.out.println("beep.........." + count);
				}
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
