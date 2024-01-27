package com.jpa.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jpa.demo.model.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Integer>{

	List<UserEntity> findByName(String name);
}
