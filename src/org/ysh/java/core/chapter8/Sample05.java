package org.ysh.java.core.chapter8;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * 监听鼠标事件
 * @author yshin1992
 *
 */
public class Sample05 {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new MouseFrame();
			}
		});
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
		mc.setFocusable(true);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
}

class MouseComponent extends JComponent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Integer SIDELEN = 10;
	
	private List<Rectangle2D> squares;
	
	private Rectangle2D current;
	
	public MouseComponent() {
		squares = new ArrayList<Rectangle2D>();
		addMouseListener(new MouseHandler());
		addMouseMotionListener(new MouseMotionHandler());
		addKeyListener(new KeyEventListener());
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D g2D = (Graphics2D) g;
		for(Rectangle2D r : squares){
			g2D.draw(r);
		}
	}
	
	public Rectangle2D find(Point2D point){
		for(Rectangle2D r : squares){
			if(r.contains(point)){
				return r;
			}
		}
		return null;
	}
	
	public void add(Point2D p){
		double x = p.getX();
		double y = p.getY();
		
		current = new Rectangle2D.Double(x-SIDELEN/2,y-SIDELEN/2,SIDELEN,SIDELEN);
		
		squares.add(current);
		repaint();
	}
	
	public void remove(Rectangle2D rect){
		if(null == rect){
			return;
		}
		if(null == current){
			current = null;
		}
		
		squares.remove(rect);
		repaint();
	}
	
	private class MouseHandler extends MouseAdapter{

		@Override
		public void mouseClicked(MouseEvent e) {
			current = find(e.getPoint());
			if(null != current && e.getClickCount()==2)
				remove(current);
		}

		@Override
		public void mousePressed(MouseEvent e) {
			current = find(e.getPoint());
			if(null == current){
				add(e.getPoint());
			}
			
		}
		
	}
	
	class KeyEventListener implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println(e.getKeyChar());
		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println(e.getKeyChar());
			double x = current.getX();
			double y = current.getY();
			if(null != current){
				if(e.getKeyCode() == KeyEvent.VK_W){
					y-=5;
				}else if(e.getKeyCode() == KeyEvent.VK_S){
					y+=5;
				}else if(e.getKeyCode() == KeyEvent.VK_A){
					x-=5;
				}else if(e.getKeyCode() == KeyEvent.VK_D){
					x+=5;
				}
			}
			current.setFrame(x-SIDELEN/2,y-SIDELEN/2,SIDELEN,SIDELEN);
			repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}
	}
	
	
	private class MouseMotionHandler implements MouseMotionListener{

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			if(current != null){
				int x = e.getX();
				int y = e.getY();
				
				current.setFrame(x-SIDELEN/2,y-SIDELEN/2,SIDELEN,SIDELEN);
				repaint();
			}
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			if(find(e.getPoint()) == null){
				setCursor(Cursor.getDefaultCursor());
			}else{
				setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
			}
		}
		
	}
	
}
