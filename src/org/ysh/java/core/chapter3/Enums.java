package org.ysh.java.core.chapter3;

/**
 * 枚举常量
 */
public enum Enums{

	First,Second,Third,Forth,Fifth,Sixth,Seventh
}

enum Weekday{
	MONDAY(1,"周一","Mon"),Tudesday(2,"周二","Tue"),Wednesday(3,"周三","Wed"),Thursday(4,"周四","Thu"),Friday(5,"周五","Fri"),Saturday(6,"周六","Sat"),Sunday(7,"周日","Sun");

	private Integer value;
	
	private String chineseNm;
	
	private String simpleNm;
	
	private Weekday(Integer value,String chineseNm,String simpleNm) {
		this.value = value;
		this.chineseNm = chineseNm;
		this.simpleNm = simpleNm;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getChineseNm() {
		return chineseNm;
	}

	public void setChineseNm(String chineseNm) {
		this.chineseNm = chineseNm;
	}

	public String getSimpleNm() {
		return simpleNm;
	}

	public void setSimpleNm(String simpleNm) {
		this.simpleNm = simpleNm;
	}
	
	
}