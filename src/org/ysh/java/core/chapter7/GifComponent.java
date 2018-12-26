package org.ysh.java.core.chapter7;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

public class GifComponent extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JFileChooser chooser = new JFileChooser("C:/Users/yshin1992/Pictures");
	
	private JMenuBar bar;
	
	private JMenu menu;
	
	private JMenuItem openItem;
	
	private JLabel label;
	
	public GifComponent(){
		
		chooser.setFileFilter(new FileNameExtensionFilter("GIF file","gif"));
		
		bar = new JMenuBar();
		
		menu = new JMenu("文件");
		menu.setMnemonic('F');
		
		label = new JLabel();
		openItem = new JMenuItem("Open");
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
		openItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int result = chooser.showOpenDialog(GifComponent.this);
				if(result == JFileChooser.APPROVE_OPTION){
					File gifFile = chooser.getSelectedFile();
					label.setIcon(new ImageIcon(gifFile.getAbsolutePath()));
				}
			}
		});
		bar.add(menu);
		menu.add(openItem);
		
		this.setJMenuBar(bar);
		this.add(label);
		this.setSize(400,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new GifComponent();
			}
		});
	}

}
