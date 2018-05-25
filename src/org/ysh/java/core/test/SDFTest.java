package org.ysh.java.core.test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class SDFTest {

	public static void main(String[] args) {
		Calendar sepDay = Calendar.getInstance();
		sepDay.set(Calendar.YEAR, 2017);
		sepDay.set(Calendar.MONDAY, 10);
		sepDay.set(Calendar.DAY_OF_MONTH, 10);
		
		Date now = new Date();
		boolean after = now.after(sepDay.getTime());
		System.out.println(after);
		System.out.println(new SimpleDateFormat("yyyyMMdd").format(sepDay.getTime()));
		
		BigDecimal bd1 = new BigDecimal(12.05).setScale(2, BigDecimal.ROUND_HALF_UP);
		System.out.println(bd1.toString());
		
		String uid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		System.out.println(uid);
	}
}
