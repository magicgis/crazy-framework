package org.beyondj2ee.crazyframework.ajax.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.beyondj2ee.crazyframework.mybatis.domain.Account;
import org.beyondj2ee.crazyframework.mybatis.service.account.AccountService;
import org.beyondj2ee.crazyframework.validation.controller.Member;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The Class ValidationController.
 */
@Controller
public class AjaxController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(AjaxController.class);

	/** The CRUD service. */
	@Autowired
	private AccountService<Account> accountService;
	
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
	public final void index(final ModelMap map, final HttpServletRequest request)
			throws Exception {
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.POST)
	public final void getAll(final ModelMap map,
			final HttpServletRequest request) throws Exception {
		List<Account> accounts = this.accountService.getAll(new Account());
		map.put("accounts", accounts);
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public final void create(@ModelAttribute @Valid final Member member,
			BindingResult result, final ModelMap map,
			final HttpServletRequest request) throws Exception {
		if (!result.hasErrors()) {
			logger.info("do process.............");
		}
	}
	
	@RequestMapping(value = "/exception", method = RequestMethod.POST)
	public final void exception(@ModelAttribute final Member member,
			BindingResult result, final ModelMap map,
			final HttpServletRequest request) throws Exception {
		
		String value = null;
		value.indexOf("--");
	}
	
	@RequestMapping(value = "/exceptionForm", method = RequestMethod.GET)
	public final void exceptionGet(@ModelAttribute final Member member,
			BindingResult result, final ModelMap map,
			final HttpServletRequest request) throws Exception {
		String value = null;
		value.indexOf("--");
	}
}
