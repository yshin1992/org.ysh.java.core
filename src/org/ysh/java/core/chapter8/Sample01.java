package org.ysh.java.core.chapter8;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Sample01 {
	 public static void main(String[] args) {
		 new ColorFrame3();
	}
}

class ColorFrame extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel btnPanel;
	
	private JButton blueBtn,yellowBtn,redBtn;
	
	public ColorFrame(){
		
		btnPanel = new JPanel();
		blueBtn = new JButton("Blue");
		yellowBtn = new JButton("Yellow");
		redBtn = new JButton("Red");
		
		btnPanel.add(blueBtn);
		btnPanel.add(yellowBtn);
		btnPanel.add(redBtn);
		this.add(btnPanel);
		
		//添加事件
		blueBtn.addActionListener(new ColorAction(Color.BLUE));
		yellowBtn.addActionListener(new ColorAction(Color.YELLOW));
		redBtn.addActionListener(new ColorAction(Color.RED));
		
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	class ColorAction implements ActionListener{

		private Color color;
		
		public ColorAction(Color color){
			this.color = color;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			btnPanel.setBackground(color);
		}
		
	}
}

/**
 * 使用匿名内部类，为每个按钮添加事件监听器
 * @author yshin1992
 *
 */
class ColorFrame2 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel btnPanel;
	
	public ColorFrame2() {
		btnPanel = new JPanel();
		
		makeBtn("Blue",Color.BLUE);
		makeBtn("Yellow",Color.YELLOW);
		makeBtn("Red",Color.RED);
		
		this.add(btnPanel);
		this.setVisible(true);
		this.setSize(400,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private void makeBtn(String label,final Color color){
		JButton btn = new JButton(label);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnPanel.setBackground(color);
			}
		});
		btnPanel.add(btn);
	}
}


class ColorFrame3 extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel btnPanel;
	
	private JButton blueBtn,yellowBtn,redBtn;
	
	public ColorFrame3() {
		
		btnPanel = new JPanel();
		blueBtn = new JButton("Blue");
		yellowBtn = new JButton("Yellow");
		redBtn = new JButton("Red");
		
		blueBtn.addActionListener(this);
		yellowBtn.addActionListener(this);
		redBtn.addActionListener(this);
		
		btnPanel.add(blueBtn);
		btnPanel.add(yellowBtn);
		btnPanel.add(redBtn);
		this.add(btnPanel);
		this.setVisible(true);
		this.setSize(400,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == blueBtn){
			btnPanel.setBackground(Color.BLUE);
		}else if(e.getSource() == yellowBtn){
			btnPanel.setBackground(Color.YELLOW);
		}else if(e.getSource() == redBtn){
			btnPanel.setBackground(Color.RED);
		}
	}
}
