package org.ysh.java.core.tank;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class TankComponent {
	
	Rectangle2D wheel1 = new Rectangle2D.Double(),
			wheel2 = new Rectangle2D.Double(),
			body = new Rectangle2D.Double(),
			barrel = new Rectangle2D.Double();
	
	Point2D position;
	
	int direction;//1 上 2下 3 左 4右
	
	public TankComponent(Point2D initPos,int initDirect){
		this.position = initPos;
		this.direction = initDirect;
		wheel1 = new Rectangle2D.Double();
		this.drawComponent();
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
		case Const.UP:
			upComponent(this.position);break;
		case Const.DOWN:
			downComponent(this.position);break;
		case Const.LEFT:
			leftComponent(this.position);break;
		case Const.RIGHT:
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
}
