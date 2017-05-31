package org.ysh.java.core.chapter7;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JFrame;

/**
 * 该示例代码会对JFrame作一个系统介绍
 * @author yshin1992
 *
 */
public class Sample01 {

	public static void main(String[] args) throws IOException {
		new SimpleFrame();
	}
	
}

class SimpleFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	static final int DEFAULT_WIDTH=300;
	static final int DEFAULT_HEIGHT=200;
	
	public SimpleFrame() throws IOException{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置位置
//		setLocation(500,200);
		//由系统决定位置
		setLocationByPlatform(true);
		//设置标题
		setTitle("SimpleFrame");
		
		//与本地窗口系统打交道的工具类Toolkit
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		//获取屏幕大小
		Dimension screenSize = toolkit.getScreenSize();
		//获取屏幕宽和高
		int width = screenSize.width;
		int height = screenSize.height;
		
		//设置图标
		//第一种方式
		//setIconImage(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("album1.png")));
		//使用Toolkit提供的API
		Image img = toolkit.getImage(this.getClass().getClassLoader().getResource("album1.png"));
		setIconImage(img);
		
		//设置框架大小为最大
//		setExtendedState(MAXIMIZED_BOTH);
		
		//显示在其他窗口前
//		toFront();
		
		//显示窗口的后面，并重新排列所有的可见窗口
		toBack();
		
		//设置是否可以改变窗口大小
		setResizable(true);
		
		//设置是否显示标题栏或关闭按钮
		setUndecorated(false);
		
		//这段代码必须，否则显示不出来
		this.setVisible(true);
	}
}