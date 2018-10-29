package org.ysh.java.core.chapter6.callback;

/**
 * 负责处理文件的每一行内容
 * @author yshin1992
 *
 */
public interface FileExecutor {

	void dealFileContent(BaseTool tool,String line);
}
