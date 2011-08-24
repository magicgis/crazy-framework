package org.beyondj2ee.crazyframework.common;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// TODO: Auto-generated Javadoc
/**
 * The Class CRUDServiceImpl.
 *
 * @param <T> the generic type
 */
public class CRUDServiceImpl <T extends Serializable> implements CRUDService<T> {
	
	/** The Constant logger. */
	private static final Logger logger = LoggerFactory
			.getLogger(CRUDServiceImpl.class);

	/** The crud mapper. */
	private CRUDMapper<T> crudMapper; 
	
	/**
	 * Sets the crud mapper.
	 *
	 * @param crudMapper the new crud mapper
	 */
	public void setCrudMapper(CRUDMapper<T> crudMapper) {
		this.crudMapper = crudMapper;
	}

	/* (non-Javadoc)
	 * @see org.beyondj2ee.crazyframework.common.CRUDService#remove(java.io.Serializable)
	 */
	@Override
	public void remove(T domain) throws Exception {
		this.crudMapper.delete(domain);
	}

	/* (non-Javadoc)
	 * @see org.beyondj2ee.crazyframework.common.CRUDService#create(java.io.Serializable)
	 */
	@Override
	public void create(T domain) throws Exception {
		this.crudMapper.insert(domain);
	}

	/* (non-Javadoc)
	 * @see org.beyondj2ee.crazyframework.common.CRUDService#modify(java.io.Serializable)
	 */
	@Override
	public void modify(T domain) throws Exception {
		this.crudMapper.update(domain);
	}

	/* (non-Javadoc)
	 * @see org.beyondj2ee.crazyframework.common.CRUDService#get(java.io.Serializable)
	 */
	@Override
	public T get(T domain) throws Exception {
		return this.crudMapper.selectOne(domain);
	}

	/* (non-Javadoc)
	 * @see org.beyondj2ee.crazyframework.common.CRUDService#getAll(java.io.Serializable)
	 */
	@Override
	public List<T> getAll(T domain) throws Exception{
		return this.crudMapper.selectAll(domain);
	}
	
}
