package org.ysh.java.core.tank.v2;

import java.awt.geom.Point2D;
import java.util.List;

import javax.swing.JPanel;

import org.ysh.java.core.tank.v1.Const;
import org.ysh.java.core.tank.v1.TankComponent;
import org.ysh.java.core.tank.v2.stages.Stage;

/**
 * Tank自动行驶线程
 * @author yshin1992
 *
 */
public class TankRunThread extends Thread {
	
	private TankComponent self;
	
	private JPanel panel;
	
	private List<TankComponent> others;
	
	private List<TankComponent> enemies;
	
	private Stage stage;
	
	private boolean isStarted = false;
	
	//让tank沿着一条方向直行一段时间，而不是随时随刻都在变换方向的计数变量
	private int count = 0;
	
	public TankRunThread(TankComponent self,JPanel panel,List<TankComponent> others,List<TankComponent> enemies,Stage stage) {
		this.self = self;
		this.panel = panel;
		this.others = others;
		this.stage = stage;
		this.enemies = enemies;
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
		while(true && self.isAlive()){
			try {
				sleep(300);
				updateTank(self);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	private void updateTank(TankComponent tank){
		Point2D currentPos = tank.getPosition();
		double currentX = currentPos.getX();
		double currentY = currentPos.getY();
		int direct = tank.getDirection();
		if(count == Integer.MAX_VALUE){
			count = 0;
		}
		
		if(count ++ % 3 == 0){
			Point2D point = null;
			//判断方向决定发送的位置
			switch (tank.getDirection()) {
			case Const.DIRECTION_UP:
				point = new Point2D.Double(currentX+18,currentY);
				break;
			case Const.DIRECTION_DOWN:
				point = new Point2D.Double(currentX+18,currentY+40);
				break;
			case Const.DIRECTION_LEFT:
				point = new Point2D.Double(currentX,currentY+18);
				break;
			case Const.DIRECTION_RIGHT:
				point = new Point2D.Double(currentX+40,currentY+18);
				break;
			}
			
			self.fire(point, direct, 1, panel, enemies, stage);
		}
		
		if(count ++ % 5 == 0){
			direct = (int) (Math.floor(Math.random()*4) + 1);
		}
		
		switch (direct) {
		case Const.DIRECTION_UP:
			if(currentY > 0 && !tank.isOverride(direct, others, stage)){
				currentY-=ConfigUtil.getRunStep();
			}
			break;
		case Const.DIRECTION_DOWN:
			//这里减60的原因是(40+20)
			if(currentY <= ConfigUtil.getAreaHeight()-60  && !tank.isOverride(direct, others, stage)){
				currentY+=ConfigUtil.getRunStep();
			}
			break;
		case Const.DIRECTION_LEFT:
			if(currentX>=ConfigUtil.getRunStep() && !tank.isOverride(direct, others, stage)){
				currentX-=ConfigUtil.getRunStep();
			}
			break;
		case Const.DIRECTION_RIGHT:
			if(currentX <= ConfigUtil.getAreaHeight()-60 && !tank.isOverride(direct, others, stage)){
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
