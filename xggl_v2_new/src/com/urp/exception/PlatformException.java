package com.urp.exception;

public class PlatformException extends RuntimeException {

	private static final long serialVersionUID = 834492647865981981L;
	
	private String message;

	public PlatformException() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PlatformException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
		this.message=message;
	}

	public PlatformException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
		this.message=message;
	}

	public PlatformException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
