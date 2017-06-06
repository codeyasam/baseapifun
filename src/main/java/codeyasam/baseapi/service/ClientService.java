package codeyasam.baseapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import codeyasam.baseapi.domain.Client;
import codeyasam.baseapi.repository.ClientRepository;

@Service
@Primary
public class ClientService implements ClientDetailsService {

	private ClientRepository clientRepository;
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public ClientService(ClientRepository clientRepository, BCryptPasswordEncoder passwordEncoder) {
		this.clientRepository = clientRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	@Override
	public ClientDetails loadClientByClientId(String username) throws ClientRegistrationException {
		Client client = clientRepository.findByUsername(username);
		if (client == null) {
			throw new ClientRegistrationException(username);
		}
		return new ClientDetailsImpl(client);
	}
	
	public void register(Client client) {
		client.setPassword(passwordEncoder.encode(client.getPassword()));
		clientRepository.save(client);
	}

}
