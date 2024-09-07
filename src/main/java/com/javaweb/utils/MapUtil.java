package com.javaweb.utils;

import java.util.ArrayList;
import java.util.HashMap;

public class MapUtil {
	public static <T> T getObject(HashMap<String,Object> building, String key , Class<T> tclass) {
		Object obj = building.getOrDefault(key,null);
		if(obj != null) {
			if(tclass.getTypeName().equals("java.lang.Long")) {
				obj = obj != "" ? Long.valueOf(obj.toString()):null;
			}
			else if(tclass.getTypeName().equals("java.lang.Integer")) {
				obj = obj != "" ? Integer.valueOf(obj.toString()):null;
			}
			else if(tclass.getTypeName().equals("java.lang.String")) {
				obj = obj != "" ? String.valueOf(obj.toString()):null;
			}
			// khong ep kieu (String) tai chi cast duoc khi obj la Object
			return tclass.cast(obj);
			// ep kieu object sang kieu yeu cau
		}
		return null;
	}
}
