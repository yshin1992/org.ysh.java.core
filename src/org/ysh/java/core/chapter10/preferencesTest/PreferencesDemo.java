package org.ysh.java.core.chapter10.preferencesTest;

import java.util.prefs.Preferences;

public class PreferencesDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String absolutePath="/com/example/preferences";
        Preferences preferences=Preferences.userRoot().node(absolutePath);
        //判断程序是否是第一次运行
        boolean isFirstRun=preferences.getBoolean("firstRun",true);
        if(isFirstRun){
            System.out.println("欢迎使用本程序！");
            preferences.putBoolean("firstRun", false);
        }else{
            System.out.println("这已经不是一次运行了哦~");
        }
	}

}
