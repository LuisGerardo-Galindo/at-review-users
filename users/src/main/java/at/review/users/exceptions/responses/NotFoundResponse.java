package at.review.users.exceptions.responses;

import java.util.Date;

import lombok.Data;

@Data
public class NotFoundResponse {
	private Date timestamp;
	private Integer httpCodeMessage;
	private String path;
	private String message;

	public NotFoundResponse(Date timestamp, Integer httpCodeMessage, String path, String message) {
		super();
		this.timestamp = timestamp;
		this.httpCodeMessage = httpCodeMessage;
		this.path = path;
		this.message = message;
	}

}
