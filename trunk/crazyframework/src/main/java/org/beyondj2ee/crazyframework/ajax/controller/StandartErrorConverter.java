package org.beyondj2ee.crazyframework.ajax.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.servlet.support.RequestContext;

public class StandartErrorConverter implements JsonViewCallback {

	private String modelCleanUpMode = KEEP_ALL;
	private String hasGlobalErrorsKey = "hasGlobalErrors";
	private String globalErrorsKey = "globalerrors";
	private String hasFieldErrorsKey = "hasFieldErrors";
	private String fieldErrorsKey = "fielderrors";

	@SuppressWarnings("unchecked")
	public void onPopulateErrors(Map model, RequestContext rc, BindingResult br)
			throws Exception {

		if (KEEP_ERRORS_ONLY.equals(modelCleanUpMode))
			model.clear();
		else if (REMOVE_COMMAND_BEAN.equals(modelCleanUpMode))
			model.remove(br.getObjectName());

		List<String> globalErrors = new ArrayList<String>();
		for (Object er : br.getGlobalErrors()) {
			ObjectError error = (ObjectError) er;
			String message = rc.getMessage(error);
			globalErrors.add(message);
		}

		model.put(hasGlobalErrorsKey, br.hasGlobalErrors());
		if (!globalErrors.isEmpty())
			model.put(globalErrorsKey, globalErrors);

		Map<String, String> feldErrors = new HashMap<String, String>();
		for (Object er : br.getFieldErrors()) {
			FieldError error = (FieldError) er;
			String objName = error.getField();
			String message = rc.getMessage(error);
			feldErrors.put(objName, message);
		}

		model.put(hasFieldErrorsKey, br.hasFieldErrors());
		if (!feldErrors.isEmpty())
			model.put(fieldErrorsKey, feldErrors);
	}

	/**
	 * Not imlemented for default behaviour
	 */
	@SuppressWarnings("unchecked")
	public void onPopulateSuccess(Map model, RequestContext rc, BindingResult br) {

	}

	/**
	 * @return the modelCleanUpMode
	 */
	public String getModelCleanUpMode() {
		return modelCleanUpMode;
	}

	/**
	 * @param modelCleanUpMode
	 *            the modelCleanUpMode to set
	 */
	public void setModelCleanUpMode(String modelCleanUpMode) {
		this.modelCleanUpMode = modelCleanUpMode;
	}

	/**
	 * @return the hasGlobalErrorsKey
	 */
	public String getHasGlobalErrorsKey() {
		return hasGlobalErrorsKey;
	}

	/**
	 * @param hasGlobalErrorsKey
	 *            the hasGlobalErrorsKey to set
	 */
	public void setHasGlobalErrorsKey(String hasGlobalErrorsKey) {
		this.hasGlobalErrorsKey = hasGlobalErrorsKey;
	}

	/**
	 * @return the globalErrorsKey
	 */
	public String getGlobalErrorsKey() {
		return globalErrorsKey;
	}

	/**
	 * @param globalErrorsKey
	 *            the globalErrorsKey to set
	 */
	public void setGlobalErrorsKey(String globalErrorsKey) {
		this.globalErrorsKey = globalErrorsKey;
	}

	/**
	 * @return the hasFieldErrorsKey
	 */
	public String getHasFieldErrorsKey() {
		return hasFieldErrorsKey;
	}

	/**
	 * Sets the checks for field errors key.
	 *
	 * @param hasFieldErrorsKey the hasFieldErrorsKey to set
	 */
	public void setHasFieldErrorsKey(String hasFieldErrorsKey) {
		this.hasFieldErrorsKey = hasFieldErrorsKey;
	}

	/**
	 * Gets the field errors key.
	 *
	 * @return the fieldErrorsKey
	 */
	public String getFieldErrorsKey() {
		return fieldErrorsKey;
	}

	/**
	 * Sets the field errors key.
	 *
	 * @param fieldErrorsKey the fieldErrorsKey to set
	 */
	public void setFieldErrorsKey(String fieldErrorsKey) {
		this.fieldErrorsKey = fieldErrorsKey;
	}
}
