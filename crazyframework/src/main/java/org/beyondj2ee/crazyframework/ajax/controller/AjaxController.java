package org.beyondj2ee.crazyframework.ajax.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.beyondj2ee.crazyframework.mybatis.domain.Account;
import org.beyondj2ee.crazyframework.mybatis.service.account.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
	
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public final void getAll(final ModelMap map,
			final HttpServletRequest request) throws Exception {
		List<Account> accounts = this.accountService.getAll(new Account());
		map.put("accounts", accounts);
	}
	
	
}
