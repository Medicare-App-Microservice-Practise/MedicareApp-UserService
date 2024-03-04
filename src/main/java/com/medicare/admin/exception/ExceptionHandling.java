package com.medicare.admin.exception;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.medicare.admin.exception.customException.NotFoundException;

import org.springframework.web.bind.MethodArgumentNotValidException;

@RestControllerAdvice
public class ExceptionHandling {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> illegalArgumentException (IllegalArgumentException ex)
	{
		Map<String,Object> errorResponse = new HashMap<>();
		
		errorResponse.put("result", "fail");
		errorResponse.put("message", ex.getMessage());
		
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Object> MethodArgumentNotValidException (MethodArgumentNotValidException ex)
	{
		Map<String,Object> errorResponse = new HashMap<>();
		List<String> customError = new ArrayList<>();
		
		ex.getBindingResult().getFieldErrors().forEach(error -> {
			customError.add(error.getDefaultMessage());
		});
		
		errorResponse.put("result", "fail");
		errorResponse.put("message", customError);
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<Object> notFoundException (NotFoundException ex)
	{
		Map<String,Object> errorResponse = new HashMap<>();
		
		errorResponse.put("result", "fail");
		errorResponse.put("message", ex.getMessage());
		
		return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
}
