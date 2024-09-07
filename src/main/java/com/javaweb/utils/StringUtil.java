package com.javaweb.utils;

public class StringUtil {
	public static boolean checkString(String str) {
		if( str == null || str.equals("") ) {
			// kiem tra null truoc tranh bi null.equal
			return false;
		}
		else return true;
	}
}
