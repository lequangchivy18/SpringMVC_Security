package com.springsecurity.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springsecurity.entity.User;
import com.springsecurity.repository.UserRepository;
import com.springsecurity.security.SecurityUser;
import com.springsecurity.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;


	 @Override
	    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

	        var user = repository.findByUsername(username);

	        if(user.isPresent()){
	           return new SecurityUser(user.get());
	        }

	        throw new UsernameNotFoundException("User not found: " + username);
	    }


	@Override
	public void save(User user) {
		repository.save(user);
	}


	@Override
	public boolean existById(String id) {
		// TODO Auto-generated method stub
		return repository.existsById(id);
	}


	@Override
	public void deleteById(String id) {
		repository.deleteById(id);
		
	}

}
