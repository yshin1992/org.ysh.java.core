package org.ysh.java.core.chapter9;

import java.awt.Color;
import static java.awt.Color.*;

/**
 * 颜色工具类
 * @author yshin1992
 *
 */
public class ColorUtil {

	private static Color[] colors = {
		WHITE,LIGHT_GRAY,GRAY,DARK_GRAY,BLACK,RED,PINK,ORANGE,YELLOW,GREEN,MAGENTA,CYAN
	};
	
	private static String[] color_String = {
		"white","lightGray","gray","darkGray","black","red","pink","orange","yellow","green","megenta","cyan"
	};
	
	/**
	 * 获取系统默认设置的所有颜色
	 * @return
	 */
	public static Color[] getPresetColors(){
		return colors;
	}
	
	/**
	 * 获取对应颜色的名称
	 * @param color
	 * @return
	 */
	public static String getColorName(Color color){
		for(int i = 0;i<colors.length;i++){
			if(color.getRGB() == colors[i].getRGB()){
				return color_String[i];
			}
		}
		return "";
	}
}
