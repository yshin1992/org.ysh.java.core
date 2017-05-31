package org.ysh.java.core.chapter7;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class Sample02 {

	public static void main(String[] args) {
		new DrawFrame();
	}
	
}

class DrawFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	public DrawFrame() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		
		this.setSize(screenSize.width/2,screenSize.height/2);
		this.setLocationByPlatform(true);
		
		Image image = kit.getImage(this.getClass().getClassLoader().getResource("album1.png"));
		this.setIconImage(image);
		
		//设置内容面板
		this.add(new DrawComponent());
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
	}
}


class DrawComponent extends JComponent{

	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		for(int i = 0 ; i<100;i++){
			g.drawString("Hello,world" + i, 0, 50);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			this.repaint();
		}
		
		
	}
	
}
