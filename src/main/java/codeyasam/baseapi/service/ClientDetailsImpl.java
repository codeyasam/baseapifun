package codeyasam.baseapi.service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import codeyasam.baseapi.domain.Client;

public class ClientDetailsImpl implements ClientDetails {
	
	private static final long serialVersionUID = 3829389527932722515L;
	private Client client;
	
	public ClientDetailsImpl(Client client) {
		this.client = client;
	}
	
	@Override
	public Integer getAccessTokenValiditySeconds() {
		return 5000;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		Collection<GrantedAuthority> authorities = new HashSet<>();
		authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
		return authorities;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		// TODO Auto-generated method stub
		Set<String> grantTypes = new HashSet<>();
		grantTypes.add("client_credentials");
		grantTypes.add("password");
		grantTypes.add("refresh_token");
		return grantTypes;
	}

	@Override
	public String getClientId() {
		return client.getUsername();
	}

	@Override
	public String getClientSecret() {
		return client.getPassword();
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<String> getResourceIds() {
		Set<String> resourceIds = new HashSet<>();
		resourceIds.add("oauth2-resource");
		return resourceIds;
	}

	@Override
	public Set<String> getScope() {
		Set<String> scopes = new HashSet<>();
		scopes.add("read");
		scopes.add("write");
		scopes.add("trust");
		return scopes;
	}

	@Override
	public boolean isAutoApprove(String arg0) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isScoped() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isSecretRequired() {
		// TODO Auto-generated method stub
		return true;
	}

}
