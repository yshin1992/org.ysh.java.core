package org.ysh.java.core.chapter9;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Swing布局管理器
 * JPanel默认使用的是流式布局管理器FlowLayout
 * 而JFrame默认是边框布局管理器BorderLayout
 * @author yshin1992
 *
 */
public class Sample01 {

	//FlowLayout示例
	public static void flowLayout(){
		JFrame frame = new JFrame();
		frame.setLayout(new FlowLayout(FlowLayout.LEFT));
		Color[] presetColors = ColorUtil.getPresetColors();
		for(Color c:presetColors){
			JButton btn = new JButton(ColorUtil.getColorName(c));
			frame.add(btn);
		}
		frame.setTitle("FlowLayout");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//BorderLayout示例
	public static void borderLayout(){
		JFrame frame = new JFrame();
		frame.add(new JButton("North"), java.awt.BorderLayout.NORTH);
		frame.add(new JButton("South"), java.awt.BorderLayout.SOUTH);
		frame.add(new JButton("West"), java.awt.BorderLayout.WEST);
		frame.add(new JButton("East"), java.awt.BorderLayout.EAST);
		frame.add(new JButton("Center"), java.awt.BorderLayout.CENTER);
		
		frame.setTitle("FlowLayout");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//GridLayout(网格布局)示例
	public static void gridLayout(){
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(4,3,3,5));
		Color[] presetColors = ColorUtil.getPresetColors();
		for(Color c:presetColors){
			JButton btn = new JButton(ColorUtil.getColorName(c));
			frame.add(btn);
		}
		frame.setTitle("FlowLayout");
		frame.setSize(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
//		flowLayout();
//		borderLayout();
		gridLayout();
	}
}
