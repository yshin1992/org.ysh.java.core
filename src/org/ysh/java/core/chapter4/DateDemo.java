package org.ysh.java.core.chapter4;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * 使用Java中现有的类，这里以Date类为示例
 * @author liuliushouchun
 *
 */
public class DateDemo {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date now = new Date();
		System.out.println(now.toLocaleString());
		
		//格林威治时间
		GregorianCalendar cal = new GregorianCalendar(Locale.CHINA);
		//获取年月日
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		//获取时分秒
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		System.out.println("Now : " + year + "-" + (month+1) + "-" + day + " " + hour + ":" + minute + ":" +second);
		
		int firstDayOfWeek = cal.getFirstDayOfWeek();
		System.out.println("我们国家的一个星期的第一天是:"+firstDayOfWeek);
		
		//设置默认
		Locale.setDefault(Locale.US);
		
		DateFormatSymbols dfs = new DateFormatSymbols();
		String[] shortWeeks = dfs.getShortWeekdays();
		for(String weekDay : shortWeeks)
		{
			System.out.print(weekDay + "\t");
		}
		System.out.println();
		
		String[] shortMonths = dfs.getShortMonths();
		for(String mon : shortMonths)
		{
			System.out.print(mon + "\t");
		}
		System.out.println();
		
		String[] weekDays = dfs.getWeekdays();
		for(String weekDay : weekDays)
		{
			System.out.print(weekDay + "\t");
		}
		System.out.println();
		
		String[] months = dfs.getMonths();
		for(String mon : months)
		{
			System.out.print(mon + "\t");
		}
		System.out.println();
	}
}
