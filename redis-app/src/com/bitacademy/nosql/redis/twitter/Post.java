package com.bitacademy.nosql.redis.twitter;

import java.io.Serializable;

public class Post implements Serializable {
	
	private String writerUserId;
	private String writerUserName;
	private String writeDateTime;
	private String message;
	
	public String getWriterUserId() {
		return writerUserId;
	}
	public void setWriterUserId(String writerUserId) {
		this.writerUserId = writerUserId;
	}
	public String getWriterUserName() {
		return writerUserName;
	}
	public void setWriterUserName(String writerUserName) {
		this.writerUserName = writerUserName;
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
