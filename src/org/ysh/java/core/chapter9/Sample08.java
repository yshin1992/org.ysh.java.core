package org.ysh.java.core.chapter9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

/**
 * JMenu 菜单
 * 常规菜单 菜单项
 * 单选框按钮菜单项 复选框菜按钮单项
 * 分隔符
 * 弹出菜单
 * 
 * 快捷字符使用方式 Alt + 快捷字符
 * @author yansh
 *
 */
public class Sample08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MenuFrame();
	}

	public static class MenuFrame extends JFrame{

		private static final long serialVersionUID = 1L;
		
		//菜单
		JMenu menu,appearMenu;
		//菜单项 保存，剪切，复制，删除
		JMenuItem saveItem,cutItem,copyItem,deleteItem,exitItem;
		//菜单栏
		JMenuBar bar;
		
		ActionListener defaultListener;
		
		//外观
		LookAndFeelInfo[] installedLookAndFeels = UIManager.getInstalledLookAndFeels();
		//单选框按钮组
		ButtonGroup appearBtnGroup;
		
		//弹出菜单
		JPopupMenu popMenu;
		//位置菜单项
		JMenuItem posItem;
		//用于显示弹出菜单的面板
		JPanel panel;
		
		public MenuFrame() {
			//初始化菜单栏	
			bar = new JMenuBar();
			
			defaultListener = new DefaultItemActionListener();
			//文件菜单
			menu = new JMenu("File(Alt+F)");
			//设置快捷字符
			menu.setMnemonic('F');
			bar.add(menu);
			
			saveItem = new JMenuItem("Save(Ctrl+S)");
			saveItem.addActionListener(defaultListener);
			saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));
			menu.add(saveItem);
			
		
			cutItem = new JMenuItem("Cut(Ctrl+X)");
			cutItem.addActionListener(defaultListener);
			cutItem.setAccelerator(KeyStroke.getKeyStroke("ctrl X"));
			menu.add(cutItem);
			
			copyItem = new JMenuItem("Copy(Ctrl+C)",'C');
			copyItem.addActionListener(defaultListener);
			copyItem.setAccelerator(KeyStroke.getKeyStroke("ctrl C"));
			menu.add(copyItem);
			
			deleteItem = new JMenuItem("Delete(Ctrl+D)");
			deleteItem.setMnemonic('D');
			deleteItem.addActionListener(defaultListener);
			deleteItem.setAccelerator(KeyStroke.getKeyStroke("ctrl D"));
			menu.add(deleteItem);
			
			//添加分隔符
			menu.addSeparator();
			
			exitItem =  new JMenuItem("Exit(Ctrl+E)");
			exitItem.addActionListener(defaultListener);
			exitItem.setAccelerator(KeyStroke.getKeyStroke("ctrl E"));
			menu.add(exitItem);
			
			appearMenu = new JMenu("Appearence(Alt+A)");
			appearMenu.setMnemonic('A');
			appearBtnGroup = new ButtonGroup();
			for(LookAndFeelInfo laf : installedLookAndFeels) {
				JRadioButtonMenuItem radioBtnItem = new JRadioButtonMenuItem(new DeafultAction(laf.getName(),laf));
				appearBtnGroup.add(radioBtnItem);
				appearMenu.add(radioBtnItem);
			}
			
			appearMenu.addSeparator();
			//复选框按钮菜单项
			JCheckBoxMenuItem item = new JCheckBoxMenuItem(new AbstractAction("Selected") {
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(e.getActionCommand());
				}
			});
			appearMenu.add(item);
			bar.add(appearMenu);
			
			popMenu = new JPopupMenu("Pop");
			posItem = new JMenuItem("position");
			posItem.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(e.getActionCommand());
				}
			});
			popMenu.add(posItem);
			
			panel = new JPanel();
			this.add(panel);
			//下面展示了两种弹出菜单的使用方式
//			panel.setComponentPopupMenu(popMenu);
			panel.addMouseListener(new MouseAdapter() {

				@Override
				public void mousePressed(MouseEvent e) {
					if(popMenu.isPopupTrigger(e)) {
						System.out.println("Mouse Pressed");
						popMenu.show(e.getComponent(), e.getX(), e.getY());
					}
				}
				
				@Override
				public void mouseReleased(MouseEvent e) {
					if(popMenu.isPopupTrigger(e)) {
						System.out.println("Mouse Pressed");
						popMenu.show(e.getComponent(), e.getX(), e.getY());
					}
				}
			});
			
			this.setJMenuBar(bar);
			this.setSize(400, 400);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setVisible(true);
		}	
		
		class DefaultItemActionListener implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				String ac = e.getActionCommand();
				System.out.println(ac);
			}
			
		}
		
		class DeafultAction extends AbstractAction{

			private static final long serialVersionUID = 1L;
			
			private LookAndFeelInfo laf;
			
			public DeafultAction(String label,LookAndFeelInfo laf) {
				super(label);
				this.laf = laf;
			}
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String ac = e.getActionCommand();
				System.out.println(ac);
				
				try {
					UIManager.setLookAndFeel(laf.getClassName());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(MenuFrame.this);
			}
			
		}
		
	}
}
