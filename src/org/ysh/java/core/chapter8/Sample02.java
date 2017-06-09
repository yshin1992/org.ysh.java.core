package org.ysh.java.core.chapter8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * 改变组件的观感
 * @author yshin1992
 *
 */
public class Sample02 {
	public static void main(String[] args) {
		new LAFIFrame();
		
	}
	
}


class LAFIFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	
	private JMenuBar mbar;

	private JMenu lafmenu;
	
	public LAFIFrame() {
		panel = new JPanel();
		makeBtns();
		this.add(panel);
		
		mbar = new JMenuBar();
		lafmenu = new JMenu("Appearance");
		mbar.add(lafmenu);
		makeMenus();
		setJMenuBar(mbar);
		this.setVisible(true);
		this.setSize(400,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	private void makeBtns(){
		LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
		if(null != installedLookAndFeels && installedLookAndFeels.length>0){
			for(LookAndFeelInfo laf : installedLookAndFeels){
				JButton btn = new JButton(laf.getName());
				panel.add(btn);
				btn.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							UIManager.setLookAndFeel(laf.getClassName());
							SwingUtilities.updateComponentTreeUI(LAFIFrame.this);
						} catch (Exception e1) {
							e1.printStackTrace();
						} 
					}
				});
				System.out.println(laf.getName() + " : " + laf.getClassName());
			}
		}
	}
	
	private void makeMenus(){
		LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
		if(null != installedLookAndFeels && installedLookAndFeels.length>0){
			for(LookAndFeelInfo laf : installedLookAndFeels){
				JMenuItem item = new JMenuItem(laf.getName());
				lafmenu.add(item);
				item.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							UIManager.setLookAndFeel(laf.getClassName());
							SwingUtilities.updateComponentTreeUI(LAFIFrame.this);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				});
			}
		}
	}
}

