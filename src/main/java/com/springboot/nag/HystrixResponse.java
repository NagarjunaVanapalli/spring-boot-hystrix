package com.springboot.nag;

public class HystrixResponse {

	private Integer statusCode;
	private String statusMessgae;

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusMessgae() {
		return statusMessgae;
	}

	public void setStatusMessgae(String statusMessgae) {
		this.statusMessgae = statusMessgae;
	}

}
