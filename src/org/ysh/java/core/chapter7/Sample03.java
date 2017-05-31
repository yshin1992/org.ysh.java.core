package org.ysh.java.core.chapter7;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * 使用Graphics2D绘制图形
 * @author yshin1992
 *
 */
public class Sample03 {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new Draw2DFrame();
			}
		});
	}
}

class Draw2DFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Draw2DFrame(){
		setTitle("Draw 2D");
		setSize(400,400);
		
		Draw2DComponent comp = new Draw2DComponent();
		this.add(comp);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}

class Draw2DComponent extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		
		double leftX = 100;
		double topY = 100;
		
		double width = 200;
		double height = 150;
		
		Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);
		g2D.setColor(Color.RED);
		g2D.draw(rect);
		
		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rect);
		g2D.setColor(Color.BLUE);
		g2D.draw(ellipse);
		
		double centerX = rect.getCenterX();
		double centerY = rect.getCenterY();
		
		double radius = Math.sqrt(200*200 + 150*150)/2;
		
		Ellipse2D circle = new Ellipse2D.Double();
		circle.setFrameFromCenter(centerX, centerY, centerX+radius, centerY+radius);
		g2D.setColor(Color.ORANGE);
		g2D.draw(circle);
		
		Line2D line = new Line2D.Double(leftX,topY, leftX+width, topY+height);
		g2D.setColor(Color.GRAY);
		g2D.draw(line);
		
		Line2D line2 = new Line2D.Double(leftX,topY+height, leftX+width, topY);
		g2D.setColor(Color.GRAY);
		g2D.draw(line2);
	}
	
}
