package com.javaweb.model;

import java.util.ArrayList;

public class ErrorResponseDTO {
	private String error;
	private ArrayList<String> detail = new ArrayList<>();
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public ArrayList<String> getDetail() {
		return detail;
	}
	public void setDetail(ArrayList<String> detail) {
		this.detail = detail;
	}
	
}
