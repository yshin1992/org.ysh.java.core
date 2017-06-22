package org.ysh.java.core.tank.v2;

import java.awt.geom.Point2D;

/**
 * 子弹类
 * @author yshin1992
 *
 */
public class Bullet {

	/**
	 * 子弹是否仍在运行
	 */
	private boolean isAlive = true;
	
	/**
	 * 射击方向
	 */
	private int direction;
	
	/**
	 * 子弹的速度
	 */
	private int speed;
	
	/**
	 * 所处位置
	 */
	private Point2D position;

	public Bullet(Point2D position,int direction,int speed){
		this.position = position;
		this.direction = direction;
		this.speed = speed;
	}
	
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public int getDirection() {
		return direction;
	}

	public Point2D getPosition() {
		return position;
	}

	public int getSpeed() {
		return speed;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}
	
	
}
