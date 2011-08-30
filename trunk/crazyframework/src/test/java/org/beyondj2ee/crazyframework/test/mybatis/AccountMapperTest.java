package org.beyondj2ee.crazyframework.test.mybatis;

import static org.junit.Assert.assertNull;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

import java.util.ArrayList;
import java.util.List;

import junit.framework.Assert;

import org.apache.commons.lang.builder.ReflectionToStringBuilder;
import org.beyondj2ee.crazyframework.mybatis.domain.Account;
import org.beyondj2ee.crazyframework.mybatis.mapper.AccountBatchMapper;
import org.beyondj2ee.crazyframework.mybatis.mapper.AccountMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
@Transactional
@ContextConfiguration({
		"classpath*:/**/context.*.xml" })
public class AccountMapperTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(AccountMapperTest.class);
	
	private Account source;
	
	/** The account batch mapper. */
	@Autowired
	private AccountBatchMapper<Account> accountBatchMapper;
	
	/** The account mapper. */
	@Autowired
	private AccountMapper<Account> accountMapper;
	
	/**
	 * Setup.
	 */
	@Before
	public void setup() {
		source = new Account();
		source.setUserid("id3");
		source.setName("junit"); 
		source.setEmail("beyondj2ee+junit@gmail.com");
	}
	
	/**
	 * Test insert account.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Rollback(true)
	public void testInsertAccount() throws Exception {
		accountMapper.insert(source);
		Account target = accountMapper.selectOne(source);
		assertReflectionEquals(source, target);
		accountMapper.delete(source);
	}
	
	/**
	 * Test update account.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Rollback(true)
	public void testUpdateAccount() throws Exception {
		accountMapper.insert(source);
		source.setName("junit2"); 
		source.setEmail("beyondj2ee+junit2@gmail.com");
		
		accountMapper.update(source);
		Account target = accountMapper.selectOne(source);
		assertReflectionEquals(source, target);
		accountMapper.delete(source);
	}
	
	/**
	 * Test delete account.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Rollback(true)
	public void testDeleteAccount() throws Exception {
		
		accountMapper.insert(source);
		accountMapper.delete(source);
		Account target = accountMapper.selectOne(source);
		assertNull(target);
	}
	
	/**
	 * Test get account list.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Rollback(true)
	public void testGetAccountList() throws Exception {
		List<Account> list = accountMapper.selectAll(new Account());
		for(Account account : list) {
			logger.info(ReflectionToStringBuilder.toString(account));	
		}
	}
	
	/**
	 * Test batch accounts.
	 *
	 * @throws Exception the exception
	 */
	@Test
	@Rollback(true)
	public void testBatchAccounts() throws Exception {
		
		List<Account> accounts = new ArrayList<Account>();
		Account account1 = new Account();
		account1.setUserid("acc1");
		account1.setName("name1");
		account1.setEmail("email1");
		
		Account account2 = new Account();
		account2.setUserid("acc2");
		account2.setName("name2");
		account2.setEmail("email2");
		
		Account account3 = new Account();
		account3.setUserid("acc3");
		account3.setName("name3");
		account3.setEmail("email3");
		
		accounts.add(account1);
		accounts.add(account2);
		accounts.add(account3);
		
		 for(Account account : accounts) {  
			 this.accountBatchMapper.insertAccounts(account);
         }  
		List<Account> list = this.accountBatchMapper.getAccountList();
		Assert.assertTrue(list.size() > 3);
	}
}
