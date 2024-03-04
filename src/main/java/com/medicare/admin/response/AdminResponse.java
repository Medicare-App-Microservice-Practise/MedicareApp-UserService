package com.medicare.admin.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class AdminResponse {

	public ResponseEntity<Object> responseWithoutData(String message, HttpStatus httpStatus)
	{
		Map<String,Object> response = new HashMap<>();
		
		response.put("result", message);
		
		return new ResponseEntity<Object>(response, httpStatus);
	}
	
	public ResponseEntity<Object> responseWithData (String message, Object object, HttpStatus httpStatus)
	{
		Map<String,Object> response = new HashMap<>();
		
		response.put("result", message);
		response.put("data", object);
		
		return new ResponseEntity<Object>(response, httpStatus);
	}
	
}
