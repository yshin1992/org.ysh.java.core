package org.ysh.java.core.simpletools;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * 字体工具展示窗口
 * 可以选择字体、样式、大小，查看文本框里的内容展示
 * @author yshin1992
 *
 */
public class FontTextAreaFrame extends JDialog {
	private static final long serialVersionUID = 1L;
	
	private JTextArea field;
	
	private JPanel panel;
	
	private JComboBox<String> fonts;
	
	private JComboBox<Integer> fontSize;
	
	private JCheckBox italic,bold;
	
	private class FontStyleActionListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int mode = 0;
			if(italic.isSelected()){
				mode += Font.ITALIC;
			}
			if(bold.isSelected()){
				mode += Font.BOLD;
			}
			
			Font f = field.getFont();
			field.setFont(new Font(f.getFontName(),mode,f.getSize()));
		}
		
	}
	
	public FontTextAreaFrame(){
		
		panel = new JPanel();
		
		field = new JTextArea();
		field.setText("Pros love iMac. So when they asked us to build them a killer iMac, we went all in. And then we went way, way beyond, creating an iMac packed with the most staggeringly powerful collection of workstation-class graphics, processors, storage, memory, and I/O of any Mac ever. And we did it without adding a millimeter to its iconic all-in-one design. So everyone from video editors to 3D animators to musicians to software developers to scientists can do what they do like they’ve never done before. Introducing iMac Pro. A lean, mean dream machine.");
		field.setLineWrap(true);
		field.setWrapStyleWord(true);
		Font f = new Font("宋体",Font.PLAIN,16);
		field.setFont(f);
		field.setEditable(false);
		
		add(field,BorderLayout.CENTER);
		
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
				Font f = field.getFont();
				field.setFont(new Font(fontName,f.getStyle(),f.getSize()));
			}
		});
		
		
		fontSize = new JComboBox<Integer>();
		for(int i=8;i<=18;i++){
			fontSize.addItem(i);
		}
		fontSize.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int size = (int) fontSize.getSelectedItem();
				Font f = field.getFont();
				field.setFont(new Font(f.getFontName(),f.getStyle(),size));
			}
		});
		
		italic = new JCheckBox("Italic");
		italic.addActionListener(new FontStyleActionListener());
		
		bold = new JCheckBox("bold");
		bold.addActionListener(new FontStyleActionListener());
		
		panel.add(italic);
		panel.add(bold);
		panel.add(fonts);
		panel.add(fontSize);
		add(panel,BorderLayout.SOUTH);
		
		setVisible(true);
		setTitle("字体设置");
		setSize(800,500);
//		setLocationByPlatform(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}
}
