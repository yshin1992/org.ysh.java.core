package org.ysh.java.core.tank.v2.stages;

import java.awt.geom.Rectangle2D;
import java.util.List;

import org.ysh.java.core.tank.v1.TankComponent;

public interface Stage {

	List<Rectangle2D> getWalls();
	
	List<TankComponent> getEnemis();
	
	void newTank(int number);
	
	int getAlreadyCount();
	
}
