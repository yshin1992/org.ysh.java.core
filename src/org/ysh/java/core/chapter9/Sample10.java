package org.ysh.java.core.chapter9;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class Sample10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ToolFrame();
	}

	public static class ToolFrame extends JFrame{

		private static final long serialVersionUID = 1L;
		
		JToolBar toolBar;
		
		JButton redBtn,blueBtn,yellowBtn;
		//用于展示颜色的面板
		JPanel panel;
		
		public ToolFrame() {
			toolBar = new JToolBar();
			
			redBtn = new JButton("Red");
			redBtn.addActionListener(new ColorActionListener(Color.RED));
			redBtn.setToolTipText("Red");
			
			blueBtn = new JButton("Blue");
			blueBtn.addActionListener(new ColorActionListener(Color.BLUE));
			blueBtn.setToolTipText("Blue");
			
			yellowBtn = new JButton("Yellow");
			yellowBtn.addActionListener(new ColorActionListener(Color.YELLOW));
			yellowBtn.setToolTipText("Yellow");
			
			toolBar.add(redBtn);
			toolBar.add(blueBtn);
			toolBar.add(yellowBtn);
			
			this.add(toolBar,BorderLayout.NORTH);
			panel = new JPanel();
			this.add(panel,BorderLayout.CENTER);
			
			this.setSize(400, 400);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
			
			
		}
		
		class ColorActionListener implements ActionListener{
			
			private Color c;
			public ColorActionListener(Color c) {
				super();
				this.c = c;
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setBackground(c);
			}
			
		}
	}
}
