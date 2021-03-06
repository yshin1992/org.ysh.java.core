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

import javax.swing.JPanel;

import org.ysh.java.core.tank.v1.Const;
import org.ysh.java.core.tank.v1.TankComponent;
import org.ysh.java.core.tank.v2.stages.Stage;
import org.ysh.java.core.tank.v2.stages.Stage1;

public class TankPanelV2 extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TankComponent tank;
	
	//关卡场景
	private Stage stage;
	
	private List<TankComponent> selfList = new ArrayList<TankComponent>();
	
	private String content = "You win";

	private boolean isFinished = false;
	
	public void setFinished(boolean isFinished) {
		this.isFinished = isFinished;
	}

	@Override
	public void paint(Graphics g) {
		//加上这行代码才行
		super.paint(g);
		
		Graphics2D g2D = (Graphics2D) g;
		
		
		g2D.setColor(Color.black);
		g2D.fill(new Rectangle2D.Double(0,0,ConfigUtil.getAreaWidth(),ConfigUtil.getAreaHeight()));
		
		if(!isFinished){
			//描绘关卡的障碍物
			List<Rectangle2D> walls = stage.getWalls();
			g2D.setColor(Color.white);
			for(Rectangle2D wall : walls){
				g2D.fill3DRect((int)wall.getX(),(int)wall.getY(),(int)wall.getWidth(),(int)wall.getHeight(),true);
			}
			
			g2D.setColor(Color.yellow);
			if(null != tank && tank.isAlive()){
				g2D.fill3DRect((int)tank.getWheel1().getX(),(int)tank.getWheel1().getY(),(int)tank.getWheel1().getWidth(),(int)tank.getWheel1().getHeight(),true);
				g2D.fill3DRect((int)tank.getWheel2().getX(),(int)tank.getWheel2().getY(),(int)tank.getWheel2().getWidth(),(int)tank.getWheel2().getHeight(),true);
				g2D.fill3DRect((int)tank.getBody().getX(),(int)tank.getBody().getY(),(int)tank.getBody().getWidth(),(int)tank.getBody().getHeight(),true);
				g2D.fill3DRect((int)tank.getBarrel().getX(),(int)tank.getBarrel().getY(),(int)tank.getBarrel().getWidth(),(int)tank.getBarrel().getHeight(),true);
			}

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
			
			List<TankComponent> enemis = stage.getEnemis();
			for(TankComponent enemy:enemis){
				if(null == enemy || !enemy.isAlive()){
					continue;
				}
				
				g2D.setColor(Color.GRAY);
				g2D.fill3DRect((int)enemy.getWheel1().getX(),(int)enemy.getWheel1().getY(),(int)enemy.getWheel1().getWidth(),(int)enemy.getWheel1().getHeight(),true);
				g2D.fill3DRect((int)enemy.getWheel2().getX(),(int)enemy.getWheel2().getY(),(int)enemy.getWheel2().getWidth(),(int)enemy.getWheel2().getHeight(),true);
				g2D.fill3DRect((int)enemy.getBody().getX(),(int)enemy.getBody().getY(),(int)enemy.getBody().getWidth(),(int)enemy.getBody().getHeight(),true);
				g2D.fill3DRect((int)enemy.getBarrel().getX(),(int)enemy.getBarrel().getY(),(int)enemy.getBarrel().getWidth(),(int)enemy.getBarrel().getHeight(),true);
				
				List<Bullet> ebullets = enemy.getBullets();
				if(ObjectUtil.collectionNotEmpty(ebullets)){
					g2D.setColor(Color.white);
					for(Bullet bullet : ebullets){
						Point2D bp = bullet.getPosition();
						g2D.fillOval((int)bp.getX(), (int)bp.getY(), 4, 4);
					}
				}
			}
		}else{
			g2D.drawString(content, 200, 150);
		}
	}

	public TankPanelV2() {
		super();
		this.addKeyListener(new KeyEventListener());
		
		tank = new TankComponent(new Point2D.Double(ConfigUtil.getAreaWidth()/2-80,ConfigUtil.getAreaHeight()-40),Const.DIRECTION_UP);
		
		List<TankComponent> ourselves = new ArrayList<TankComponent>();
		ourselves.add(tank);
		stage = new Stage1(this,ourselves);
		List<TankComponent> enemis = stage.getEnemis();
		
		List<TankComponent> tankList = new ArrayList<TankComponent>();
		tankList.addAll(enemis);
		tankList.add(tank);
		
		for(TankComponent enemy:enemis){
			List<TankComponent> tanks = new ArrayList<TankComponent>(tankList);
			tanks.remove(enemy);
			new TankRunThread(enemy,this,tanks,ourselves,stage).start();
		}
		
		
	}
	
	class KeyEventListener implements KeyListener{
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if(!tank.isAlive())
				return;
			List<TankComponent> enemis = stage.getEnemis();
			Point2D position = tank.getPosition();
			double x = position.getX();
			double y = position.getY();
			int direct = tank.getDirection();
			if(e.getKeyCode() == KeyEvent.VK_W){
				
				if(y > 0 && direct ==  Const.DIRECTION_UP && !tank.isOverride(direct, enemis, stage)){
					y-=ConfigUtil.getRunStep();
				}
				direct = Const.DIRECTION_UP;
			}else if(e.getKeyCode() == KeyEvent.VK_S){
				
				if(y <= ConfigUtil.getAreaHeight()-60 && direct ==  Const.DIRECTION_DOWN && !tank.isOverride(direct, enemis, stage)){
					y+=ConfigUtil.getRunStep();
				}
				direct = Const.DIRECTION_DOWN;
				
			}else if(e.getKeyCode() == KeyEvent.VK_A){
				
				if(x>=ConfigUtil.getRunStep() && direct ==  Const.DIRECTION_LEFT && !tank.isOverride(direct, enemis, stage)){
					x-=ConfigUtil.getRunStep();
				}
				direct = Const.DIRECTION_LEFT;
			}else if(e.getKeyCode() == KeyEvent.VK_D){
				
				if(x<= ConfigUtil.getAreaWidth()-60  && direct ==  Const.DIRECTION_RIGHT && !tank.isOverride(direct, enemis, stage)){
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
				tank.fire(point, tank.getDirection(), 1, TankPanelV2.this,enemis,stage);
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
