package org.ysh.java.core.chapter9;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Sample05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sample05 sample05 = new Sample05();
		sample05.new RadioBtnFrame();
	}

	
	public class RadioBtnFrame extends JDialog{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		private JPanel btnPanel;
		
		private ButtonGroup btnGroup;
		
		private JLabel label;
		
		private static final int DEFAULT_SIZE = 12;
		
		public RadioBtnFrame(){
			setLayout(new BorderLayout());
			
			setTitle("RadioButton");
			setSize(400,400);
			label = new JLabel("The quick brown fox jumps over the lazy dog.");
			label.setFont(new Font("Serif",Font.PLAIN,DEFAULT_SIZE));
			add(label,BorderLayout.CENTER);
			
			btnPanel = new JPanel();
			btnGroup = new ButtonGroup();
			
			addRadioButton("small", 8);
			addRadioButton("Medium", 12);
			addRadioButton("Large",18);
			addRadioButton("Extra Large",36);
			
			add(btnPanel,BorderLayout.SOUTH);
			setVisible(true);
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
		}
		
		
		private void addRadioButton(String name , final int size){
			boolean selected = size == DEFAULT_SIZE;
			JRadioButton btn = new JRadioButton(name,selected);
			btnGroup.add(btn);
			btnPanel.add(btn);
			
			ActionListener lstner = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					label.setFont(new Font("Serif",Font.PLAIN,size));
				}
			};
			
			btn.addActionListener(lstner);
		}
		
	}
	
}

