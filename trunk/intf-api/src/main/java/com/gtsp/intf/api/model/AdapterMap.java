/*
 * 
 */
package com.gtsp.intf.api.model;

import java.util.HashMap;

/**
 * Adapter에서 사용하는 맵형 도메인.
 */
public class AdapterMap extends HashMap{
	
	/** 실제 요청 URL. */
	private String requestUrl;
	
	/** 요청 timeout. */
	private int timeout = 180000 ;
	
	/** The character set. */
	private String characterSet = "UTF-8";
	
	/** 요청 처리 결과 값. */
	private boolean success = false;
	
	/** 메세지 전문. */
	private String messageBody;
	
	/** 실제 결과 코드. */
	private String resultCode;
	
	/** The ssl 사용 유무. */
	private boolean ssl;
	
	/**
	 * Gets the request url.
	 *
	 * @return the request url
	 */
	public String getRequestUrl() {
		return requestUrl;
	}

	/**
	 * Sets the request url.
	 *
	 * @param requestUrl the new request url
	 */
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	/**
	 * Gets the timeout.
	 *
	 * @return the timeout
	 */
	public int getTimeout() {
		return timeout;
	}

	/**
	 * Sets the timeout.
	 *
	 * @param timeout the new timeout
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	/**
	 * Gets the character set.
	 *
	 * @return the character set
	 */
	public String getCharacterSet() {
		return characterSet;
	}

	/**
	 * Sets the character set.
	 *
	 * @param characterSet the new character set
	 */
	public void setCharacterSet(String characterSet) {
		this.characterSet = characterSet;
	}

	/**
	 * Checks if is success.
	 *
	 * @return true, if is success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * Sets the success.
	 *
	 * @param success the new success
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * Gets the message body.
	 *
	 * @return the message body
	 */
	public String getMessageBody() {
		return messageBody;
	}

	/**
	 * Sets the message body.
	 *
	 * @param messageBody the new message body
	 */
	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}

	/**
	 * Gets the result code.
	 *
	 * @return the result code
	 */
	public String getResultCode() {
		return resultCode;
	}

	/**
	 * Sets the result code.
	 *
	 * @param resultCode the new result code
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public boolean isSsl() {
		return ssl;
	}

	public void setSsl(boolean ssl) {
		this.ssl = ssl;
	}
	
	
}
