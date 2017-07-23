package org.ysh.java.core.chapter3;

import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileInputStream;
/**
* 文件输入输出
*/
public class FileInputOutput{
	
	private static final String PATH_INPUT = "E:/develop/Git/JavaCore/chapter3/src/Operator.java";

	private static final String PATH_OUTPUT = "F:/tmp.txt";

	public static void main(String[] args) throws Exception
	{
		Scanner scan = new Scanner(new FileInputStream(new File(PATH_INPUT)));
		int lines = 0;
		while(scan.hasNext())
		{
			System.out.println(lines + ": " +scan.nextLine());
		}
		scan.close();
		
		String userDir = System.getProperty("user.dir");
		System.out.println(userDir);
		PrintWriter pw = new PrintWriter(new File(PATH_OUTPUT));
		pw.write("这是第一行");
		pw.write("这是第二行");
		pw.write("这是最后一行");
		pw.flush();
		pw.close();
	}	
}
