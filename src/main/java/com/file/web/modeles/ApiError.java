package com.file.web.modeles;



import org.springframework.http.HttpStatus;

public class ApiError {
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	

	private HttpStatus status;
	private String message;
	private String comment;

	

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	

	public ApiError(HttpStatus status, String message, String comment) {
		super();
		this.status = status;
		this.message = message;
		this.comment = comment;
	}
	
	

	
   
}
