package org.ysh.java.core.simpletools;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
				// TODO Auto-generated method stub
				new LayoutFrame();
			}
		});
		
		setTitle("Tool Collection");
		setSize(600,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
