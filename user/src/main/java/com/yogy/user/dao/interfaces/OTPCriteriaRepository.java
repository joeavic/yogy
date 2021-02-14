package com.yogy.user.dao.interfaces;

import com.yogy.user.entity.OTP;

public interface OTPCriteriaRepository {
	public OTP getOTPByLoginParam(String loginparam);
}
