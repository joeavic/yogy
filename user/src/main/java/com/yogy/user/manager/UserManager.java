package com.yogy.user.manager;

import com.mongodb.client.model.geojson.GeoJsonObjectType;
import com.mongodb.client.model.geojson.Geometry;
import com.yogy.user.dao.impl.UserDao;
import com.yogy.user.entity.OTP;
import com.yogy.user.dao.impl.OTPDao;
import com.yogy.user.entity.User;
import com.yogy.user.requests.SignUpReq;
import com.yogy.user.util.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

import com.google.common.geometry.*;

@Service
public class UserManager {

	@Autowired
	private OTPDao otpDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private RedisDao redisDao;

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
		System.out.println(otp.getCode());
		String otpcode = otp.getCode();
		if(!otpcode.equalsIgnoreCase(code)) throw new Exception("Incorrect otp entered");
		return "Success";
	}

	public void signUp(SignUpReq signUpReq, HttpServletRequest request, HttpServletResponse response) {
		User user = new User(signUpReq.getFirstName(), signUpReq.getLastName(), signUpReq.getContactNumber());
		user.setLat(signUpReq.getLat());
		user.setLon(signUpReq.getLon());
		S2LatLng s2LatLng = S2LatLng.fromDegrees(signUpReq.getLat(),signUpReq.getLat());
		S2CellId s2CellId = S2CellId.fromLatLng(s2LatLng);
		user.setS2CellId(s2CellId.id());
		S2CellId parentCell = s2CellId.parent(20);
		user.setLevel20S2CellId(parentCell.id());
		System.out.println(parentCell.id());
		userDao.save(user);
		redisDao.sadd(String.valueOf(parentCell.id()), user.getId());
		updateLatLon(signUpReq);
		response.setHeader("token", "r[vQ3J+ng)8%9''H");
	}

	@Async
	private void updateLatLon(SignUpReq signUpReq) {

	}

	public void print(Double lat, Double lng) {

		redisDao.sadd("Tetst", "valuey");
//		System.out.println(s2CellId.level());
//		System.out.println(s2CellId.id());

//		System.out.println("lattitude ->" + s2LatLng.lat());
//		System.out.println("longiotude ->" + s2LatLng.lng());
	}
}
