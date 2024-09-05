package com.javaweb.utils;

public class NumberUtil {
	public static boolean checkNumber(String str) {
		try {
			Long.parseLong(str);
		}
		catch(Exception e) {
			return false;
		}
		return true;
	}
}
