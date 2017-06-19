package org.ysh.java.core.tank;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

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
//		Dimension screenSize = kit.getScreenSize();
		panel = new TankPanel();
		this.add(panel);
		panel.setFocusable(true);
		this.setSize(1000,800);
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

	public int x=10,y=10;
	
	private static final int WIDTH = 800,HEIGHT = 800;

	private TankComponent tank = new TankComponent(new Point2D.Double(10,10),Const.UP);
	
	@Override
	public void paint(Graphics g) {
		//加上这行代码才行
		super.paint(g);
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setColor(Color.gray);
		g2D.fill(new Rectangle2D.Double(0,0,800,800));
		
		g2D.setColor(Color.yellow);
		g2D.fill(tank.getWheel1());
		g2D.fill(tank.getWheel2());
		g2D.fill(tank.getBody());
		g2D.fill(tank.getBarrel());
		
		
	}

	public TankPanel() {
		super();
		this.addKeyListener(new KeyEventListener());
	}
	
	class KeyEventListener implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			Point2D position = tank.getPosition();
			double x = position.getX();
			double y = position.getY();
			int direct = 0;
			if(e.getKeyCode() == KeyEvent.VK_W){
				if(y > 0){
					y-=20;
				}
				direct = Const.UP;
//				y-=5;
			}else if(e.getKeyCode() == KeyEvent.VK_S){
//				y+=5;
				if(y <= WIDTH-20){
					y+=20;
				}
				direct = Const.DOWN;
				
			}else if(e.getKeyCode() == KeyEvent.VK_A){
//				x-=5;
				x-=20;
				direct = Const.LEFT;
			}else if(e.getKeyCode() == KeyEvent.VK_D){
//				x+=5;
				x+=20;
				direct = Const.RIGHT;
			}
			tank.setPosition(new Point2D.Double(x,y), direct);
			tank.drawComponent();
			repaint();
		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		}
	}
}

