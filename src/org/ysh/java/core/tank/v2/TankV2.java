package org.ysh.java.core.tank.v2;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TankV2 {

	public static void main(String[] args) {
		new TankFrameV2();
	}
	
}

class TankFrameV2 extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel panel;
	
	public TankFrameV2() {
		panel = new TankPanelV2();
		this.add(panel);
		panel.setFocusable(true);
		this.setSize(ConfigUtil.getWindowWidth(),ConfigUtil.getWindowHeight());
		this.setLocationByPlatform(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
}


