package codeyasam.baseapi.repository;

import org.springframework.data.repository.CrudRepository;

import codeyasam.baseapi.domain.Client;

public interface ClientRepository extends CrudRepository<Client, Long> {
	
	public Client findByUsername(String username);
}
