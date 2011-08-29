package org.beyondj2ee.crazyframework.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.UnavailableSecurityManagerException;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.support.SubjectThreadState;
import org.apache.shiro.util.LifecycleUtils;
import org.apache.shiro.util.ThreadState;
import org.junit.AfterClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AbstractShiroTest {

	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(AbstractShiroTest.class);
	
	private static ThreadState subjectThreadState;
	
	public AbstractShiroTest() {
	}

	/**
	 * Allows subclasses to set the currently executing {@link Subject}
	 * instance.
	 * 
	 * @param subject
	 *            the Subject instance
	 */
	protected void setSubject(Subject subject) {
		clearSubject();
		subjectThreadState = createThreadState(subject);
		subjectThreadState.bind();
	}

	protected Subject getSubject() {
		return SecurityUtils.getSubject();
	}

	protected ThreadState createThreadState(Subject subject) {
		return new SubjectThreadState(subject);
	}

	/**
	 * Clears Shiro's thread state, ensuring the thread remains clean for future
	 * test execution.
	 */
	protected void clearSubject() {
		doClearSubject();
	}

	private static void doClearSubject() {
		if (subjectThreadState != null) {
			subjectThreadState.clear();
			subjectThreadState = null;
		}
	}

	protected static void setSecurityManager(SecurityManager securityManager) {
		SecurityUtils.setSecurityManager(securityManager);
	}

	protected static SecurityManager getSecurityManager() {
		return SecurityUtils.getSecurityManager();
	}

	@AfterClass
	public static void tearDownShiro() {
		doClearSubject();
		try {
			SecurityManager securityManager = getSecurityManager();
			LifecycleUtils.destroy(securityManager);
		} catch (UnavailableSecurityManagerException e) {
		}
		setSecurityManager(null);
	}
}
