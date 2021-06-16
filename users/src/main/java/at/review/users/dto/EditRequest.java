package at.review.users.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EditRequest {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String type;
}
