package com.yogy.utils.core.controller;

import com.yogy.utils.core.manager.UserManager;
import com.yogy.utils.core.requests.SignUpReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

	@Autowired
	private UserManager userManager;

	@PostMapping("/otp")
	String otp(@PathVariable String loginParam){
		userManager.sendOTP(loginParam);
		return "Success";
	}

	@PostMapping("/verify")
	String otp(@PathVariable String loginParam, @PathVariable String code) throws Exception{
		userManager.verifyOTP(loginParam, code);
		return "Success";
	}

	@PostMapping("/signUp")
	String otp(@RequestBody SignUpReq signUpReq, HttpServletRequest request, HttpServletResponse response) throws Exception{
		userManager.signUp(signUpReq, request, response);
		return "Success";
	}


}
