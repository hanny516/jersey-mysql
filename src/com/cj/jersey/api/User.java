package com.cj.jersey.api;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class User {
	
	private String user;
	private String tweet;
	
//	public User() {
//		this.user = "system";
//		this.tweet = "sysTweet";
//	}

	public User() {
	}

	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getTweet() {
		return tweet;
	}
	public void setTweet(String tweet) {
		this.tweet = tweet;
	}

}
