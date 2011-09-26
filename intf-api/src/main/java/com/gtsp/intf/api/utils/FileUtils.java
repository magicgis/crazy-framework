package com.gtsp.intf.api.utils;

public class FileUtils {

	/**
	 * File 경로를 설정 한다.
	 *
	 * @param path the path
	 * @return the string
	 */
	public static String convertFilePath(String path) {

		String filePath = path;
		
		if (filePath == null) {
			return "";
		}
		
		int length = filePath.length();
		if(!"/".equals(filePath.substring(length-1))) {
			filePath+="/";
		}
		
		return filePath;
	}
}

