package org.ysh.java.core.annotation;

import java.lang.annotation.Inherited;

@Inherited
public @interface Greeting {

	public enum FontColor{BLUE,RED,YELLOW};
	
	String name();
	
	FontColor fontColor() default FontColor.BLUE;
	
}
