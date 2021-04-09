package com.AnimeWatchlist.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("logout");
		request.getSession().setAttribute("user", null);
		HttpSession httpSession = request.getSession();
		httpSession.invalidate();
		return mav;
	}
	
}
