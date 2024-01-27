package com.jpa.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.demo.dao.UserRepository;
import com.jpa.demo.model.UserEntity;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;
	
	public UserEntity getUserById(int id)
	{
		UserEntity userEntity= null;
		try {
			userEntity=	userRepository.findById(id).get();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userEntity;
	}
	
	public List<UserEntity> getUsers(){
		List<UserEntity> userList= new ArrayList<>();
		userRepository.findAll().forEach(userEntity->{userList.add(userEntity);});
		System.out.println("UserList::"+userList);
		return userList;
	}
	
	
	public List<UserEntity> getUsersByName(String name){
		List<UserEntity> userList=new ArrayList<>();
		userList=userRepository.findByName(name);
		System.out.println("UserList::"+userList);
		return userList;
	}
	
	public void addUsers(UserEntity userEntity) {
		userRepository.save(userEntity);
	}
}
