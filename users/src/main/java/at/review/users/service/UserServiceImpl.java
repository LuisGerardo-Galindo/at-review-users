package at.review.users.service;

import static at.review.users.exceptions.ErrorConstants.NOT_FOUND_RESOURCE;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import at.review.users.dto.EditRequest;
import at.review.users.dto.UserDTO;
import at.review.users.dto.UserRequest;
import at.review.users.dto.UserResponse;
import at.review.users.exceptions.UserNotFoundException;
import at.review.users.model.User;
import at.review.users.repository.UserRepository;
import at.review.users.validator.EditValidator;
import at.review.users.validator.UserRequestValidator;
import ma.glasnost.orika.MapperFacade;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private MapperFacade orikaMapperFacade;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserRequestValidator userRequestValidator;

	@Autowired
	private EditValidator editValidator;

	@Override
	public UserDTO getUser(String id) {
		Optional<User> userSearch = userRepository.findById(id);
		if (!userSearch.isPresent()) {
			throw new UserNotFoundException(NOT_FOUND_RESOURCE + id);
		}
		return orikaMapperFacade.map(userSearch.get(), UserDTO.class);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> userList = userRepository.findAll();
		if (userList.toString() == "[]") {
			throw new UserNotFoundException("No users exist in the database");
		}
		return orikaMapperFacade.mapAsList(userList, UserDTO.class);
	}

	@Override
	public UserResponse addUser(UserRequest request) {
		User user = orikaMapperFacade.map(request, User.class);
		userRequestValidator.validate(user);
		User newUser = userRepository.save(user);
		return orikaMapperFacade.map(newUser, UserResponse.class);
	}

	@Override
	public UserResponse editUser(EditRequest request, String id) {
		request.setId(id);
		User user = orikaMapperFacade.map(request, User.class);
		editValidator.validate(user);
		User editedUser = userRepository.save(user);
		return orikaMapperFacade.map(editedUser, UserResponse.class);
	}

	@Override
	public void deleteUser(String id) {
		Optional<User> userSearch = userRepository.findById(id);
		if (!userSearch.isPresent()) {
			throw new UserNotFoundException(NOT_FOUND_RESOURCE + id);
		}
		userRepository.deleteById(id);
	}
}
