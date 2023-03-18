package com.fabtec.authentication.exceptions.handler;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fabtec.authentication.exceptions.BadRequestException;
import com.fabtec.authentication.exceptions.ExceptionResponse;
import com.fabtec.authentication.exceptions.InvalidJwtAuthenticationException;
import com.fabtec.authentication.exceptions.NotFoundException;


@RestControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler{

	private DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllException(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = ExceptionResponse.builder()
				.title("INTERNAL SERVER ERROR")
				.timestamp(dtf.format(LocalDateTime.now()))
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message(ex.getMessage())
				.details(request.getDescription(false))
				.build();
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ExceptionResponse> handleNotFoundException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = ExceptionResponse.builder()
				.title("NOT FOUND")
				.timestamp(dtf.format(LocalDateTime.now()))
				.status(HttpStatus.NOT_FOUND.value())
				.message(ex.getMessage())
				.details(request.getDescription(false))
				.build();

		return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BadRequestException.class)
	public final ResponseEntity<ExceptionResponse> handleBadRequestException(Exception ex, WebRequest request) {
		ExceptionResponse exceptionResponse = ExceptionResponse.builder()
				.title("BAD REQUEST")
				.timestamp(dtf.format(LocalDateTime.now()))
				.status(HttpStatus.BAD_REQUEST.value())
				.message(ex.getMessage())
				.details(request.getDescription(false))
				.build();
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(InvalidJwtAuthenticationException.class)
	public final ResponseEntity<ExceptionResponse> handleInvalidJwtAuthenticationExceptions(Exception ex, WebRequest request){
		ExceptionResponse exceptionResponse = ExceptionResponse.builder()
				.title("FORBIDDEN")
				.timestamp(dtf.format(LocalDateTime.now()))
				.status(HttpStatus.INTERNAL_SERVER_ERROR.value())
				.message(ex.getMessage())
				.details(request.getDescription(false))
				.build();
		
		return new ResponseEntity<>(exceptionResponse, HttpStatus.FORBIDDEN);
	}

}
