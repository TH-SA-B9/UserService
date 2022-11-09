package com.example.userservice.service;

import com.example.userservice.entity.User;
import com.example.userservice.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User save (User user) {
		return userRepository.save(user);
	}
	
	public Optional<User> findUserById (Long id) {
		return userRepository.findById(id);
	}
}
