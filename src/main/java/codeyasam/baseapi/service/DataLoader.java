package codeyasam.baseapi.service;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codeyasam.baseapi.domain.Role;
import codeyasam.baseapi.domain.User;
import codeyasam.baseapi.repository.RoleRepository;
import codeyasam.baseapi.repository.UserRepository;

@Service
public class DataLoader {
	
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private ModelMapper modelMapper;
	
	@Autowired
	public DataLoader(UserRepository userRepository, RoleRepository roleRepository, ModelMapper modelMapper) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.modelMapper = modelMapper;
	}
	
	@PostConstruct
	private void loadData() {
		Role role = new Role();
		role.setRole("ROLE_DUMP");
		roleRepository.save(role);
		
		User user = new User();
		user.setEmail("hjkl");
		user.setUsername("ssdfg");
		user.setPassword("hays");
		user.setFirstName("qewr");
		user.setLastName("asfd");
		userRepository.save(user);
	}
}
