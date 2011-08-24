package org.beyondj2ee.crazyframework.validation.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * The Class ValidationController.
 */
@Controller
public class ValidationController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(ValidationController.class);

	/**
	 * Gets the all.
	 * 
	 * @param map
	 *            the map
	 * @param request
	 *            the request
	 * @return the all
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public final void index(final ModelMap map,
			final HttpServletRequest request) throws Exception {

	}
	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public final void success(final ModelMap map,
			final HttpServletRequest request) throws Exception {

	}
	
	// ===== JSR 303 Validation for Form ===== 
	/**
	 * Creates the form.
	 * 
	 * @param map
	 *            the map
	 * @param request
	 *            the request
	 */
	@RequestMapping(value = "/createForm", method = RequestMethod.GET)
	public final void createForm(final ModelMap map,
			final HttpServletRequest request) throws Exception {
		map.put("member", new Member());
	}

	/**
	 * Creates the.
	 * 
	 * @param map
	 *            the map
	 * @param request
	 *            the request
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public final ModelAndView create(@Valid final Member member,
			BindingResult result,
			final ModelMap map, final HttpServletRequest request)
			throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/validation/success.htm");
		
		if (result.hasErrors()) {
			mav.setViewName("/createForm");
			return mav;
		} 
		return mav;
	}
	
}
