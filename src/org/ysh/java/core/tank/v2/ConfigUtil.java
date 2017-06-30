package org.ysh.java.core.tank.v2;

import java.util.ResourceBundle;

/**
 * 坦克配置读取工具类
 * @author yshin1992
 *
 */
public class ConfigUtil {
	
	/**
	 * 配置文件名
	 */
	private static final String CONFIG_FILE = "tank_config";
	
	private static final ResourceBundle bundle = ResourceBundle.getBundle(CONFIG_FILE);
	
	/**
	 * 默认的屏幕高度
	 */
	private static final int DEFAULT_WINDOW_HEIGHT = 800;
	
	/**
	 * 默认的屏幕宽度
	 */
	private static final int DEFAULT_WINDOW_WIDTH = 1000;
	
	/**
	 * tank行走的默认步长
	 */
	private static final int DEFAULT_STEP_LENGTH = 20;
	
	/**
	 * 默认的tank行走的区域的高度和宽度
	 */
	private static final int DEFAULT_AREA_HEIGHT = DEFAULT_WINDOW_HEIGHT;
	
	private static final int DEFAULT_AREA_WIDTH = DEFAULT_WINDOW_HEIGHT;
	
	/**
	 * 获取窗口的高度
	 * 默认 800px
	 * @return
	 */
	public static final int getWindowHeight(){
		String string_height = bundle.getString("WINDOW_HEIGHT");
		int height = DEFAULT_WINDOW_HEIGHT;
		if(null != string_height){
			height = Integer.parseInt(string_height);
		}
		return height;
	}
	
	/**
	 * 获取窗口的宽度
	 * 默认 1000px
	 * @return
	 */
	public static final int getWindowWidth(){
		String string_width = bundle.getString("WINDOW_WIDTH");
		int width = DEFAULT_WINDOW_WIDTH;
		if(null != string_width){
			width = Integer.parseInt(string_width);
		}
		return width;
	}
	
	/**
	 * 获取tank活动区域的高度
	 * 默认 800px
	 * @return
	 */
	public static final int getAreaHeight(){
		String string_height = bundle.getString("AREA_HEIGHT");
		int height = DEFAULT_AREA_HEIGHT;
		if(null != string_height){
			height = Integer.parseInt(string_height);
		}
		return height;
	}
	
	/**
	 * 获取tank活动区域的宽度
	 * 默认 800px
	 * @return
	 */
	public static final int getAreaWidth(){
		String string_width = bundle.getString("AREA_WIDTH");
		int width = DEFAULT_AREA_WIDTH;
		if(null != string_width){
			width = Integer.parseInt(string_width);
		}
		return width;
	}
	
	public static final int getRunStep(){
		String string_step = bundle.getString("STEP_LENGTH");
		int step = DEFAULT_STEP_LENGTH;
		if(null != string_step){
			step = Integer.parseInt(string_step);
		}
		return step;
	}
	
	public static final int getBulletStep(){
		return 15;
	}
}
