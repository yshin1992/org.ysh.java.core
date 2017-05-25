package org.ysh.java.core.chapter6.proxy.sample;

import java.util.Map;

/**
 * 基础服务接口
 * @author yshin1992
 *
 */
public interface BaseService {

	public void prepare(Map<String,Object> params);
	
	public void execute(Map<String,Object> params);
	
}
