package com.yogy.user.dao.interfaces;


import com.yogy.user.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface UserRepository extends MongoRepository<User, String> {

}