package com.gtsp.intf.api.exception;

/**
 * The Class NotFoundHandlerException.
 */
public class InvalidParameterException extends RuntimeException{
	
	/**
	 * Instantiates a new not found handler exception.
	 */
	public InvalidParameterException () {
	}
	
	/**
	 * InterfaceHandlerFactory에 핸들러가 등록 되어 있지 않을 경우 발생 한다.
	 *
	 * @param message the message
	 */
	public InvalidParameterException (String message) {
		super (message);
	}
}
