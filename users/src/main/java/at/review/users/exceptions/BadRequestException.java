package at.review.users.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import at.review.users.exceptions.responses.BadRequestResponse.ErrorDetails;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {
	private List<ErrorDetails> errorDetails;

	public BadRequestException(String message) {
		super(message);
	}

	public BadRequestException(String message, List<ErrorDetails> errorDetails) {
		super(message);
		this.errorDetails = errorDetails;
	}
}
