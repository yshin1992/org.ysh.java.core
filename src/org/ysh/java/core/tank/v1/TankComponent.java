package org.ysh.java.core.tank.v1;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JPanel;

import org.ysh.java.core.tank.v2.Bullet;
import org.ysh.java.core.tank.v2.BulletThread;
import org.ysh.java.core.tank.v2.ObjectUtil;

public class TankComponent {
	final Lock lock = new ReentrantLock();
	Rectangle2D wheel1 = new Rectangle2D.Double(),
			wheel2 = new Rectangle2D.Double(),
			body = new Rectangle2D.Double(),
			barrel = new Rectangle2D.Double();
	
	Point2D position;

	/**
	 * 发射的子弹
	 */
	List<Bullet> bullets = new ArrayList<Bullet>();
	
	public List<Bullet> getBullets() {
		Iterator<Bullet> iter = bullets.iterator();
		while(iter.hasNext()){
			Bullet tmp = iter.next();
			if(!tmp.isAlive()){
				iter.remove();
			}
		}	
		return bullets;
	}

	//tank默认等级为1
	private int level = 1;
	
	int direction;//1 上 2下 3 左 4右
	
	public TankComponent(Point2D initPos,int initDirect){
		this.position = initPos;
		this.direction = initDirect;
		wheel1 = new Rectangle2D.Double();
		this.drawComponent();
	}
	
	public int getDirection() {
		return direction;
	}

	public Rectangle2D getWheel1() {
		return wheel1;
	}

	public Rectangle2D getWheel2() {
		return wheel2;
	}

	public Rectangle2D getBody() {
		return body;
	}

	public Rectangle2D getBarrel() {
		return barrel;
	}

	public Point2D getPosition() {
		return position;
	}

	public void setPosition(Point2D pos,int direct){
		this.position = pos;
		this.direction = direct;
	}
	
	public void drawComponent(){
		switch(this.direction){
		case Const.DIRECTION_UP:
			upComponent(this.position);break;
		case Const.DIRECTION_DOWN:
			downComponent(this.position);break;
		case Const.DIRECTION_LEFT:
			leftComponent(this.position);break;
		case Const.DIRECTION_RIGHT:
			rightComponent(this.position);break;
		}
	}
	
	/**
	 * 设计向上的组件布局
	 * @param p
	 */
	private void upComponent(Point2D p){
		double x = p.getX();
		double y = p.getY();
		wheel1.setRect(new Rectangle2D.Double(x,y+10,10,30));
		wheel2.setRect(new Rectangle2D.Double(x+30,y+10,10,30));
		body.setRect(new Rectangle2D.Double(x+10,y+15,20,20));
		barrel.setRect(new Rectangle2D.Double(x+18,y,4,15));
	}
	
	private void downComponent(Point2D p){
		double x = p.getX();
		double y = p.getY();
		wheel1.setRect(new Rectangle2D.Double(x,y,10,30));
		wheel2.setRect(new Rectangle2D.Double(x+30,y,10,30));
		body.setRect(new Rectangle2D.Double(x+10,y+5,20,20));
		barrel.setRect(new Rectangle2D.Double(x+18,y+25,4,15));
	}
	
	private void leftComponent(Point2D p){
		double x = p.getX();
		double y = p.getY();
		wheel1.setRect(new Rectangle2D.Double(x+10,y,30,10));
		wheel2.setRect(new Rectangle2D.Double(x+10,y+30,30,10));
		body.setRect(new Rectangle2D.Double(x+15,y+10,20,20));
		barrel.setRect(new Rectangle2D.Double(x,y+18,15,4));
	}
	
	private void rightComponent(Point2D p){
		double x = p.getX();
		double y = p.getY();
		wheel1.setRect(new Rectangle2D.Double(x,y,30,10));
		wheel2.setRect(new Rectangle2D.Double(x,y+30,30,10));
		body.setRect(new Rectangle2D.Double(x+5,y+10,20,20));
		barrel.setRect(new Rectangle2D.Double(x+25,y+18,15,4));
	}
	
	/**
	 * 发射子弹
	 * @param direction
	 * @param speed
	 */
	public void fire(Point2D point,int direction,int speed,JPanel panel){
		if(ObjectUtil.collectionNotEmpty(bullets)){
			Iterator<Bullet> iter = bullets.iterator();
			while(iter.hasNext()){
				Bullet tmp = iter.next();
				if(!tmp.isAlive()){
					iter.remove();
				}
			}
		}
		if(level > bullets.size()){
			Bullet bullet = new Bullet(point,direction,speed);
			bullets.add(bullet);
			new BulletThread(bullet,panel).start();
		}
	}
}
