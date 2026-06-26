package com.luca.engineer.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.support.MethodArgumentNotValidException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.luca.engineer.dto.response.MessageResponse;

@RestControllerAdvice
public class ExceptionManager {

	@ExceptionHandler(exception = Exception.class)
	public ResponseEntity<MessageResponse> handleException(Exception e) {
		return ResponseEntity.badRequest()
				.body(MessageResponse.builder().msg(e.getMessage()).build());
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MessageResponse> handleValidationException(MethodArgumentNotValidException e) {
		
		String msg = e.getBindingResult()
				.getFieldErrors()
				.stream()
				.findFirst()
				.map(FieldError::getDefaultMessage)
				.orElse("Errore di validazione");

		return ResponseEntity.badRequest()
				.body(MessageResponse.builder().msg(msg).build());
	}
	
}
