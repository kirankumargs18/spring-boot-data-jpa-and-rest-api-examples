package com.globallogic.exception;

import org.apache.commons.logging.Log;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	/*
	 * Exception Handler for Product not found
	 */
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<String> idNotFoundException(IdNotFoundException exception) {

		return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	/*
	 * Exception Handler for Invalid Price
	 */
	@ExceptionHandler(InvalidPriceException.class)
	public ResponseEntity<String> invalidPriceException(InvalidPriceException exception) {

		return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

}
