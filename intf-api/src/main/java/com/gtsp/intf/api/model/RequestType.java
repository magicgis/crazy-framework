package com.gtsp.intf.api.model;

/**
 * Request Type.
 */
public enum RequestType {
	
	/** Payment Gateway. */
	PG("PG"),
	
	/** Email. */
	EMAIL("EMAIL");
	
	/** The value. */
	private String value;
	
	/**
	 * Instantiates a new country code.
	 *
	 * @param value the value
	 */
	RequestType(String value) {
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
