package com.AnimeWatchlist.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.AnimeWatchlist.entities.User;
import com.AnimeWatchlist.services.UserServices;

@Controller
public class RegistrationController {

	@Autowired
	UserServices us;
	
	@RequestMapping("/register")
	public ModelAndView registerHandler() {
		ModelAndView mav = new ModelAndView("register");
		return mav;
	}
	
	// Method to take registration page form data and verify inputs.
	@RequestMapping(value="registerSubmit", method=RequestMethod.POST)
	public ModelAndView registerUserHandler(@ModelAttribute User user, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("register");
		
		if(user.getUserPassword().equals(user.getVerifyPassword()) && user.getUserPassword().length() > 6 && us.getUser(user.getUsername()) == null) {
			us.addUser(user);
			request.setAttribute("registrationSuccessful", "You've succesfully registered! You can now login.");
			mav.setViewName("login");
		}
		
		// Check for username length
		if(user.getUsername().length() < 4) {
			request.setAttribute("usernameShort", "Username is too short! please use at least 4 characters");
			request.getRequestDispatcher("/register");
		}
		
		// Check for username already existing in Db
		if(us.getUser(user.getUsername()) != null) {
			request.setAttribute("usernameMessage", "Username already taken, please try another.");
			request.getRequestDispatcher("/register");
		}
		
		// Check for password length
		if(user.getUserPassword().length() < 6) {
					request.setAttribute("passwordMessage", "\"Password\" must be at least 6 characters.");
					request.getRequestDispatcher("/register");
		}
		
		// Check that userPassword and verifyPassword match
		if (!user.getUserPassword().equals(user.getVerifyPassword())){
			request.setAttribute("message", "\"Password\" field must match \"Verify Password\" field. Please try again.");
			request.getRequestDispatcher("/register");
		}
		return mav;
	}
	
	
}
