package org.ysh.java.core.chapter6.proxy.sample.impl;

import java.util.Map;

import org.ysh.java.core.chapter6.proxy.sample.BaseService;

public class CarQueryService implements BaseService {

	@Override
	public void prepare(Map<String,Object> params) {
		// TODO Auto-generated method stub
		System.out.println("Prepare Query Car-->");
		
		if(null != params){
			System.out.println(params.entrySet());
		}
	}

	@Override
	public void execute(Map<String,Object> params) {
		// TODO Auto-generated method stub
		System.out.println("Execute Query Car-->");
		if(null != params){
			System.out.println(params.entrySet());
		}
	}

}
