package com.example.userservice.controller;

import com.example.userservice.entity.User;
import com.example.userservice.service.UserService;
import com.example.userservice.vo.Department;
import com.example.userservice.vo.ResponseTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("id/{id}")
	public ResponseEntity<ResponseTemplate> findUserById (@PathVariable("id") Long id) {
		Optional<User> optionalUser = userService.findUserById(id);
		if(optionalUser.isPresent()){
			Department department = restTemplate.getForObject("http://localhost:8002/department/id/"
					+ optionalUser.get().getDepaermentId(), Department.class);
			
			ResponseTemplate template = ResponseTemplate.builder()
					.department(department)
					.user(optionalUser.get())
					.build();
			return ResponseEntity.ok().body(template);
		}else throw new ResponseStatusException(HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/save")
	public ResponseEntity<User> save (@RequestBody User user) {
		return ResponseEntity.ok().body(userService.save(user));
	}
	
}
