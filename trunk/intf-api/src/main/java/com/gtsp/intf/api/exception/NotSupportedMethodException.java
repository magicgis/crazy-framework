package com.gtsp.intf.api.exception;

/**
 * The Class NotSupportedMethodException.
 */
public class NotSupportedMethodException extends RuntimeException{
	
	/**
	 * Instantiates a new not supported method exception.
	 */
	public NotSupportedMethodException () {
	}
	
	/**
	 * 메서드가 지원을 하지 않을 경우 해당 exception이 발생 한다.
	 *
	 * @param message the message
	 */
	public NotSupportedMethodException (String message) {
		super (message);
	}
}
