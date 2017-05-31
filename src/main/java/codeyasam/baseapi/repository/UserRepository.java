package codeyasam.baseapi.repository;

import org.springframework.data.repository.CrudRepository;

import codeyasam.baseapi.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);
}
