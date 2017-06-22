package org.ysh.java.core.tank.v2;

import java.awt.geom.Point2D;

import javax.swing.JPanel;

import org.ysh.java.core.tank.v1.Const;

/**
 * 子弹线程
 * @author yshin1992
 *
 */
public class BulletThread extends Thread {

	private Bullet bullet;
	
	private JPanel panel;
	
	public BulletThread(Bullet bullet,JPanel panel) {
		this.bullet = bullet;
		this.panel = panel;
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
		Point2D pos = bullet.getPosition();
		double x = pos.getX();
		double y = pos.getY();
		if(x < 0 || x > ConfigUtil.getAreaWidth() || y<0 || y> ConfigUtil.getAreaHeight()){
			bullet.setAlive(false);
		}
	}
	
}
