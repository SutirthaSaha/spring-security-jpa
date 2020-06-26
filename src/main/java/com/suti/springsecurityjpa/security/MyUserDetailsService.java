package com.suti.springsecurityjpa.security;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.suti.springsecurityjpa.model.User;
import com.suti.springsecurityjpa.repository.UserRepository;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	Logger logger=LoggerFactory.getLogger(MyUserDetailsService.class);
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		Optional<User> user= userRepository.findByUserName(userName);
		logger.debug("User: {}",user);
		user.orElseThrow(()->new UsernameNotFoundException("Not Found "+userName));
		return user.map(MyUserDetails::new).get();
	}
	
}
