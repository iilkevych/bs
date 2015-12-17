package com.bikestore.web.core;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Status {

	private int code = 0;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private Long id;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	private String errormessage;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getErrormessage() {
		return errormessage;
	}

	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
}
