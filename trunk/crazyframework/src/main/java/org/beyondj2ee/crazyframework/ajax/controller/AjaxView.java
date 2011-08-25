package org.beyondj2ee.crazyframework.ajax.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.support.RequestContext;
import org.springframework.web.servlet.view.AbstractView;

public class AjaxView extends AbstractView {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(AjaxView.class);

	// ---------------------------------------------------------------------
	// Class Variable Declaration
	// ---------------------------------------------------------------------

	private static final String DEFAULT_ENCODING = "UTF-8";
	public static final String DEFAULT_JSON_CONTENT_TYPE = "application/json";
	private static final String REQUEST_CONTEXT_ATTRIBUTE = RequestContext.class
			.toString();
	public static final String DEFAULT_HIJACKSAVE_PREFIX_POSTFIX = "JSON";

	/** The Constant CONTENT_TYPE. */
	private static final String CONTENT_TYPE = "application/json";

	/** The response body name. */
	private String responseBodyName;

	/** The encoding. */
	private String encoding;

	/** The json view callback. */
	private JsonViewCallback jsonViewCallback = new StandartErrorConverter();

	// ---------------------------------------------------------------------
	// Constructor Method Declaration
	// ---------------------------------------------------------------------
	/**
	 * Instantiates a new json view.
	 */
	public AjaxView() {
		super();
		setRequestContextAttribute(REQUEST_CONTEXT_ATTRIBUTE);
		setContentType(DEFAULT_JSON_CONTENT_TYPE);
		setEncoding(DEFAULT_ENCODING);
	}

	// ---------------------------------------------------------------------
	// DI Method (setter,getter) Declaration
	// ---------------------------------------------------------------------

	/**
	 * @param responseBodyName
	 *            the responseBodyName to set
	 */
	public void setResponseBodyName(String responseBodyName) {
		this.responseBodyName = responseBodyName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.servlet.view.AbstractView#renderMergedOutputModel
	 * (java.util.Map, javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	protected void renderMergedOutputModel(Map model,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		logger.info("rendering ajax view..");
		PrintWriter writer;
		writer = response.getWriter();
		// set response
		response.setContentType(getContentType());
		response.setCharacterEncoding(encoding);

		RequestContext requestContext = getRequestContext(model);
		BindingResult bindingResult = getBindingResult(model);
		String commandName = getCommandName(bindingResult);

		// binding invalid 일경우
		if (hasErrors(requestContext, bindingResult)) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			model.remove(commandName);
			jsonViewCallback.onPopulateErrors(model, requestContext,
					bindingResult);
		}

		writer.print(JsonParser.marshallingJson(model));
	}

	/**
	 * Gets the binding result.
	 * 
	 * @param model
	 *            the model
	 * @return the binding result
	 */
	protected BindingResult getBindingResult(Map model) {
		for (Object key : model.keySet()) {
			if (((String) key).startsWith(BindingResult.MODEL_KEY_PREFIX))
				return (BindingResult) model.remove(key);
		}
		return null;
	}

	/**
	 * Checks for errors.
	 * 
	 * @param rc
	 *            the rc
	 * @param br
	 *            the br
	 * @return true, if successful
	 */
	protected boolean hasErrors(RequestContext rc, BindingResult br) {
		if (br == null)
			return false;
		return br.hasErrors();
	}

	/**
	 * Gets the command name.
	 * 
	 * @param bindingResult
	 *            the binding result
	 * @return the command name
	 */
	protected String getCommandName(BindingResult bindingResult) {
		if (bindingResult == null)
			return null;
		else
			return bindingResult.getObjectName();
	}

	/**
	 * Gets the request context.
	 * 
	 * @param model
	 *            the model
	 * @return the request context
	 */
	protected RequestContext getRequestContext(Map model) {
		return (RequestContext) model.remove(getRequestContextAttribute());
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String encoding) {
		this.encoding = encoding;
	}

}
