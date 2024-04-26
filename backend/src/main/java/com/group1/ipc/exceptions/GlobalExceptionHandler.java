package com.group1.ipc.exceptions;


import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.group1.ipc.dtos.MessageDTO;
import com.group1.ipc.dtos.ExceptionDTO;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class.getName());

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDTO> handleGeneralException(Exception ex) {
		logger.error("An exception occurred in " + ex.getStackTrace()[0].getClassName(), ex);
		
		String message = "An unknown error occurred. Please try again later.";
		return new ResponseEntity<>(new ExceptionDTO(message), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler({BadRequestException.class, BadCredentialsException.class})
	public ResponseEntity<MessageDTO> handleBadRequestException(Exception ex) {
		return new ResponseEntity<>(new MessageDTO(ex.getMessage()), HttpStatus.UNAUTHORIZED);
	}
}
