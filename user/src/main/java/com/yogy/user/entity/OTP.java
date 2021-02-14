package com.yogy.user.entity;

import org.springframework.stereotype.Service;

@Service
public class OTP  {

	private String loginParam;
	private String code;
	private Long creationTime;

	public String getLoginParam() {
		return loginParam;
	}

	public Long getCreationTime() {
		return creationTime;
	}

	public void setCreationTime(Long creationTime) {
		this.creationTime = creationTime;
	}

	public static String getOTP() {
		return OTP;
	}

	public void setLoginParam(String loginParam) {
		this.loginParam = loginParam;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public static String LOGIN_PARAM = "loginParam";
	public static String OTP = "code";
}
