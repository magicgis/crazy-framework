package com.gtsp.intf.api.model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


/**
 * properties 환경 파일 도메인.
 */
public class Config {

	/** The Constant DEFAULT_CONFIG_PATH. */
	private static final String DEFAULT_CONFIG_PATH = "/intf-config/intf.properties";

	/** The config map. */
	private static Properties properties;

	/**
	 * s properties 파일에 있는 값 정보를 조회한다.
	 * 
	 * @param key
	 *            the key
	 * @return the string
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static String get(String key) {
		init();
		return (String) properties.get(key);
	}

	/**
	 * Properties 데이터 로드.
	 * 
	 * @param input
	 *            the input
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public static void load(InputStream input) throws IOException {
		// 초기화가 되어 있지 않으면
		init();
		properties.load(input);
	}

	/**
	 * 로드 초기화.
	 * 
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static void init() {
		try {
			if (properties == null) {
				properties = new Properties();
				properties.load(Config.class
						.getResourceAsStream(DEFAULT_CONFIG_PATH));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
