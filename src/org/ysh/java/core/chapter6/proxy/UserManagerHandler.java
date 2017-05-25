package org.ysh.java.core.chapter6.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserManagerHandler implements InvocationHandler {

	private Object target;
	
	public Object newProxyInstance(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("start-->>" + method.getName());
		for(int i=0;i<args.length;i++){  
            //打印调用目标方法的参数  
            System.out.println(args[i]);  
        }  
		Object ret = null;  
        try{  
            //调用目标方法  
            ret = method.invoke(target, args);  
            //执行成功，打印成功信息  
            System.out.println("success-->>" + method.getName());  
        }catch(Exception e){  
            e.printStackTrace();  
            //失败时，打印失败信息  
            System.out.println("error-->>" + method.getName());  
            throw e;  
        }  
          
        return ret;
	}

}
