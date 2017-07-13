package org.ysh.java.core.chapter9;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * JTextField
 * @author yshin1992
 *
 */
public class Sample02 {

	
	public static void main(String[] args) {
//		new TextFieldFrame();
		new FontTextFieldFrame();
	}
}

class FontTextFieldFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	private JTextField field;
	
	private JPanel panel;
	
	private JComboBox<String> fonts;
	
	public FontTextFieldFrame(){
		
		panel = new JPanel();
		
		field = new JTextField("Hello,world!世界，你好！");
		Font f = new Font("宋体",Font.PLAIN,16);
		field.setFont(f);
		field.setEditable(false);
		//字体选择列表
		fonts = new JComboBox<String>();
		String[] fontFamilyNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for(int i=0,j=fontFamilyNames.length;i<j;i++){
			fonts.addItem(fontFamilyNames[i]);
		}
		
		fonts.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String fontName = (String) fonts.getSelectedItem();
				field.setFont(new Font(fontName,Font.PLAIN,16));
			}
		});
		
		
		panel.add(field);
		
		
		
		panel.add(fonts);
		add(panel);
		
		setVisible(true);
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class TextFieldFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	private JButton btn;
	
	private JTextField field;
	
	private JPanel panel;
	
	public TextFieldFrame(){
		
		panel = new JPanel();
		
		field = new JTextField(15);
		
		btn = new JButton("revalidate");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Integer col = Integer.parseInt(field.getText());
				field.setColumns(col);
				panel.revalidate();
			}
		});
		
		panel.add(field);
		panel.add(btn);
		
		add(panel);
		
		setVisible(true);
		setSize(400,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
}