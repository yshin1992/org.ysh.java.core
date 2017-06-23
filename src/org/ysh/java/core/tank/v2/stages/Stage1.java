package org.ysh.java.core.tank.v2.stages;

import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;

import org.ysh.java.core.tank.v2.ConfigUtil;
/**
 * 第一关游戏界面场景布局
 * @author yshin1992
 *
 */
public class Stage1 implements Stage{

	/**
	 * 城墙
	 */
	public final List<Rectangle2D> walls = new ArrayList<Rectangle2D>(); 
	
	/**
	 * 树木和河流
	 * 。。。这里先省略，后期添加
	 */
	
	public Stage1(){
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
	}

	@Override
	public List<Rectangle2D> getWalls() {
		return walls;
	}
}
