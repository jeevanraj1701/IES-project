package com.jeev.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(SsaWebException.class)
	public ResponseEntity<AppException> handleSsaWebEx(
			SsaWebException ex) {

		AppException appEx = new AppException();

		appEx.setExCode("EX001");
		appEx.setExDesc(ex.getMessage());

		return new ResponseEntity<>(
				appEx,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}