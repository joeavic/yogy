package com.yogy.user.controller;

import com.yogy.user.manager.RecommendationManager;
import com.yogy.user.requests.RecommendationReq;
import com.yogy.user.requests.SignUpReq;
import com.yogy.user.response.RecommendationRes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
public class RecommendationController {

	@Autowired
	private RecommendationManager recommendationManager;

	@PostMapping("/getNearbyTeachers")
	private RecommendationRes getNearbyTeachers(@RequestBody RecommendationReq req) throws Exception{
		 return recommendationManager.getNearbyTeachers(req);
	}

}
