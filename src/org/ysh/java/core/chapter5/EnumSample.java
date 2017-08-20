package org.ysh.java.core.chapter5;

import java.util.Scanner;
/**
 * 枚举实例
 * @author liuliushouchun
 *
 */
public class EnumSample {
	enum Season{SPRING("spring"),SUMMER("summer"),AUTUMN("autumn"),WINTER("winter");
		private String season;
		private Season(String season) {
			this.season = season;
		}
		
		public String getSeason() {
			return season;
		}
	};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please Enter a season you like : ");
		String input = sc.next().toUpperCase();
		Season season = Season.valueOf(Season.class, input);
		System.out.println("Season = " + season);
		System.out.println("The value = " + season.getSeason() 
			+ " The ordinal is " + season.ordinal() + " The name is " + season.name() 
			+ " Compare to WINTER is " + season.compareTo(Season.WINTER));
		if(season == Season.SUMMER) {
			System.out.println("You like summer? Me too!");
		}
		sc.close();
	}
	
	
}
