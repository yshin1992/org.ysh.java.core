package org.ysh.java.core.chapter3;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
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
		
		BigDecimal one = BigDecimal.ONE;
		BigDecimal one2 = BigDecimal.valueOf(1);
		BigDecimal one3 = new BigDecimal("0");
		BigDecimal one4 = BigDecimal.valueOf(1.0);
		
		System.out.println(one == one2);
		
		System.out.println(one == one3);
		
		System.out.println(one2 == one4);
		
		System.out.println(BigDecimal.valueOf(-1) == BigDecimal.valueOf(-1));
		
		BigInteger sixteen = BigInteger.valueOf(-16);
		BigInteger sixteen2 = BigInteger.valueOf(-16);
		System.out.println(sixteen == sixteen2);
		
		BigInteger seventeen = BigInteger.valueOf(-17);
		BigInteger seventeen2 = BigInteger.valueOf(-17);
		System.out.println(seventeen == seventeen2);
	}

}
