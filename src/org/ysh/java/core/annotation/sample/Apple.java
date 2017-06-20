package org.ysh.java.core.annotation.sample;

public class Apple {

	@FruitName(value="apple")
	private String appleNm;
	
	@FruitColor
	private String appleColor;

	@FruitProvider(id=1,name="陕西红富士集团",address="陕西省西安市延安路89号红富士大厦")
    private String appleProvider;
	
	public String getAppleNm() {
		return appleNm;
	}

	public void setAppleNm(String appleNm) {
		this.appleNm = appleNm;
	}

	public String getAppleColor() {
		return appleColor;
	}

	public void setAppleColor(String appleColor) {
		this.appleColor = appleColor;
	}

	@Override
	public String toString() {
		return "Apple [appleNm=" + appleNm + ", appleColor=" + appleColor + "]";
	}
	
	
}
