package at.review.users.exceptions;

import java.util.Date;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import at.review.users.exceptions.responses.BadRequestResponse;
import at.review.users.exceptions.responses.NotFoundResponse;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	protected ResponseEntity<NotFoundResponse> handleNotFoundException(UserNotFoundException ex, WebRequest request) {
		NotFoundResponse response = new NotFoundResponse(new Date(), HttpStatus.NOT_FOUND.value(),
				request.getDescription(false), ex.getMessage());
		return new ResponseEntity<NotFoundResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(BadRequestException.class)
	protected ResponseEntity<BadRequestResponse> handleBadRequestException(BadRequestException ex, WebRequest request) {
		BadRequestResponse response = new BadRequestResponse(new Date(), HttpStatus.BAD_REQUEST.value(),
				request.getDescription(false), ex.getMessage(), ex.getErrorDetails());
		return new ResponseEntity<BadRequestResponse>(response, HttpStatus.BAD_REQUEST);
	}
}
