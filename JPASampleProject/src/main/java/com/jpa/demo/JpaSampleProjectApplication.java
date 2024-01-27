package com.jpa.demo;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.jpa.demo.dao.UserRepository;
import com.jpa.demo.model.UserEntity;

@SpringBootApplication
public class JpaSampleProjectApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(JpaSampleProjectApplication.class, args);
//		UserRepository userRepo= context.getBean(UserRepository.class);
//		
//		
//		UserEntity userEntity=new UserEntity();
//		UserEntity userEntity2=new UserEntity();
//		UserEntity userEntity3=new UserEntity();
//		List.of(userEntity,userEntity2,userEntity3);
//
//		userEntity.setCity("Moradabad");.
//		userEntity.setName("Kshitiz");
//		userEntity.setState("UP");
		
		//UserEntity user2= userRepo.save(userEntity);
		
		//System.out.println(user2);
	}

}
