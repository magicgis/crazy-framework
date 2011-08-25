package org.beyondj2ee.crazyframework.validation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class MemberValidator  implements Validator {
	
	/** The Constant log. */
	private static final Logger log = LoggerFactory
	.getLogger(MemberValidator.class);
	
	/**
	 * <p>
	 * description about class
	 * </p>
	 * Supports.
	 * 
	 * @param clazz the clazz
	 * @return true, if successful
	 */
	public boolean supports(Class clazz) {
		return Member.class.equals(clazz);
	}
	
	/**
	 * <p>
	 * description about class
	 * </p>
	 * Validate.
	 * 
	 * @param obj the obj
	 * @param errors the errors
	 */
	public void validate(Object obj, Errors errors) {
		Member member = (Member) obj;
		ValidatorUtils.rejectIfEmpty(errors, "userid", "NotEmpty.member.userid");
		ValidatorUtils.rejectIfEmpty(errors, "email", "NotEmpty.member.email");
		ValidatorUtils.rejectIfEmpty(errors, "name", "NotEmpty.member.name");
	}
}
