package org.ysh.java.core.chapter9;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

/**
 * 边框Border
 * @author yshin1992
 *
 */
public class Sample06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sample06 s06 = new Sample06();
		s06.new BorderFrame();
	}

	public class BorderFrame extends JDialog{
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private JPanel demo;
		
		private JPanel btnPanel;
		
		private ButtonGroup group;
		
		public BorderFrame(){
			setTitle("Border Style");
			setSize(500,200);
			
			demo = new JPanel();
			btnPanel = new JPanel();
			group = new ButtonGroup();
			
			addRadioButton("lowered bevel", BorderFactory.createLoweredBevelBorder());
			addRadioButton("Raised bevel",BorderFactory.createRaisedBevelBorder());
			addRadioButton("Etched",BorderFactory.createEtchedBorder());
			addRadioButton("Line",BorderFactory.createLineBorder(Color.blue));
			addRadioButton("Matte",BorderFactory.createMatteBorder(10, 10, 10, 10, Color.blue));
			addRadioButton("Empty",BorderFactory.createEmptyBorder());
			
			setLayout(new GridLayout(2,1));
			
			add(btnPanel);
			add(demo);
			
			setVisible(true);
			setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			
			
		}
		
		private void addRadioButton(String title,final Border border){
			JRadioButton btn = new JRadioButton(title);
			btn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					demo.setBorder(border);
				}
			});
			
			group.add(btn);
			btnPanel.add(btn);
		}
	}
	
}
