package com.prenotazioni.demo.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.prenotazioni.demo.repository.CustomerRepository;

@Service
public class MockUsersDetailsService implements UserDetailsService {

	@Autowired 
	private	CustomerRepository customerRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return new UserDetails() {

			@Override
			public Collection<? extends GrantedAuthority> getAuthorities() {
				List<SimpleGrantedAuthority> authorities = new ArrayList<>();
				 List<String> userRoles = customerRepository.findRoles(getUsername());
				 for (String role : userRoles) {
				        authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
				    }
			return authorities;
			
			}

			@Override
			public String getPassword() {
				String password = customerRepository.findPassword(getUsername());
				return "{noop}" + password;
			}

			@Override
			public String getUsername() {
				return username;
			}

			@Override
			public boolean isAccountNonExpired() {
				return true;
			}

			@Override
			public boolean isAccountNonLocked() {
				return true;
			}

			@Override
			public boolean isCredentialsNonExpired() {
				return true;
			}

			@Override
			public boolean isEnabled() {
				return true;
			}
		};
	}

}
