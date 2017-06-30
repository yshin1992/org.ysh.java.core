package org.ysh.java.core.test;

import java.math.BigDecimal;

public class BigDecimalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigDecimal bd = BigDecimal.ZERO;
		
		bd = bd.add(new BigDecimal(20.1132));
		
		bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
		
		System.out.println(bd.doubleValue());
	}

}
