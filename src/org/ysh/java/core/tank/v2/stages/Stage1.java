package org.ysh.java.core.tank.v2.stages;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import org.ysh.java.core.tank.v1.Const;
import org.ysh.java.core.tank.v1.TankComponent;
import org.ysh.java.core.tank.v2.ConfigUtil;
import org.ysh.java.core.tank.v2.TankPanelV2;
import org.ysh.java.core.tank.v2.TankRunThread;
/**
 * 第一关游戏界面场景布局
 * @author yshin1992
 *
 */
public class Stage1 implements Stage{

	private TankPanelV2 panel;
	
	/**
	 * 城墙
	 */
	private final List<Rectangle2D> walls = new ArrayList<Rectangle2D>(); 
	
	/**
	 * 敌军Tank
	 */
	private final List<TankComponent> enemis = new ArrayList<TankComponent>();
	
	private List<TankComponent> ourselves = new ArrayList<TankComponent>(); 
	
	private int count = 0;
	
	/**
	 * 树木和河流
	 * 。。。这里先省略，后期添加
	 */
	
	public Stage1(TankPanelV2 panel,List<TankComponent> ourselves){
		
		this.panel = panel;
		this.ourselves = ourselves;
		int area_width = ConfigUtil.getAreaWidth();
		int area_height = ConfigUtil.getAreaHeight();
		
		//围墙
		walls.add(new Rectangle2D.Double(area_width/2-40,area_height-20,20,20));
		walls.add(new Rectangle2D.Double(area_width/2-40,area_height-40,20,20));
		
		walls.add(new Rectangle2D.Double(area_width/2-40,area_height-60,20,20));
		walls.add(new Rectangle2D.Double(area_width/2-40 + 20,area_height-60,20,20));
		walls.add(new Rectangle2D.Double(area_width/2-40 + 40,area_height-60,20,20));
		walls.add(new Rectangle2D.Double(area_width/2-40 + 60,area_height-60,20,20));
		
		walls.add(new Rectangle2D.Double(area_width/2-40 + 60,area_height-40,20,20));
		walls.add(new Rectangle2D.Double(area_width/2-40 + 60,area_height-20,20,20));
		
		//先初始化 三台 tank
		TankComponent enemy1 = new TankComponent(new Point2D.Double(0,0),Const.DIRECTION_DOWN);
		TankComponent enemy2 = new TankComponent(new Point2D.Double((ConfigUtil.getAreaWidth()-40)/2,0),Const.DIRECTION_DOWN);
		TankComponent enemy3 = new TankComponent(new Point2D.Double(ConfigUtil.getAreaWidth()-40,0),Const.DIRECTION_DOWN);
		
		enemis.add(enemy1);
		enemis.add(enemy2);
		enemis.add(enemy3);
		
		count = 3;
	}

	@Override
	public List<Rectangle2D> getWalls() {
		return walls;
	}

	@Override
	public List<TankComponent> getEnemis() {
		return enemis;
	}

	@Override
	public void newTank(int count) {
		this.count = count;
		System.out.println(count);
	/*	if(count == 6){
			panel.setFinished(true);
			panel.repaint();
			return;
		}*/
		
		if(count > 20){
			return;
		}
		TankComponent newTank = null;
		if(count % 3 == 0){
			newTank = new TankComponent(new Point2D.Double(ConfigUtil.getAreaWidth()-40,0),Const.DIRECTION_DOWN);
		}else if(count % 3 == 1){
			newTank = new TankComponent(new Point2D.Double(0,0),Const.DIRECTION_DOWN);
		}else if(count % 3 == 2){
			newTank = new TankComponent(new Point2D.Double((ConfigUtil.getAreaWidth()-40)/2,0),Const.DIRECTION_DOWN);
		}
		
		List<TankComponent> tanks = new ArrayList<TankComponent>(enemis);
		tanks.addAll(ourselves);
		enemis.add(newTank);
		new TankRunThread(newTank,panel,tanks,ourselves,this).start();
	}

	@Override
	public int getAlreadyCount() {
		return count;
	}
}
