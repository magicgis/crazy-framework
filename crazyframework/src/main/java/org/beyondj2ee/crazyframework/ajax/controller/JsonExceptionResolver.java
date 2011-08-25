package org.beyondj2ee.crazyframework.ajax.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class JsonExceptionResolver implements HandlerExceptionResolver {

	private final static String DEFAULT_VIEW_NAME = "jsonView";
	
	private final static String DEFAULT_ERROR_MESSAGE = "System Error!!";
	
	private String exceptionJsonView;

	private String exceptionJSPView;

	private String jsonExtention;
	
	@Autowired
	private MessageSourceAccessor messageSourceAccessor;

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {

		ModelAndView mav = new ModelAndView();
		String exceptionView = exceptionJsonView;
		
		if(StringUtils.isEmpty(exceptionView)) {
			exceptionView = DEFAULT_VIEW_NAME;
		}

		String currentExtends = FilenameUtils.getExtension(request.getRequestURI());
		
		//ajax 아닌 경우
		if(!currentExtends.equals(jsonExtention)) {
			exceptionView = exceptionJSPView;
		} else {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			mav.addObject("exception", getErrorMessage(ex));
		}

		if(exceptionView == null || "".equals(exceptionView))
			throw new IllegalArgumentException("Please set the name of the JsonView");
		
		mav.setViewName(exceptionView);
		return mav;
	}

	private String getErrorMessage (Exception exception) {
		String exceptionName = ExceptionUtils.getRootCauseMessage(exception);
		int idx = exceptionName.indexOf(":");
		if (idx > 0) {
			exceptionName = exceptionName.substring(0, idx);
		}
		try{
			exceptionName = this.messageSourceAccessor.getMessage(exceptionName);
		}catch(NoSuchMessageException nse){
			exceptionName = DEFAULT_ERROR_MESSAGE;
		}
		return exceptionName;
	}
	
	
	
	public String getExceptionJsonView() {
		return exceptionJsonView;
	}

	public void setExceptionJsonView(String exceptionJsonView) {
		this.exceptionJsonView = exceptionJsonView;
	}

	public String getExceptionJSPView() {
		return exceptionJSPView;
	}

	public void setExceptionJSPView(String exceptionJSPView) {
		this.exceptionJSPView = exceptionJSPView;
	}

	public String getJsonExtention() {
		return jsonExtention;
	}

	public void setJsonExtention(String jsonExtention) {
		this.jsonExtention = jsonExtention;
	}

}
