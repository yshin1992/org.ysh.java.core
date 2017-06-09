package org.ysh.java.core.tank;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TankV1 {

	public static void main(String[] args) {
		new TankFrame();
	}
	
}

class TankFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	
	public TankFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		panel = new TankPanel();
		this.add(panel);
		this.setSize(screenSize.width/2,screenSize.height/2);
		this.setLocationByPlatform(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
}


class TankPanel extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int x,y;
	
	@Override
	public void paint(Graphics g) {
		g.drawRect(x, y, 20, 20);
	}

	public TankPanel() {
		this.addKeyListener(new KeyEventListener());
	}
	
	class KeyEventListener implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_W){
				y-=5;
				repaint();
			}else if(e.getKeyCode() == KeyEvent.VK_S){
				y+=5;
				repaint();
			}else if(e.getKeyCode() == KeyEvent.VK_A){
				x-=5;
				repaint();
			}else if(e.getKeyCode() == KeyEvent.VK_D){
				x+=5;
				repaint();
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}
	}
	
	
}

