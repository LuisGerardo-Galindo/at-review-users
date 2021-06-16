package at.review.users.validator;

import static at.review.users.exceptions.ErrorConstants.EMAIL;
import static at.review.users.exceptions.ErrorConstants.MISSING_REQUIRED_INPUT;
import static at.review.users.exceptions.ErrorConstants.PASSWORD;
import static at.review.users.exceptions.ErrorConstants.VALIDATION_ERROR;
import static at.review.users.validator.ValidationUtils.isValidString;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import at.review.users.exceptions.BadRequestException;
import at.review.users.exceptions.responses.BadRequestResponse.ErrorDetails;
import at.review.users.model.User;

@Service
public class DataValidator implements Validator<User> {

	private static final String FIRST_NAME = "firstName";
	private static final String LAST_NAME = "lastName";
	private static final String TYPE = "type";

	@Override
	public void validate(User user) {
		List<ErrorDetails> errorDetails = new ArrayList<>();
		validateFirstName(user.getFirstName(), errorDetails);
		validateLastName(user.getLastName(), errorDetails);
		validateEmailFormat(user.getEmail(), errorDetails);
		validatePassword(user.getPassword(), errorDetails);
		validateType(user.getType(), errorDetails);
		if (CollectionUtils.isNotEmpty(errorDetails))
			throw new BadRequestException(VALIDATION_ERROR, errorDetails);
	}

	private void validateFirstName(String firstName, List<ErrorDetails> errorDetails) {
		if (!isValidString(firstName)) {
			ErrorDetails error = new ErrorDetails();
			error.setErrorMessage(String.format(MISSING_REQUIRED_INPUT, FIRST_NAME));
			error.setFieldName(FIRST_NAME);
			errorDetails.add(error);
			return;
		}
	}

	private void validateLastName(String lastName, List<ErrorDetails> errorDetails) {

		if (!isValidString(lastName)) {
			ErrorDetails error = new ErrorDetails();
			error.setErrorMessage(String.format(MISSING_REQUIRED_INPUT, LAST_NAME));
			error.setFieldName(LAST_NAME);
			errorDetails.add(error);
			return;
		}
	}

	private void validateEmailFormat(String email, List<ErrorDetails> errorDetails) {

		if (!isValidString(email)) {
			ErrorDetails error = new ErrorDetails();
			error.setErrorMessage(String.format(MISSING_REQUIRED_INPUT, EMAIL));
			error.setFieldName(EMAIL);
			errorDetails.add(error);
			return;
		}
	}

	private void validatePassword(String password, List<ErrorDetails> errorDetails) {

		if (!isValidString(password)) {
			ErrorDetails error = new ErrorDetails();
			error.setErrorMessage(String.format(MISSING_REQUIRED_INPUT, PASSWORD));
			error.setFieldName(PASSWORD);
			errorDetails.add(error);
			return;
		}
	}

	private void validateType(String type, List<ErrorDetails> errorDetails) {

		if (!isValidString(type)) {
			ErrorDetails error = new ErrorDetails();
			error.setErrorMessage(String.format(MISSING_REQUIRED_INPUT, TYPE));
			error.setFieldName(type);
			errorDetails.add(error);
			return;
		}
	}
}
