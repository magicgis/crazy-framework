package org.beyondj2ee.crazyframework.ajax.controller;

import java.util.Map;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.support.RequestContext;

/**
 * The Interface JsonViewCallback.
 */
public interface JsonViewCallback {
	
	/** The Constant KEEP_ALL. */
	public static final String KEEP_ALL = "KEEP_ALL";
	
	/** The Constant REMOVE_COMMAND_BEAN. */
	public static final String REMOVE_COMMAND_BEAN = "REMOVE_COMMAND_BEAN";
	
	/** The Constant KEEP_ERRORS_ONLY. */
	public static final String KEEP_ERRORS_ONLY = "KEEP_ERRORS_ONLY";

	/**
	 * On populate errors.
	 *
	 * @param model the model
	 * @param rc the rc
	 * @param br the br
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	public void onPopulateErrors(Map model, RequestContext rc, BindingResult br)
			throws Exception;

	/**
	 * On populate success.
	 *
	 * @param model the model
	 * @param rc the rc
	 * @param br the br
	 * @throws Exception the exception
	 */
	@SuppressWarnings("unchecked")
	public void onPopulateSuccess(Map model, RequestContext rc, BindingResult br)
			throws Exception;
}
