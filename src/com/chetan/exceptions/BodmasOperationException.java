package com.chetan.exceptions;

public class BodmasOperationException extends RuntimeException{

	String errorMsg; 
	
	public BodmasOperationException(String error) {
		this.errorMsg = error;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	

}
