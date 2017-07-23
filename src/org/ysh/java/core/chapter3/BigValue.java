package org.ysh.java.core.chapter3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/**
 * Java中的大数值
 * BigInteger/BigDecimal
 * @author yshin1992
 *
 */
public class BigValue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger bigInt1 = new BigInteger("1382333223342331");
		BigInteger bigInt2 = BigInteger.valueOf(1222323332344534L);
		BigInteger add = bigInt1.add(bigInt2);
		System.out.println(add.toString());
		BigInteger subtract = bigInt1.subtract(bigInt2);
		System.out.println(subtract.toString());
		
		BigInteger multiply = bigInt1.multiply(bigInt2);
		System.out.println(multiply.toString());
		
		BigInteger divide = bigInt1.divide(bigInt2);
		System.out.println(divide.toString());
		
		BigDecimal decimal1 = new BigDecimal(bigInt1);
		BigDecimal decimal2 = BigDecimal.valueOf(1222323332344534L);
//		BigDecimal divide2 = decimal1.divide(decimal2);
//		System.out.println(divide2.toString());
		BigDecimal divide3 = decimal1.divide(decimal2, 2, RoundingMode.HALF_UP);
		System.out.println(divide3.toString());
	
	}

}
