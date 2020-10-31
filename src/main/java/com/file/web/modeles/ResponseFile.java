package com.file.web.modeles;

public class ResponseFile {
	
	public ApiError getError() {
		return error;
	}


	public void setError(ApiError error) {
		this.error = error;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	ApiError error;
	String url;
	

	public ResponseFile(ApiError error, String url) {
		super();
		this.error = error;
		this.url = url;
	}

}
