package org.beyondj2ee.crazyframework.test.shiro;

import static org.junit.Assert.assertTrue;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@ContextConfiguration({ "classpath:/mybatis/context.mybatis.xml", "classpath:/context.datasource.xml","classpath:/shiro/shiro.standalone.xml"})
public class ShiroRealTest {

	private static final Logger logger = LoggerFactory
			.getLogger(ShiroRealTest.class);

	/**
	 * Setup.
	 */
	@Before
	public void setup() {
	}

	/**
	 * Test insert account.
	 * 
	 * @throws Exception
	 *             the exception
	 */
	@Test
	@Rollback(true)
	public void testShiro() throws Exception {

		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken("user1",
				"user1");
		boolean loginSuccess = false;
        Session session = subject.getSession();
        
		try {
			subject.login(token);
			loginSuccess = true;
			session.setAttribute("user1", "user1");
		} catch (AuthenticationException e) {
		}

		logger.info("==principal==" + subject.getPrincipal());
		logger.info("==session==" + session.getAttribute("user1"));

		if (subject.hasRole("role1")) {
			logger.info("==role1== true");
		} else {
			logger.info("==role1== false");
		}

		if (subject.isPermitted("permission1")) {
			logger.info("==permission1== true");
		} else {
			logger.info("==permission2== true");
		}
		
		if (subject.isPermitted("permission2:*")) {
			logger.info("==permission1== true");
		} else {
			logger.info("==permission2== true");
		}

		assertTrue(loginSuccess);
	}
}
