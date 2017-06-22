package org.ysh.java.core.tank.v2;

import java.util.Collection;

public class ObjectUtil {
	
	public static boolean collectionNotEmpty(Collection<?> collection){
		return null != collection && collection.size() > 0;
	}
	
}
