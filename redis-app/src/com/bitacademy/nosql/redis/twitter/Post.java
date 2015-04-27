package com.bitacademy.nosql.redis.twitter;

import java.io.Serializable;

public class Post implements Serializable {
	
	private String postId;
	private String writeDateTime;
	private String message;
	
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public String getWriteDateTime() {
		return writeDateTime;
	}
	public void setWriteDateTime(String writeDateTime) {
		this.writeDateTime = writeDateTime;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
