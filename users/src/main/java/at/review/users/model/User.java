package at.review.users.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import lombok.Data;

@Data
@Document(collection = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String type;
}
