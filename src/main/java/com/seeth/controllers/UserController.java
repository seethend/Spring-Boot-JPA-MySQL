package com.seeth.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.seeth.models.User;
import com.seeth.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping(value="/signup")
	public String getSignupPage(ModelMap model) {
		return "signup";
	}
	
	@PostMapping(value="/signup")
	public String postSignupPage(ModelMap model, @ModelAttribute @Valid User user, BindingResult result) {
		
		if(result.hasErrors()) {
			return "signup";
		}
		
		System.out.println(user);
		userService.save(user);
		model.addAttribute("success", user);
		return "success";
	}
	
}
