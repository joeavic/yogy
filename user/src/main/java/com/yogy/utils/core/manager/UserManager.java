package com.yogy.utils.core.manager;

import com.yogy.utils.core.dao.impl.OTPDao;
import com.yogy.utils.core.dao.impl.UserDao;
import com.yogy.utils.core.entity.OTP;
import com.yogy.utils.core.entity.User;
import com.yogy.utils.core.requests.SignUpReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

@Service
public class UserManager {

	@Autowired
	private OTPDao otpDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private final Random random = new Random();

	public void sendOTP(String loginParam) {
		String otp = String.format("%04d", random.nextInt(10000));
		OTP otpReq = new OTP();
		otpReq.setCode(otp);
		otpReq.setLoginParam(loginParam);
		otpDao.save(otpReq);
	}

	public String verifyOTP(String loginParam, String code) throws Exception {
		OTP otp = otpDao.getOTPByLoginParam(loginParam);
		String otpcode = otp.getCode();
		if(!otpcode.equalsIgnoreCase(code)) throw new Exception("Incorrect otp entered");
		return "Success";
	}

	public void signUp(SignUpReq signUpReq, HttpServletRequest request, HttpServletResponse response) {
		User user = new User(signUpReq.getFirstName(), signUpReq.getLastName(), signUpReq.getContactNumber());
		userDao.save(user);
		response.setHeader("token", "r[vQ3J+ng)8%9''H");
	}
}
