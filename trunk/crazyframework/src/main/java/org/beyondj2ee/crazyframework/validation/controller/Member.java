package org.beyondj2ee.crazyframework.validation.controller;

import java.io.Serializable;

import org.hibernate.validator.constraints.NotEmpty;

public class Member implements Serializable {

	private static final long serialVersionUID = -7562903144744266908L;
		
	@NotEmpty
	private String userid;
	@NotEmpty
	private String email;
	@NotEmpty
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