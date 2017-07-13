package org.ysh.java.core.simpletools;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 函数Frame
 * sin/cos/tan/cot/x
 * @author yshin1992
 *
 */
public class FunctionTool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new FunctionFrame();
	}

}

class FunctionFrame extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private final JPanel container = (JPanel) this.getContentPane();
	
	public FunctionFrame(){
		
		JPanel panel = new JPanel();
		
		final JComboBox<String> funcList = new JComboBox<String>();
		funcList.addItem("y=sinx");
		funcList.addItem("y=cosx");
		funcList.addItem("y=tanx");
		funcList.addItem("y=cotx");
		funcList.addItem("y=x");
		funcList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String func = (String) funcList.getSelectedItem();
				//移除组件
				container.remove(1);
				if("y=sinx".equals(func)){
					container.add(new SinPanel(),BorderLayout.CENTER);
				}else if("y=cosx".equals(func)){
					container.add(new CosPanel(),BorderLayout.CENTER);
				}else if("y=tanx".equals(func)){
					container.add(new TanPanel(),BorderLayout.CENTER);
				}else if("y=cotx".equals(func)){
					container.add(new CotPanel(),BorderLayout.CENTER);
				}else if("y=x".equals(func)){
					container.add(new YXPanel(),BorderLayout.CENTER);
				}
				container.revalidate();
			}
		});
		panel.add(funcList);
		container.add(panel,BorderLayout.NORTH);
		
		container.add(new JPanel(),BorderLayout.CENTER);
		setTitle("Function Frame");
		setSize(1000,400);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}

class SinPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawLine(10, 80, 600, 80);
		g2.drawLine(247,10,247,150);
		
		g2.drawString("O", 247, 90);
		g2.drawString("π/2", 325, 90);
		g2.drawString("π", 404, 90);
		g2.drawString("-π/2", 170, 90);
		g2.drawString("-π", 90, 90);
		//从坐标原点向两个方向绘制
		double startX = 247;
		double startY = 80;
		int step = 0;
		//负方向
		for(double x = 0;x>=-Math.PI;x-=0.01){
			double y = Math.sin(x);
			Line2D line = new Line2D.Double(startX, startY, 247 - step*0.01*50, 80 - y*50);
			g2.draw(line);
			startX = 247- step*0.01*50;
			startY = 80 - y*50;
			step++;
		}
		
		step = 0;
		startX = 247;
		startY = 80;
		//正方向
		for(double x=0;x<=Math.PI;x+=0.01){
			double y = Math.sin(x);
			Line2D line = new Line2D.Double(startX, startY, 247 + step*0.01*50, 80 - y*50);
			g2.draw(line);
			startX = 247+ step*0.01*50;
			startY = 80 - y*50;
			step++;
		}
	}
	
	
}


class CosPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawLine(10, 80, 600, 80);
		g2.drawLine(247,10,247,150);
		g2.drawString("O", 247, 90);
		g2.drawString("π/2", 325, 90);
		g2.drawString("π", 404, 90);
		g2.drawString("-π/2", 170, 90);
		g2.drawString("-π", 90, 90);
		//从坐标原点向两个方向绘制
		double startX = 247;
		double startY = 80;
		int step = 0;
		//负方向
		for(double x = 0;x>=-Math.PI;x-=0.01){
			double y = Math.cos(x);
			Line2D line = new Line2D.Double(startX, startY, 247 - step*0.01*50, 80 - y*50);
			g2.draw(line);
			startX = 247- step*0.01*50;
			startY = 80 - y*50;
			step++;
		}
		
		step = 0;
		startX = 247;
		startY = 80;
		//正方向
		for(double x=0;x<=Math.PI;x+=0.01){
			double y = Math.cos(x);
			Line2D line = new Line2D.Double(startX, startY, 247 + step*0.01*50, 80 - y*50);
			g2.draw(line);
			startX = 247+ step*0.01*50;
			startY = 80 - y*50;
			step++;
		}
	}
	
}

class TanPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawLine(10, 80, 600, 80);
		g2.drawLine(247,10,247,150);
		g2.drawString("O", 247, 90);
		g2.drawString("π/2", 325, 90);
		g2.drawString("π", 404, 90);
		g2.drawString("-π/2", 170, 90);
		g2.drawString("-π", 90, 90);
		//从坐标原点向两个方向绘制
		double startX = 247;
		double startY = 80;
		int step = 0;
		//负方向
		for(double x = 0;x>=-Math.PI;x-=0.01){
			double y = Math.tan(x);
			Line2D line = new Line2D.Double(startX, startY, 247 - step*0.01*50, 80 - y*50);
			g2.draw(line);
			startX = 247- step*0.01*50;
			startY = 80 - y*50;
			step++;
		}
		
		step = 0;
		startX = 247;
		startY = 80;
		//正方向
		for(double x=0;x<=Math.PI;x+=0.01){
			double y = Math.tan(x);
			Line2D line = new Line2D.Double(startX, startY, 247 + step*0.01*50, 80 - y*50);
			g2.draw(line);
			startX = 247+ step*0.01*50;
			startY = 80 - y*50;
			step++;
		}
	}
	
}

class CotPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawLine(10, 80, 600, 80);
		g2.drawLine(247,10,247,150);
		g2.drawString("O", 247, 90);
		g2.drawString("π/2", 325, 90);
		g2.drawString("π", 404, 90);
		g2.drawString("-π/2", 170, 90);
		g2.drawString("-π", 90, 90);
		//从坐标原点向两个方向绘制
		double startX = 247;
		double startY = 80;
		int step = 0;
		//负方向
		for(double x = 0;x>=-Math.PI;x-=0.01){
			double y = Math.tan(x+Math.PI/2);
			Line2D line = new Line2D.Double(startX, startY, 247 - step*0.01*50, 80 - y*50);
			g2.draw(line);
			startX = 247- step*0.01*50;
			startY = 80 - y*50;
			step++;
		}
		
		step = 0;
		startX = 247;
		startY = 80;
		//正方向
		for(double x=0;x<=Math.PI;x+=0.01){
			double y = Math.tan(x+Math.PI/2);
			Line2D line = new Line2D.Double(startX, startY, 247 + step*0.01*50, 80 - y*50);
			g2.draw(line);
			startX = 247+ step*0.01*50;
			startY = 80 - y*50;
			step++;
		}
	}
	
}


class YXPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.drawLine(10, 120, 600, 120);
		g2.drawLine(247,10,247,230);
		
		g2.drawString("O", 247, 130);
		g2.drawString("-100", 147, 130);
		g2.drawString("100", 347, 130);
		g2.drawString("100", 247, 20);
		g2.drawString("-100", 247, 220);
		
		g2.drawLine(147, 220, 347, 20);
	}
	
}