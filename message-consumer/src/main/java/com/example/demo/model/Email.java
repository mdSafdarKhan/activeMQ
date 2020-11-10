package com.example.demo.model;

import java.io.Serializable;

public class Email implements Serializable {

	private static final long serialVersionUID = 2839022263821530129L;
	private String to;
	private String body;

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Override
	public String toString() {
		return "Email [to=" + to + ", body=" + body + "]";
	}

}
