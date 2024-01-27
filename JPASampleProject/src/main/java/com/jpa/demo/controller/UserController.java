package com.jpa.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.demo.dao.UserRepository;
import com.jpa.demo.model.UserEntity;
import com.jpa.demo.services.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/")
	public String home()
	{
		System.out.println("Inside Controller");
		return "home.jsp";
	}
	
	@RequestMapping("/addData")
	public String addData(UserEntity userEntity) {
			
		userRepository.save(userEntity);
		return "test.jsp";
	}
		
	@RequestMapping("/test")
	public String test() {
		System.out.println("Inside Test Controller");
		return "test.jsp";
	}
	
	@GetMapping("/restTest")
	public String restTest() {
		return "Test method is triggered";
	}
	

	@GetMapping("/users/{id}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable("id") int id) {
		UserEntity userEntity= userService.getUserById(id);
		if(userEntity==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(userEntity));
	}
	
	//Second way to use the same method using RequestParam annotation instead of PathVariable
	@GetMapping("/users")
	public UserEntity getUserById1(@RequestParam("id") int id) {
		UserEntity userEntity= userService.getUserById(id);
		return userEntity;
	}
	
	@GetMapping(path="/users", produces="application/json")
	public ResponseEntity<List<UserEntity>> getUsers() {
		List<UserEntity> list =userService.getUsers();
		if(list.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		
		return ResponseEntity.of(Optional.of(list));
	}
	
//	@GetMapping("/users/{name}")
//	public List<UserEntity> getUsersByName(@PathVariable("name") String name) {
//		System.out.println("Inside getUserByName Controller: "+name);
//		return userService.getUsersByName(name);
//	}
	
	
	@PostMapping("users")
	public void addUsers(@RequestBody UserEntity userEntity)
	{
		userService.addUsers(userEntity);
	}
	

}
