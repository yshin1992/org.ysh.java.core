package org.ysh.java.core.chapter6;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * 计时器
 * @author yshin1992
 *
 */

public class TimerTest1{
	
	public static void main(String[] args) {
		Timer timer = new Timer(1000,new TimerPrinter1());
		timer.start();
		JOptionPane.showMessageDialog(null, "退出程序");
		System.exit(0);
	}
}

/**
 * 外部类
 * @author yshin1992
 *
 */
class TimerPrinter1 implements ActionListener{
	@Override
	public void actionPerformed(ActionEvent e) {
		SimpleDateFormat sdf = new SimpleDateFormat(Const.DATE_PATTERN);
		System.out.println("当前时间:"+ sdf.format(new Date()));
	}

}

