package org.beyondj2ee.crazyframework.shiro.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ShiroController {

	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(ShiroController.class);

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
		Session session = SecurityUtils.getSubject().getSession();
		System.out.println(session.getAttribute("user1"));
		System.out.println(session);
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public final String logout(final ModelMap map, final HttpServletRequest request)
			throws Exception {
		SecurityUtils.getSubject().logout();
		return "redirect:/shiro/login.htm";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public final void loginForm(final ModelMap map,
			final HttpServletRequest request) throws Exception {
		logger.info("-------------login GET");
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public final String login(final ModelMap map,
			final HttpServletRequest request) throws Exception {
		UsernamePasswordToken token = new UsernamePasswordToken(
				request.getParameter("username"),
				request.getParameter("password"));
		try {
			System.out.println("8888888888888");
			SecurityUtils.getSubject().login(token);

			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute("user1", "user1");
		} catch (Exception e) {
			logger.error(e.getMessage());
		}

		logger.info("-------------login POST");
		return "redirect:/shiro/index.htm";
	}

}
