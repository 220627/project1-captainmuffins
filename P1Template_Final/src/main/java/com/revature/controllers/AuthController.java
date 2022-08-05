package com.revature.controllers;

import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;
import com.revature.models.LoginDTO;
import com.revature.models.User;
import com.revature.services.AuthService;

import io.javalin.http.Handler;

public class AuthController {


	public static Logger log = LogManager.getLogger();
	
	AuthService as = new AuthService();
	
	
	public static HttpSession ses;
	
	
	public Handler loginHandler = (ctx) -> {
		
		String body = ctx.body();
		
		Gson gson = new Gson();
		
		LoginDTO lDTO = gson.fromJson(body, LoginDTO.class);
		
		User user = as.login(lDTO.getUsername(), lDTO.getPassword()); 
		
		if(user != null) { 
			
			
			log.info("User Logged In!");
			
			ses = ctx.req.getSession(); 
			
			String userJSON = gson.toJson(user); 
			
			ctx.result(userJSON); 
			ctx.status(202); 
			
		} else {
			
			
			log.warn("User Failed to Login!");
			
			ctx.status(401); 
		} 
		
	}; 
	
}
