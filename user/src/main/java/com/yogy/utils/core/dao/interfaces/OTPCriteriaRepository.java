package com.yogy.utils.core.dao.interfaces;

import com.yogy.utils.core.entity.OTP;

public interface OTPCriteriaRepository {
	public OTP getOTPByLoginParam(String loginparam);
}
