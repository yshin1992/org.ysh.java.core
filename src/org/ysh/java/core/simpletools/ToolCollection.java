package org.ysh.java.core.simpletools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.ysh.java.core.chapter8.Sample02;
import org.ysh.java.core.chapter8.Sample04;
import org.ysh.java.core.chapter8.Sample05;
import org.ysh.java.core.chapter9.Sample06;

public class ToolCollection extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ToolCollection();
	}

	public ToolCollection(){
		JPanel container = new JPanel();
		add(container);
		JButton funcBtn = new JButton("函数曲线");
		container.add(funcBtn);
		funcBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FunctionFrame();
			}
		});
		
		JButton fontBtn = new JButton("字体设置");
		container.add(fontBtn);
		fontBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FontTextAreaFrame();
			}
		});
		
		JButton domBtn = new JButton("仿DOM元素");
		container.add(domBtn);
		domBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new LayoutFrame();
			}
		});
		
		JButton appearBtn = new JButton("外观Appearence");
		container.add(appearBtn);
		appearBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Sample02 s02 = new Sample02();
				s02.new LAFIFrame();
			}
		});
		
		
		JButton keyStoreBtn = new JButton("快捷键KeyStore");
		container.add(keyStoreBtn);
		keyStoreBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Sample04 s04 = new Sample04();
				s04.new ColorActionFrame();
			}
		});
		
		JButton mouseBtn = new JButton("鼠标事件");
		container.add(mouseBtn);
		mouseBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Sample05 s05 = new Sample05();
				s05.new MouseFrame();
			}
		});
		
		
		JButton borderBtn = new JButton("Border样式");
		container.add(borderBtn);
		borderBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Sample06 s06 = new Sample06();
				s06.new BorderFrame();
			}
		});
		
		JButton ftpBtn = new JButton("SFTP");
		container.add(ftpBtn);
		borderBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new JSFTPFrame();
			}
		});
		
		JButton unicodeBtn = new JButton("Unicode<-->String");
		container.add(unicodeBtn);
		unicodeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new String2UnicodeWindow();
			}
		});
		
		setTitle("Tool Collection");
		setSize(600,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
