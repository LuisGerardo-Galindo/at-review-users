package at.review.users.validator;

import static at.review.users.exceptions.ErrorConstants.ALREADY_EXISTING_EMAIL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.review.users.exceptions.BadRequestException;
import at.review.users.model.User;
import at.review.users.repository.UserRepository;

@Service
public class UserRequestValidator {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private DataValidator DataValidator;

	public void validate(User user) {
		DataValidator.validate(user);
		validateUniqueEmail(user.getEmail().toLowerCase());
	}

	private void validateUniqueEmail(String email) {
		if (userRepository.existsByEmail(email)) {
			throw new BadRequestException(String.format(ALREADY_EXISTING_EMAIL, email));
		}
	}

}
