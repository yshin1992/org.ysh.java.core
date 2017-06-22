package org.ysh.java.core.tank.v2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.ysh.java.core.tank.v1.Const;
import org.ysh.java.core.tank.v1.TankComponent;

public class TankV2 {

	public static void main(String[] args) {
		new TankFrameV2();
	}
	
}

class TankFrameV2 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	
	public TankFrameV2() {
		panel = new TankPanelV2();
		this.add(panel);
		panel.setFocusable(true);
		this.setSize(ConfigUtil.getWindowWidth(),ConfigUtil.getWindowHeight());
		this.setLocationByPlatform(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
}


class TankPanelV2 extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TankComponent tank;
	
	private List<TankComponent> enemis = new ArrayList<TankComponent>();	
	
	@Override
	public void paint(Graphics g) {
		//加上这行代码才行
		super.paint(g);
		
		Graphics2D g2D = (Graphics2D) g;
		
		g2D.setColor(Color.black);
		g2D.fill(new Rectangle2D.Double(0,0,ConfigUtil.getAreaWidth(),ConfigUtil.getAreaHeight()));
		
		g2D.setColor(Color.yellow);
		g2D.fill(tank.getWheel1());
		g2D.fill(tank.getWheel2());
		g2D.fill(tank.getBody());
		g2D.fill(tank.getBarrel());

		List<Bullet> bullets = tank.getBullets();
		if(ObjectUtil.collectionNotEmpty(bullets)){
			g2D.setColor(Color.white);
			for(Bullet bullet : bullets){
				if(bullet.isAlive()){
					Point2D bp = bullet.getPosition();
					g2D.fillOval((int)bp.getX(), (int)bp.getY(), 4, 4);
				}
			}
		}
		
		
		for(TankComponent enemy:enemis){
			g2D.setColor(Color.GRAY);
			g2D.fill(enemy.getWheel1());
			g2D.fill(enemy.getWheel2());
			g2D.fill(enemy.getBody());
			g2D.fill(enemy.getBarrel());
			
			List<Bullet> ebullets = enemy.getBullets();
			if(ObjectUtil.collectionNotEmpty(ebullets)){
				g2D.setColor(Color.white);
				for(Bullet bullet : ebullets){
					Point2D bp = bullet.getPosition();
					g2D.fillOval((int)bp.getX(), (int)bp.getY(), 4, 4);
				}
			}
		}
	}

	public TankPanelV2() {
		super();
		this.addKeyListener(new KeyEventListener());
		
		tank = new TankComponent(new Point2D.Double((ConfigUtil.getAreaWidth()-40)/2,ConfigUtil.getAreaHeight()-40),Const.DIRECTION_UP);
		
		TankComponent enemy1 = new TankComponent(new Point2D.Double(0,0),Const.DIRECTION_DOWN);
		TankComponent enemy2 = new TankComponent(new Point2D.Double((ConfigUtil.getAreaWidth()-40)/2,0),Const.DIRECTION_DOWN);
		TankComponent enemy3 = new TankComponent(new Point2D.Double(ConfigUtil.getAreaWidth()-40,0),Const.DIRECTION_DOWN);
		
		enemis.add(enemy1);
		enemis.add(enemy2);
		enemis.add(enemy3);
		
		for(TankComponent enemy:enemis){
			new TankRunThread(enemy,this).start();
		}
		
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
			int direct = tank.getDirection();
			if(e.getKeyCode() == KeyEvent.VK_W){
				
				if(y > 0){
					y-=ConfigUtil.getRunStep();
				}
				direct = Const.DIRECTION_UP;
			}else if(e.getKeyCode() == KeyEvent.VK_S){
				
				if(y <= ConfigUtil.getAreaHeight()-60){
					y+=ConfigUtil.getRunStep();
				}
				direct = Const.DIRECTION_DOWN;
				
			}else if(e.getKeyCode() == KeyEvent.VK_A){
				
				if(x>=ConfigUtil.getRunStep()){
					x-=ConfigUtil.getRunStep();
				}
				direct = Const.DIRECTION_LEFT;
			}else if(e.getKeyCode() == KeyEvent.VK_D){
				
				if(x<= ConfigUtil.getAreaWidth()-60){
					x+=ConfigUtil.getRunStep();
				}
				direct = Const.DIRECTION_RIGHT;
			}else if(e.getKeyCode()== KeyEvent.VK_SPACE){
				Point2D point = null;
				//判断方向决定发送的位置
				switch (tank.getDirection()) {
				case Const.DIRECTION_UP:
					point = new Point2D.Double(x+18,y);
					break;
				case Const.DIRECTION_DOWN:
					point = new Point2D.Double(x+18,y+40);
					break;
				case Const.DIRECTION_LEFT:
					point = new Point2D.Double(x,y+18);
					break;
				case Const.DIRECTION_RIGHT:
					point = new Point2D.Double(x+40,y+18);
					break;
				}
				tank.fire(point, tank.getDirection(), 1, TankPanelV2.this);
				
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

