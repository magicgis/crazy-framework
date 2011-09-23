package com.gtsp.intf.api;

import com.gtsp.intf.api.model.AdapterMap;


/**
 * 인터페이스 허브에서 실제로 연동하기 위한 기술 구현 인터페이스.
 */
public interface InterfacePgAdapter {
	
	/**
	 * 각 PG사에 맞는 기술적인 연동 구현 메서드.
	 *
	 * @param requestMap the request map
	 * @return the map
	 * @throws Exception the exception
	 */
	public AdapterMap execute (AdapterMap requestMap) throws Exception;
	
}
