package com.yogy.user.dao.interfaces;

import com.yogy.util.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {

	public List<User> findByFirstName(String firstName);
	public List<User> findByLastName(String lastName);

}