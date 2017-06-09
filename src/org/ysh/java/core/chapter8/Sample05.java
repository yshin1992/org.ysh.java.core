package org.ysh.java.core.chapter8;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * 监听鼠标事件
 * @author yshin1992
 *
 */
public class Sample05 {

	public static void main(String[] args) {

	}

}

class MouseFrame extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public MouseFrame() {
		setTitle("mouse Frame");
		
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		
		JComponent mc = new MouseComponent();
		add(mc);
		
		this.setSize(screenSize.width/2,screenSize.height/2);
		this.setLocationByPlatform(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}

class MouseComponent extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Rectangle2D> squares;
	
	private Rectangle2D current;
	
	public MouseComponent() {
		squares = new ArrayList<Rectangle2D>();
		
	}

	@Override
	protected void printComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		for(Rectangle2D r : squares){
			g2D.draw(r);
		}
	}
	
	
	
	
}
