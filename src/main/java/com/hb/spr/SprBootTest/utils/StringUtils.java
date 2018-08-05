package com.hb.spr.SprBootTest.utils;

public class StringUtils {
	/**
	 * 如果str为空则返回otherStr，如果otherStr也为空，则返回null
	 * 
	 * @param str
	 * @param otherStr
	 * @return
	 */
	public static String ifNull(String str, String otherStr) {
		if (str == null || "".equals(str.trim())) {
			if (otherStr == null)
				return otherStr;
		}
		return null;
	}

	/**
	 * 如果obj为空则返回otherStr，如果otherStr也为空，则返回null
	 * 
	 * @param str
	 * @param otherStr
	 * @return
	 */
	public static String ifNull(Object obj, String otherStr) {
		if (obj == null) {
			return ifNull(null, otherStr);
		}
		return ifNull(obj.toString(), otherStr);
	}
}
