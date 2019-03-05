package org.ysh.java.core.chapter6.proxy.sample.main;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.ysh.java.core.chapter6.proxy.sample.BaseService;
import org.ysh.java.core.chapter6.proxy.sample.impl.VenderQueryService;

public class QueryClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			BaseService service =  AppContext.getProxyBean(VenderQueryService.class);
			
			Map<String,Object> condition = new HashMap<String,Object>();
			condition.put("queryParams", "lalla");
			condition.put("timestamp", new Date());
			
			service.prepare(condition);
			service.execute(condition);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
