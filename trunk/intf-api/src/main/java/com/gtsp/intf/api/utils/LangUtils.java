package com.gtsp.intf.api.utils;

public class LangUtils {
	
	/**
	 * String 값을 null일경우는 ""으로 초기화 하고, 그렇지 않은 경우 trim 처리를 한다.
	 *
	 * @param value the value
	 * @return the string
	 */
	public static String trimToEmpty (String value) {
		String returnValue = value;
		if(returnValue ==  null) {
			return "";
		}
		return returnValue.trim();
	}
}
