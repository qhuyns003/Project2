package com.javaweb.utils;

public class StringUtil {
	public static boolean checkString(String str) {
		if(str.equals("") || str == null) {
			return false;
		}
		else return true;
	}
}
