package com.learning.springboot.exception;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.learning.dtos.AppFieldError;
import com.learning.dtos.ErrorDetailDto;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorDetailDto> handleUserNotFoundExceptions(Exception exception, WebRequest request) {
		ErrorDetailDto error = new ErrorDetailDto(exception.getMessage(), request.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}	
	
	/**
	 * Customize the handling of {@link MethodArgumentNotValidException}.
	 * <p>This method delegates to {@link #handleExceptionInternal}.
	 * @param ex the exception to handle
	 * @param headers the headers to be written to the response
	 * @param status the selected response status
	 * @param request the current request
	 * @return a {@code ResponseEntity} for the response to use, possibly
	 * {@code null} when the response is already committed
	 */
	@Nullable
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		ErrorDetailDto error = new ErrorDetailDto("Validation errors", request.getDescription(false), LocalDateTime.now());
		ResponseEntity<Object> response = new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
		error.setErrors(fieldErrors(ex.getFieldErrors()));
		return handleExceptionInternal(ex, response, headers, status, request);
	}
	
	protected List<AppFieldError> fieldErrors(List<FieldError> errors){
		
		return  errors.stream().map(error 
				-> new AppFieldError(error.getObjectName(), error.getField(), error.getDefaultMessage())).collect(Collectors.toList());
	}

}
