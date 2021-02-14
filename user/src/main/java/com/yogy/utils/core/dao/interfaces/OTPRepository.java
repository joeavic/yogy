package com.yogy.utils.core.dao.interfaces;

import com.yogy.utils.core.entity.OTP;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OTPRepository extends MongoRepository<OTP, String>, OTPCriteriaRepository {

}
