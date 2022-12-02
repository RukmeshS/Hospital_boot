package com.ty.Hospital_boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ty.Hospital_boot.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(NoSuchIdFoundException.class)
	public  ResponseEntity<ResponseStructure<String>> noSuchIdFoundHandler(NoSuchIdFoundException exception){
		
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Such ID is Present");
		responseStructure.setData(exception.getMessage());
		return responseEntity;
	}
	
	
	@ExceptionHandler(NoSuchIdPresentForUpdateException.class)
	public  ResponseEntity<ResponseStructure<String>> noSuchIdPresentForUpdateHandler(NoSuchIdPresentForUpdateException exception){
		
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		ResponseEntity<ResponseStructure<String>> responseEntity=new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No Such Existing Id is present to be Updated");
		responseStructure.setData(exception.getMessage());
		return responseEntity;
	}

	
}
