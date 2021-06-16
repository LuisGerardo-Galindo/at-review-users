package at.review.users.validator;

import static at.review.users.exceptions.ErrorConstants.ALREADY_EXISTING_EMAIL;
import static at.review.users.exceptions.ErrorConstants.ID;
import static at.review.users.exceptions.ErrorConstants.MISSING_REQUIRED_INPUT;
import static at.review.users.exceptions.ErrorConstants.NOT_FOUND_RESOURCE;
import static at.review.users.exceptions.ErrorConstants.USER;
import static at.review.users.validator.ValidationUtils.isValidString;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.review.users.exceptions.BadRequestException;
import at.review.users.exceptions.UserNotFoundException;
import at.review.users.model.User;
import at.review.users.repository.UserRepository;

@Service
public class EditValidator {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DataValidator dataValidator;

	public void validate(User user) {
		String emailOfUserToUpdate = validateGivenId(user.getId());
		dataValidator.validate(user);
		validateUniqueEmail(user.getEmail(), emailOfUserToUpdate);
	}

	private String validateGivenId(String id) {
		if (!isValidString(id))
			throw new BadRequestException(String.format(MISSING_REQUIRED_INPUT, ID));
		Optional<User> userFoundById = userRepository.findById(id);
		if (!userFoundById.isPresent())
			throw new UserNotFoundException(String.format(NOT_FOUND_RESOURCE, USER, id));
		return userFoundById.get().getEmail();
	}

	private void validateUniqueEmail(String emailInRequest, String emailOfUserToUpdate) {
		if (userRepository.existsByEmail(emailInRequest) && !emailInRequest.equals(emailOfUserToUpdate)) {
			throw new BadRequestException(String.format(ALREADY_EXISTING_EMAIL, emailInRequest));
		}
	}
}
