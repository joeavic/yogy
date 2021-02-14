package com.yogy.user.dao.interfaces;


import com.yogy.user.entity.OTP;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OTPRepository extends MongoRepository<OTP, String>, OTPCriteriaRepository {

}
