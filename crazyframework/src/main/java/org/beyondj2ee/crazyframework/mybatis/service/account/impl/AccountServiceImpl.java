package org.beyondj2ee.crazyframework.mybatis.service.account.impl;

import org.beyondj2ee.crazyframework.common.CRUDServiceImpl;
import org.beyondj2ee.crazyframework.mybatis.mapper.AccountMapper;
import org.beyondj2ee.crazyframework.mybatis.service.account.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

// TODO: Auto-generated Javadoc
/**
 * The Class AccountServiceImpl.
 */
public class AccountServiceImpl extends CRUDServiceImpl implements AccountService{
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(AccountServiceImpl.class);
	
	/** The account mapper. */
	private AccountMapper accountMapper;

	/**
	 * Sets the account mapper.
	 *
	 * @param accountMapper the new account mapper
	 */
	public void setAccountMapper(AccountMapper accountMapper) {
		this.accountMapper = accountMapper;
	}
	
}
