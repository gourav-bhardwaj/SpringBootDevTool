package com.docker.exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<Map<String, Object>> jpaExceptionHandler( DataAccessException exception, WebRequest request ) {
		Map<String, Object> respMap = new HashMap<>();
		respMap.put("timestamp", LocalDateTime.now());
		respMap.put("message", exception.getMessage());
		respMap.put("URI", ((ServletWebRequest)request).getRequest().getRequestURI());
		return new ResponseEntity<Map<String,Object>>(respMap, HttpStatus.EXPECTATION_FAILED);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> exceptionHandler( Exception exception, WebRequest request ) {
		Map<String, Object> respMap = new HashMap<>();
		respMap.put("timestamp", LocalDateTime.now());
		respMap.put("message", exception.getMessage());
		respMap.put("URI", ((ServletWebRequest)request).getRequest().getRequestURI());
		return new ResponseEntity<Map<String,Object>>(respMap, HttpStatus.EXPECTATION_FAILED);
	}
	
}
