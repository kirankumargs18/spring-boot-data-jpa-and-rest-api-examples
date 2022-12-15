package com.globallogic.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.globallogic.utils.ErrorDetails;

/*
 *this class must extend ResponseEntityExceptionHandler to 
 *handle hibernate validation exceptions 
 * 
 * */

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	/*
	 * All Custom exceptions must be handled like this
	 */

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> resourceNotFoundException(ResourceNotFoundException exception,
			WebRequest webRequest) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
				webRequest.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);

	}

	/*
	 * Hibernate Validation Exceptions
	 */

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		Map<String, String> errors = new HashMap<>();

		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String fieldName = ((FieldError) error).getField();
			String message = error.getDefaultMessage();
			errors.put(fieldName, message);
		});

		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
	}

	/*
	 * Global Exceptions(Exceptions which are not handled)
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> globalException(Exception exception, WebRequest webRequest) {

		ErrorDetails errorDetails = new ErrorDetails(new Date(), exception.getMessage(),
				webRequest.getDescription(false));

		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	/*
	 * A single method to handle all exceptions
	 */
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

}
