package com.yogy.utils.core;

import com.yogy.utils.core.dao.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CoreApplication {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
