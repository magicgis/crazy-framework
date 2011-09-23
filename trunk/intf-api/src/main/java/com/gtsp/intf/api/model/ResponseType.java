package com.gtsp.intf.api.model;

/**
 * 요청에 대한 응답 방식.
 */
public enum ResponseType {
	
	/** URL 방식. */
	URL("URL"),
	
	/** API 방식. */
	API("API");
	
	/** The value. */
	private String value;
	
	/**
	 * Instantiates a new country code.
	 *
	 * @param value the value
	 */
	ResponseType(String value) {
		this.value = value;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value.
	 *
	 * @param value the new value
	 */
	public void setValue(String value) {
		this.value = value;
	}
}
