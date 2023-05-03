package com.masai.exception;

import java.time.LocalDateTime;

public class MyErrorDetails {
	private LocalDateTime timpstamp;
	private String message;
	private String details;

	public MyErrorDetails() {
	}

	public MyErrorDetails(LocalDateTime timpstamp, String message, String details) {
		super();
		this.timpstamp = timpstamp;
		this.message = message;
		this.details = details;
	}

	public LocalDateTime getTimpstamp() {
		return timpstamp;
	}

	public void setTimpstamp(LocalDateTime timpstamp) {
		this.timpstamp = timpstamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "MyErrorDetails [timpstamp=" + timpstamp + ", message=" + message + ", details=" + details + "]";
	}

}
