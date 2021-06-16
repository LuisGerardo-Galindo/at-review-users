package at.review.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import at.review.users.dto.EditRequest;
import at.review.users.dto.UserDTO;
import at.review.users.dto.UserRequest;
import at.review.users.dto.UserResponse;
import at.review.users.service.UserService;

@RestController
@RequestMapping(value = "/api/v1")
public class UserController {

	@Autowired
	private UserService service;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("users/{id}")
	public UserDTO getUser(@PathVariable String id) {
		return service.getUser(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/users")
	public List<UserDTO> findAllUsers() {
		return service.getAllUsers();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(value = "/users", produces = "application/json")
	public UserResponse addUser(@RequestBody UserRequest request) {
		return service.addUser(request);
	}

	@ResponseStatus(HttpStatus.OK)
	@PutMapping(value = "/users/{id}", produces = "application/json")
	public UserResponse editUser(@RequestBody EditRequest request, @PathVariable String id) {
		return service.editUser(request, id);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable String id) {
		service.deleteUser(id);
	}
}
