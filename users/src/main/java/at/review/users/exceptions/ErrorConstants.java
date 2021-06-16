package at.review.users.exceptions;

public class ErrorConstants {
	public static final String MISSING_REQUIRED_INPUT = "Required field %s is missing.";
	public static final String ID = "id";
	public static final String USER = "User";

	public static final String INVALID_INPUT = "Invalid input on field %s. Correct format is: %s";
	public static final String CORRECT_FORMAT_NUMERIC = "A number with or " + "without a decimal point.";

	public static final String EMAIL = "email";
	public static final String ALREADY_EXISTING_EMAIL = "Email %s is already in use, "
			+ "try with another one or login.";

	public static final String PASSWORD = "password";

	public static final String NOT_FOUND_RESOURCE = "User was not found with the id: %s";
	public static final String BAD_REQUEST = "Your JSON request is badly formatted.";

	public static final String BAD_REQUEST_EMPTY_NULL_FIRST_NAME = "firstName is required.";
	public static final String BAD_REQUEST_EMPTY_NULL_LAST_NAME = "lastName is required.";
	public static final String BAD_REQUEST_EMPTY_NULL_PASSWORD = "password is required.";
	public static final String BAD_REQUEST_EMPTY_NULL_MAIL = "email is required.";
	public static final String BAD_REQUEST_MAIL_ALREADY_EXISTS = "email already exists.";
	public static final String VALIDATION_ERROR = "One or more fields are invalid";

	private ErrorConstants() {
	}
}
