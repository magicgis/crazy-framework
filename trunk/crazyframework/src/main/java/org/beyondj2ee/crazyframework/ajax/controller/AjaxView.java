package org.beyondj2ee.crazyframework.ajax.controller;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
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
	/** The Constant CONTENT_TYPE. */
	private static final String CONTENT_TYPE = "application/json";

	/** The response body name. */
	private String responseBodyName;

	// ---------------------------------------------------------------------
	// Constructor Method Declaration
	// ---------------------------------------------------------------------
	/**
	 * Instantiates a new json view.
	 */
	public AjaxView() {
		super();
		setContentType(CONTENT_TYPE);
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
		response.setContentType(getContentType());

		RequestContext requestContext = getRequestContext(model);
		BindingResult bindingResult = getBindingResult(model);
		String commandName = getCommandName(bindingResult);
		
		//binding invalid 일경우 
		if (hasErrors(requestContext, bindingResult)) {
			model.remove(commandName);
		}

		writer.print(JsonParser.marshallingJson(model));
	}

	protected BindingResult getBindingResult(Map model) {
		for (Object key : model.keySet()) {
			if (((String) key).startsWith(BindingResult.MODEL_KEY_PREFIX))
				return (BindingResult) model.remove(key);
		}
		return null;
	}

	protected boolean hasErrors(RequestContext rc, BindingResult br) {
		if (br == null)
			return false;
		return br.hasErrors();
	}

	protected String getCommandName(BindingResult bindingResult) {
		if (bindingResult == null)
			return null;
		else
			return bindingResult.getObjectName();
	}

	protected RequestContext getRequestContext(Map model) {
		return (RequestContext) model.remove(getRequestContextAttribute());
	}
}
