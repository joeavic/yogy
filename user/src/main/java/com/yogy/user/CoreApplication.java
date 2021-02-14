package com.yogy.user;


import com.yogy.user.dao.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.yogy.*"})
@EntityScan("com.yogy.*")
public class CoreApplication {

	@Autowired
	private UserRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
