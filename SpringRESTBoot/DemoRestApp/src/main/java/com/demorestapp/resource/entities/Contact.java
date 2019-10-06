package com.demorestapp.resource.entities;

import javax.persistence.Embeddable;

@Embeddable
public class Contact {

	private String mobile;
	private String email;
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contact(String mobile, String email) {
		super();
		this.mobile = mobile;
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Contact [mobile=" + mobile + ", email=" + email + "]";
	}
	
}
