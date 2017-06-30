package org.ysh.java.core.tank.v2;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.List;

import javax.swing.JPanel;

import org.ysh.java.core.tank.v1.Const;
import org.ysh.java.core.tank.v1.TankComponent;
import org.ysh.java.core.tank.v2.stages.Stage;

/**
 * 子弹线程
 * @author yshin1992
 *
 */
public class BulletThread extends Thread {

	private Bullet bullet;
	
	private JPanel panel;
	
	private List<TankComponent> enemies;
	
	private Stage stage;
	
	public BulletThread(Bullet bullet,JPanel panel,List<TankComponent> enemies,Stage stage) {
		this.bullet = bullet;
		this.panel = panel;
		this.enemies = enemies;
		this.stage = stage;
	}
	
	public void setEnemies(List<TankComponent> enemies) {
		this.enemies = enemies;
	}

	@Override
	public void run() {
		while(bullet.isAlive()){
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			updateBullet(bullet);
			panel.repaint();
		}
	}
	
	private void updateBullet(Bullet bullet){
		Point2D pos = bullet.getPosition();
		double x = pos.getX();
		double y = pos.getY();
		int direct = bullet.getDirection();
		int speed = bullet.getSpeed();
		
		int step = speed * ConfigUtil.getBulletStep();
		
		switch (direct) {
		case Const.DIRECTION_UP:
			y -= step;
			break;
		case Const.DIRECTION_DOWN:
			y += step;
			break;
		case Const.DIRECTION_LEFT:
			x -= step;
			break;
		case Const.DIRECTION_RIGHT:
			x += step;
			break;
		default:
			break;
		}
		bullet.setPosition(new Point2D.Double(x,y));
		judgeAlive(bullet);
	}
	
	/**
	 * 判断子弹是否击中目标或超过边界
	 * @param x
	 * @param y
	 */
	private void judgeAlive(Bullet bullet){
		//是否超过边界
		Point2D pos = bullet.getPosition();
		double x = pos.getX();
		double y = pos.getY();
		
		int selfXmin = (int)x;
		int selfXmax = (int)x + 4;
		int selfYmin = (int)y;
		int selfYmax = (int)y + 4;
		
		Rectangle2D ell = new Rectangle2D.Double(x, y, 4, 4);
		if(x < 0 || x > ConfigUtil.getAreaWidth() || y<0 || y> ConfigUtil.getAreaHeight()){
			bullet.setAlive(false);
		}
		
		//是否击中物体
		List<Rectangle2D> walls = stage.getWalls();
		Iterator<Rectangle2D> wallIter = walls.iterator();
		while(wallIter.hasNext()){
			Rectangle2D wall = wallIter.next();
			
			int otherXmin = (int) wall.getX();
			int otherXmax = (int) (wall.getX() + 20);
			int otherYmin = (int) wall.getY();
			int otherYmax = (int) (wall.getY() + 20);
			
			boolean contains = selfXmin < otherXmax && selfXmax > otherXmin && selfYmin < otherYmax && selfYmax > otherYmin;
			if(contains){
				bullet.setAlive(false);
				break;
			}
			
		}
		
		int count = enemies.size();
		boolean enemisDestroyed = false;
		//是否击中地方Tank
		Iterator<TankComponent> iter = enemies.iterator();
		while(iter.hasNext()){
			TankComponent tc = iter.next();
			if(null != tc){
				Point2D point = tc.getPosition();
				Rectangle2D rect = new Rectangle2D.Double(point.getX(),point.getY(),40,40);
				
				if(rect.contains(ell)){
					bullet.setAlive(false);
					tc.setAlive(false);
					iter.remove();
					enemisDestroyed = true;
					break;
				}
				
			}
		}
		//生成一辆新tank
		if(count > 2 && enemisDestroyed){
			stage.newTank(stage.getAlreadyCount() + 1);
		}
		
	}
	
}
