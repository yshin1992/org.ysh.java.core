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
import org.ysh.java.core.tank.v2.ConfigUtil;
import org.ysh.java.core.tank.v2.ObjectUtil;
import org.ysh.java.core.tank.v2.stages.Stage;

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
	
	private boolean isAlive = true;
	
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
	
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean isAlive() {
		return isAlive;
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
	public void fire(Point2D point,int direction,int speed,JPanel panel,List<TankComponent> enemies,Stage stage){
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
			new BulletThread(bullet,panel,enemies,stage).start();
		}
	}
	
	/**
	 * 判断是不是和其他场景或者tank重叠
	 * @param direct
	 * @param others
	 * @param stage
	 * @return
	 */
	public boolean isOverride(int direct,List<TankComponent> others,Stage stage){
		Point2D ltPos = this.getPosition();
		switch (direct) {
		case Const.DIRECTION_UP:
			return isOverride(new Rectangle2D.Double(ltPos.getX(), ltPos.getY()-ConfigUtil.getRunStep(),40,40),others,stage);
		case Const.DIRECTION_DOWN:
			return isOverride(new Rectangle2D.Double(ltPos.getX(), ltPos.getY()+ConfigUtil.getRunStep(),40,40),others,stage);
		case Const.DIRECTION_LEFT:
			return isOverride(new Rectangle2D.Double(ltPos.getX()-ConfigUtil.getRunStep(), ltPos.getY(),40,40),others,stage);
		case Const.DIRECTION_RIGHT:
			return isOverride(new Rectangle2D.Double(ltPos.getX()+ConfigUtil.getRunStep(), ltPos.getY(),40,40),others,stage);
		default:
			break;
		}
		return false;
	}
	
	private boolean isOverride(Rectangle2D rect,List<TankComponent> others,Stage stage){
		
		int selfXmin = (int) rect.getX();
		int selfXmax = (int) (rect.getX() + 40);
		int selfYmin = (int) rect.getY();
		int selfYmax = (int) (rect.getY() + 40);
		
		//判断是不是和其他tank相重叠
		if(ObjectUtil.collectionNotEmpty(others)){
			for(TankComponent other : others){
				Point2D tmp = other.getPosition();
				int otherXmin = (int) tmp.getX();
				int otherXmax = (int) (tmp.getX() + 40);
				int otherYmin = (int) tmp.getY();
				int otherYmax = (int) (tmp.getY() + 40);
				
				boolean contains = (selfXmin < otherXmax && selfXmax > otherXmin && selfYmin < otherYmax && selfYmax > otherYmin) || (otherXmin == selfXmin && otherYmin == selfYmin);
				if(contains){
					System.out.println(tmp);
					return contains;
				}
			}
		}
		
		//判断是不是和其他场景物重叠
		List<Rectangle2D> walls = stage.getWalls();
		if(ObjectUtil.collectionNotEmpty(walls)){
			for(Rectangle2D wall : walls){
				
				int otherXmin = (int) wall.getX();
				int otherXmax = (int) (wall.getX() + 20);
				int otherYmin = (int) wall.getY();
				int otherYmax = (int) (wall.getY() + 20);
				
				boolean contains = selfXmin < otherXmax && selfXmax > otherXmin && selfYmin < otherYmax && selfYmax > otherYmin;
				if(contains){
					System.out.println(wall);
					return contains;
				}
			}
		}
		
		return false;
	}
	
	
}
