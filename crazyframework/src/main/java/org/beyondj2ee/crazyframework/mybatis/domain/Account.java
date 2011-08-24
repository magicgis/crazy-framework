package org.beyondj2ee.crazyframework.mybatis.domain;

import java.io.Serializable;

public class Account implements Serializable {

	private static final long serialVersionUID = 8751282105532159742L;

	private String userid;
	private String email;
	private String name;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
