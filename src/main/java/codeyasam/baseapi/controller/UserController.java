package codeyasam.baseapi.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codeyasam.baseapi.DTO.UserDTO;
import codeyasam.baseapi.domain.Role;
import codeyasam.baseapi.domain.User;
import codeyasam.baseapi.exception.UserNotFoundException;
import codeyasam.baseapi.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userService;
	private ModelMapper modelMapper;
	
	@Autowired
	public UserController(UserService userService, ModelMapper modelMapper) {
		this.userService = userService;
		this.modelMapper = modelMapper;
	}
	
	@RequestMapping("/{id}")
	public UserDTO getUser(@PathVariable Long id) throws UserNotFoundException {
		User user = userService.findById(id);
		if (user == null) {
			throw new UserNotFoundException("User with id: " + id + " not found");
		}
		UserDTO userDTO = convertToDTO(user);
		
		List<String> roles = new ArrayList<>();
		for (Role role: user.getRoles()) {
			roles.add(role.getRole());
		}
		userDTO.setRoles(roles);
		return userDTO;
	}
	
	private UserDTO convertToDTO(User user) {
		UserDTO userDTO = modelMapper.map(user, UserDTO.class);
		return userDTO;
	}
	
	private User convertToEntity(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		return user;
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public void handleUserNotFound(UserNotFoundException exception, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value(), exception.getMessage());
	}
}
