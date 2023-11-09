package com.example.demo.controller.exceptionhandler;

import java.net.URI;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.demo.domain.exception.BusinessException;
import com.example.demo.domain.exception.UserNotFoundException;

@RestControllerAdvice
public class GlobalException extends ResponseEntityExceptionHandler {

	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest request) {

            ProblemDetail problem = ProblemDetail.forStatus(HttpStatusCode.valueOf(400));
            problem.setType(URI.create("https://chuck-random-message.com/errors/argument-not-valid"));
            problem.setTitle("Error validating the fields entered");
            problem.setDetail("One or more fields are invalid. Fill in correctly and try again.");
            problem.setProperty("timestamp", Instant.now());

            Map<String, String> errors = getErrorFields(ex);
            errors.forEach((fieldName, message) -> {
                problem.setProperty(fieldName, message);
            });
            
          return new ResponseEntity<Object>(problem, status);
      }

	private Map<String, String> getErrorFields(MethodArgumentNotValidException ex) {
		Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {

		  String fieldName = ((FieldError) error).getField();
		  String message = error.getDefaultMessage();
		  errors.put(fieldName, message);
		});
		return errors;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	ProblemDetail handlerhttpMessageNotReadableException(UserNotFoundException e) {
		ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, e.getMessage());
		
		problem.setTitle("User not found");
		problem.setType(URI.create("https://chuck-random-message.com/errors/entity-not-found"));
		problem.setProperty("timestamp", Instant.now());
		return problem;
				
	}
	
	@ExceptionHandler(BusinessException.class)
	ProblemDetail handlerhttpMessageNotReadableException(BusinessException e) {
		ProblemDetail problem = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, e.getMessage());
		
		problem.setTitle("Violação de regra de negócio.");
		problem.setType(URI.create("https://chuck-random-message.com/errors/business-error"));
		problem.setProperty("timestamp", Instant.now());
		return problem;
		
		
	}
	
}