package com.yogy.user.controller;


import com.yogy.user.manager.UserManager;
import com.yogy.user.requests.SignUpReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

	@Autowired
	private UserManager userManager;

	@PostMapping("/otp")
	String otp(@RequestParam("loginParam") String loginParam){
		userManager.sendOTP(loginParam);
		return "Success";
	}

	@PostMapping("/verify")
	String verify(@RequestParam(value = "loginParam", required = true) String loginParam, @RequestParam(value = "code", required = true) String code) throws Exception{
		userManager.verifyOTP(loginParam, code);
		return "Success";
	}

	@PostMapping("/signUp")
	String otp(@RequestBody SignUpReq signUpReq, HttpServletRequest request, HttpServletResponse response) throws Exception{
		userManager.signUp(signUpReq, request, response);
		return "Success";
	}


	@PostMapping("/lat")
	String lat(@RequestParam("lat") Double lat, @RequestParam("lng") Double lng){
		userManager.print(lat,lng);
		return "Success";
	}


}
