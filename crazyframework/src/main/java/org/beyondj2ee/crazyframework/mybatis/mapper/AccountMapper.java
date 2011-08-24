package org.beyondj2ee.crazyframework.mybatis.mapper;

import java.io.Serializable;

import org.beyondj2ee.crazyframework.common.CRUDMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * The Interface AccountMapper.
 *
 * @param <T> the generic type
 */
public interface AccountMapper  <T extends Serializable> extends CRUDMapper<T> {
}
