package org.ysh.java.core.chapter8;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * 适配器类
 * @author yshin1992
 *
 */
public class Sample03 {

	public static void main(String[] args) {
		new AdapterFrame();
	}
}
class AdapterFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public AdapterFrame() {
		this.addWindowListener(new WinAdapter());
		
		this.addWindowFocusListener(new FocusAdapter());
		
		this.addWindowStateListener(new StateAdapter());
		//开启窗口关闭处理
		enableEvents(WindowEvent.WINDOW_CLOSING);
		
		this.setVisible(true);
		this.setSize(400,200);
	}


	@Override
	protected void processWindowEvent(WindowEvent e) {
		//监听窗口关闭
		if(e.getID() == WindowEvent.WINDOW_CLOSING){
			if(JOptionPane.showConfirmDialog( null , "确认关闭窗口?") == JOptionPane.YES_OPTION){
				System.exit(0);
			}else{
				System.out.println("kkkkk");
				return;
			}
		}else{
			super.processWindowEvent(e);
		}
	}
}

class WinAdapter implements WindowListener{

	//窗口打开后调用这个方法
	@Override
	public void windowOpened(WindowEvent e) {
		System.out.println("窗口已经被打开，窗口当前状态:"+e.getNewState());
	}

	//当发出窗口管理器命令关闭窗口时调用这个方法
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("窗口管理器命令关闭窗口");
	}

	//窗口关闭后调用这个方法
	@Override
	public void windowClosed(WindowEvent e) {
		System.out.println("窗口已关闭");
	}

	//窗口图标化调用这个方法
	@Override
	public void windowIconified(WindowEvent e) {
		System.out.println("窗口图标化");
	}

	//窗口非图标化调用这个方法
	@Override
	public void windowDeiconified(WindowEvent e) {
		System.out.println("窗口非图标化");
	}

	//激活窗口后调用这个方法
	@Override
	public void windowActivated(WindowEvent e) {
		System.out.println("激活窗口");
	}

	//窗口变为未激活状态调用这个方法
	@Override
	public void windowDeactivated(WindowEvent e) {
		System.out.println("窗口未激活");
	}
}

class FocusAdapter implements WindowFocusListener{

	//窗口获得焦点时调用这个方法
	@Override
	public void windowGainedFocus(WindowEvent e) {
		System.out.println("窗口获得了焦点");
	}

	//窗口失去焦点时调用这个方法
	@Override
	public void windowLostFocus(WindowEvent e) {
		System.out.println("窗口失去了焦点");
	}
	
}

class StateAdapter implements WindowStateListener{

	@Override
	public void windowStateChanged(WindowEvent e) {
		System.out.println("窗口由 " + translateState(e.getOldState()) +" --> " + translateState(e.getNewState()));	
	}
	
	String translateState(int state){
		switch (state) {
		case Frame.NORMAL:
			return "窗口正常化";
		case Frame.ICONIFIED:
			return "窗口图标化";
		case Frame.MAXIMIZED_HORIZ:
			return "窗口水平最大化";
		case Frame.MAXIMIZED_VERT:
			return "窗口垂直最大化";
		case Frame.MAXIMIZED_BOTH:
			return "窗口最大化";

		default:
			break;
		}
		
		return "";
	}
	
}