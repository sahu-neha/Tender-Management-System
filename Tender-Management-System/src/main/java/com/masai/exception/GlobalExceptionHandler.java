package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler(NoHandlerFoundException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimpstamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler1(Exception ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimpstamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler2(MethodArgumentNotValidException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimpstamp(LocalDateTime.now());
		err.setMessage(ce.getBindingResult().getFieldError().getDefaultMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler3(NotFoundException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimpstamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(VendorException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler4(VendorException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimpstamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(TenderException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler5(TenderException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimpstamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DisputeException.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler6(DisputeException ce, WebRequest req) {
		MyErrorDetails err = new MyErrorDetails();
		err.setTimpstamp(LocalDateTime.now());
		err.setMessage(ce.getMessage());
		err.setDetails(req.getDescription(false));

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

}
