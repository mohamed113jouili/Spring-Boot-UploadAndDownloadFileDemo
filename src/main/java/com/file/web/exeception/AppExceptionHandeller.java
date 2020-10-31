package com.file.web.exeception;




import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.file.web.modeles.ApiError;




@ControllerAdvice
public class AppExceptionHandeller {
	@ExceptionHandler(FileStorageException.class)
	public ResponseEntity<Object> handleFile(FileStorageException ex, WebRequest request) {
			
			
	
			ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, ex.getMsg(), "Error From Client");
			
			
			return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
		}
	

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<Object> handleFileSizeLimitExceeded(MaxUploadSizeExceededException ex, WebRequest request) {
			
			
	
			ApiError apiError = new ApiError(HttpStatus.UNAUTHORIZED, ex.getMessage(), "Error From Client");
			
			
			return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
		}
}
