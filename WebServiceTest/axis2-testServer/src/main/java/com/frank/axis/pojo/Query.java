package com.frank.axis.pojo;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("query")
public class Query {

	private String user;
	private String token;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
}
