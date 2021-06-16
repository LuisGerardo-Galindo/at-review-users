package at.review.users.service;

import java.util.List;

import at.review.users.dto.EditRequest;
import at.review.users.dto.UserDTO;
import at.review.users.dto.UserRequest;
import at.review.users.dto.UserResponse;

public interface UserService {
	UserDTO getUser(String id);

	List<UserDTO> getAllUsers();

	UserResponse addUser(UserRequest request);

	UserResponse editUser(EditRequest request, String id);

	void deleteUser(String id);
}
