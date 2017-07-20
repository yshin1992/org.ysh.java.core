package org.ysh.java.core.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SDFTest {

	public static void main(String[] args) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		System.out.println(new SimpleDateFormat("yyyyMMdd").format(cal.getTime()));
	}
}
