package at.review.users.exceptions.responses;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BadRequestResponse {
	private Date timestamp;
	private Integer httpCodeMessage;
	private String path;
	private String message;
	private List<ErrorDetails> errorDetails;

	@Data
	public static class ErrorDetails {
		private String fieldName;
		private String errorMessage;
	}

	public BadRequestResponse(Date timestamp, Integer httpCodeMessage, String path, String message,
			List<ErrorDetails> errorDetails) {
		super();
		this.timestamp = timestamp;
		this.httpCodeMessage = httpCodeMessage;
		this.path = path;
		this.message = message;
		this.errorDetails = errorDetails;
	}

}
