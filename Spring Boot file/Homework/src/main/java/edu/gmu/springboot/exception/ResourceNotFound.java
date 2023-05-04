package edu.gmu.springboot.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {

	private static final long serialVersionID = 1L; 
	
	public ResourceNotFound(String message) {
		super(message);
	}
}
