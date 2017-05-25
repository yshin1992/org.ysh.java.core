package org.ysh.java.core.chapter6.proxy.sample.impl;

import java.util.Map;

import org.ysh.java.core.chapter6.proxy.sample.BaseService;

public class SalemanQueryService implements BaseService {

	@Override
	public void prepare(Map<String,Object> params) {
		// TODO Auto-generated method stub
		System.out.println("Prepare Query Saleman -->");
	}

	@Override
	public void execute(Map<String,Object> params) {
		// TODO Auto-generated method stub
		System.out.println("Execute Query Saleman -->");
	}

}
