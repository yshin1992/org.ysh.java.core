package org.ysh.java.core.chapter8;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

/**
 * 动作
 * @author yshin1992
 *
 */
public class Sample04 {

	public static void main(String[] args) {
		new ColorActionFrame();
	}
	
}

class ColorActionFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	
	public ColorActionFrame() {
		panel = new JPanel();
		
		makeBtn("blue",Color.blue,KeyStroke.getKeyStroke("ctrl B"));
		makeBtn("yellow",Color.yellow,KeyStroke.getKeyStroke("ctrl Y"));
		makeBtn("red",Color.red,KeyStroke.getKeyStroke("ctrl R"));
		add(panel);
		this.setVisible(true);
		this.setSize(400,200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	void makeBtn(String name,Color c,KeyStroke ks){
		Action action = new ColorAction(name, c);
		System.out.println(action.isEnabled());
		if(c == Color.red){
			action.setEnabled(false);
		}
		panel.add(new JButton(action));
		//设置快捷键
		InputMap im = panel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
		im.put(ks, name);
		
		ActionMap am = panel.getActionMap();
		am.put(name, action);
	}
	
	
	class ColorAction extends AbstractAction{

		private static final long serialVersionUID = 1L;
		
		public ColorAction(String title,Color c) {
			this.putValue(Action.NAME, title);
			this.putValue("color", c);
			this.putValue(Action.SHORT_DESCRIPTION, "set panel color to " + title.toLowerCase());
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Color c = (Color) getValue("color");
			panel.setBackground(c);
		}
		
	}
}
