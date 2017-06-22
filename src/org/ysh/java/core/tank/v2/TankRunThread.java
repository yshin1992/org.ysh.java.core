package org.ysh.java.core.tank.v2;

import java.awt.geom.Point2D;

import javax.swing.JPanel;

import org.ysh.java.core.tank.v1.Const;
import org.ysh.java.core.tank.v1.TankComponent;

/**
 * Tank自动行驶线程
 * @author yshin1992
 *
 */
public class TankRunThread extends Thread {
	
	private TankComponent enemy;
	
	private JPanel panel;
	
	private boolean isStarted = false;
	
	public TankRunThread(TankComponent enemy,JPanel panel) {
		this.enemy = enemy;
		this.panel = panel;
	}
	
	@Override
	public void run() {
		if(!isStarted){
			try {
				sleep(1000);
				isStarted = true;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while(true){
			try {
				sleep(500);
				updateTank(enemy);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateTank(TankComponent tank){
		Point2D currentPos = tank.getPosition();
		double currentX = currentPos.getX();
		double currentY = currentPos.getY();
		int direct = (int) (Math.floor(Math.random()*4) + 1);
		
		switch (direct) {
		case Const.DIRECTION_UP:
			if(currentY > 0){
				currentY-=ConfigUtil.getRunStep();
			}
			break;
		case Const.DIRECTION_DOWN:
			//这里减60的原因是(40+20)
			if(currentY <= ConfigUtil.getAreaHeight()-60){
				currentY+=ConfigUtil.getRunStep();
			}
			break;
		case Const.DIRECTION_LEFT:
			if(currentX>=ConfigUtil.getRunStep()){
				currentX-=ConfigUtil.getRunStep();
			}
			break;
		case Const.DIRECTION_RIGHT:
			if(currentX <= ConfigUtil.getAreaHeight()-60){
				currentX+=ConfigUtil.getRunStep();
			}
			break;
		default:
			break;
		}
		
		tank.setPosition(new Point2D.Double(currentX, currentY), direct);
		tank.drawComponent();
		this.panel.repaint();
	}
	
}
