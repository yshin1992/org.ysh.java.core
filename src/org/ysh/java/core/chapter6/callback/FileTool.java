package org.ysh.java.core.chapter6.callback;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文件工具类
 * @author yshin1992
 *
 */
public class FileTool implements BaseTool{

	private FileExecutor fe;
	
	
	public void setFileExecutor(FileExecutor fe){
		this.fe = fe;
	}
	
	public void dealFile(String fileName) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
		String line = null;
		while((line = br.readLine())!= null){
			fe.dealFileContent(this,line);
		}
		
	}
	
	/**
	 * 这个方法便是回调函数
	 */
	public String notify(String content){
		System.out.println("FileExecutor执行完后想要告知的内容:" + content);
		return null;
	}
	
	public static void main(String[] args) {
		FileTool tool = new FileTool();
		tool.setFileExecutor(new FileExecutor() {
			
			@Override
			public void dealFileContent(BaseTool tool,String line) {
				// TODO Auto-generated method stub
				//这里仅仅只做输出
				System.out.println(line);
				tool.notify("I'm done");
			}

		});
		
		try {
			tool.dealFile("F:/BTF_JSTCMCXR180808095343_20180809_001.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
