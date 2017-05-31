package codeyasam.baseapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codeyasam.baseapi.DTO.RoleDTO;
import codeyasam.baseapi.DTO.UserDTO;
import codeyasam.baseapi.domain.Role;
import codeyasam.baseapi.domain.User;
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
	public UserDTO getUser(@PathVariable Long id) {
		User user = userService.findById(id);
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
}
