package org.beyondj2ee.crazyframework.mybatis.mapper;

import java.io.Serializable;
import java.util.List;

import org.beyondj2ee.crazyframework.mybatis.domain.Account;

// TODO: Auto-generated Javadoc
/**
 * The Interface AccountBatchMapper.
 *
 * @param <T> the generic type
 */
public interface AccountBatchMapper<T extends Serializable> {
	
	/**
	 * Insert accounts.
	 *
	 * @param account the account
	 */
	void insertAccounts(Account account);
	
	/**
	 * Gets the account list.
	 *
	 * @return the account list
	 */
	List<Account> getAccountList();
}
