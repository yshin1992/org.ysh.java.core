package org.ysh.java.core.chapter9;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalculatorWin {

	public static void main(String[] args) {

		new CalculatorFrame();
		
	}

}

class CalculatorFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	//按钮所在的面板
	private JPanel btnPanel;
	
	//用于显示文本的按钮
	private JButton display;
	
	private double result = 0;
	
	private String lastCmd="";
	
	private boolean start = true;
	
	public CalculatorFrame(){
		setLayout(new BorderLayout());
		display = new JButton();
		add(display,BorderLayout.NORTH);
		
		btnPanel = new JPanel();
		btnPanel.setLayout(new GridLayout(4,4));
		
		ActionListener cmdAction = new CommandAction();
		ActionListener typeAction = new TypeAction();
		
		btnPanel.add(makeBtn("7", typeAction));
		btnPanel.add(makeBtn("8", typeAction));
		btnPanel.add(makeBtn("9", typeAction));
		btnPanel.add(makeBtn("/", cmdAction));
		
		btnPanel.add(makeBtn("4", typeAction));
		btnPanel.add(makeBtn("5", typeAction));
		btnPanel.add(makeBtn("6", typeAction));
		btnPanel.add(makeBtn("*", cmdAction));
		
		btnPanel.add(makeBtn("1", typeAction));
		btnPanel.add(makeBtn("2", typeAction));
		btnPanel.add(makeBtn("3", typeAction));
		btnPanel.add(makeBtn("-", cmdAction));
		
		btnPanel.add(makeBtn("0", typeAction));
		btnPanel.add(makeBtn(".", typeAction));
		btnPanel.add(makeBtn("=", cmdAction));
		btnPanel.add(makeBtn("+", cmdAction));
		
		add(btnPanel);
		
//		pack();
		setSize(400,400);
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
	}
	
	private JButton makeBtn(String title,ActionListener action){
		JButton btn = new JButton(title);
		btn.addActionListener(action);
		return btn;
	}
	
	//点击按钮时的响应事件
	private class TypeAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String input = e.getActionCommand();
			if(start){
				display.setText("");
				start = false;
			}
			display.setText(display.getText()+input);
		}
		
	}
	
	
	private class CommandAction implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String cmd = e.getActionCommand();
			if(start){
				if("-".equals(cmd)){
					display.setText(cmd);
					start = false;
				}
				else
				{
					lastCmd = cmd;
				}
			}else{
				display.setText(String.valueOf(calculate(Double.valueOf(display.getText()))));
				lastCmd = cmd;
				start = true;
				
			}
		}
		
		private double calculate(double val){
			if("*".equals(lastCmd)){
				result *= val;
			}else if("/".equals(lastCmd)){
				result /= val;
			}else if("+".equals(lastCmd)){
				result += val;
			}else if("-".equals(lastCmd)){
				result -= val;
			}else if("=".equals(lastCmd)){
				result = val;
			}
			return result;
		}
	}
	

}