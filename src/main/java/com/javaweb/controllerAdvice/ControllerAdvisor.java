package com.javaweb.controllerAdvice;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.javaweb.customException.FieldRequiredException;
import com.javaweb.model.ErrorResponseDTO;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {
	@ExceptionHandler(FieldRequiredException.class)
	public ResponseEntity<Object> handleFieldRequiredException(FieldRequiredException ex,WebRequest wb){
		ErrorResponseDTO error= new ErrorResponseDTO();
		error.setError(ex.getMessage());
		ArrayList<String> list= new ArrayList<>();
		list.add("Input khong phu hop");
		error.setDetail(list);
		return new ResponseEntity<>(error, HttpStatus.BAD_GATEWAY );
	} 
	
}
