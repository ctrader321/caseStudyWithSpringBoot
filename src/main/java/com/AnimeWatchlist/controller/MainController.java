package com.AnimeWatchlist.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.AnimeWatchlist.entities.Show;
import com.AnimeWatchlist.entities.User;
import com.AnimeWatchlist.services.ShowServices;
import com.AnimeWatchlist.services.UserCurrentShowServices;
import com.AnimeWatchlist.services.UserServices;

@Controller
public class MainController {

	@Autowired
	ShowServices shs;

	@Autowired
	UserServices us;

	@Autowired
	UserCurrentShowServices ucss;

	@RequestMapping("/")
	public ModelAndView loginHandler1() {
		ModelAndView mav = new ModelAndView("login");
		return mav;
	}

	@RequestMapping("/login")
	public ModelAndView loginHandler2() {
		return new ModelAndView("login");
	}

	// Calls validate user method from UserServices to check form inputs.
	@RequestMapping(value = "loginProcess", method = RequestMethod.POST)
	public String loginHandlerTesting(@RequestParam("username") String username, @RequestParam("userPassword") String userPassword, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		// if user has entered correct user info, sets user session attribute and brings them to the home page.
		if (us.validateUser(username, userPassword) != null) {
			User user = us.getUser(username);
			request.getSession().setAttribute("user", user);
			mav.addObject("user", user);
			return "redirect:/index";
		// if user enters incorrect info, they stay on login page with a message popup.
		} else {
			request.setAttribute("message", "Unknown username/password. Please try again. Click Create an Account below if this is your first visit :");
			request.getRequestDispatcher("/");
		}

		return "/login";
	}
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView indexHandler(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("index");
		User u = (User)request.getAttribute("user");
		mav.addObject("user", u);
		mav.addObject("allShowsInDb", shs.getAllShows());
		return mav;
	}
	
	// When user adds a show to "our collection" from the homepage
	@RequestMapping(value="addShowToDb", method = RequestMethod.POST)
	public ModelAndView addNewShowToTable(@ModelAttribute("Show") Show show, HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		// Check to see if user session attribute is available, else return user to login message and display message.
		if((User)request.getSession().getAttribute("user") !=null ) {
		// if it already exists, reload homepage for user and display this message
			if(shs.getShow(show.getShowName()) != null) {
				request.setAttribute("showAlreadyInDb", "We already have a record of that show! Please try adding something else!");
				return indexHandler(request);
			// if it doesn't exist, add the show and display message.
			} else {
				shs.addShow(show);
				request.setAttribute("showAddedSuccess", "You've Successfully added a show to our Collection!");
			}
			
		} else {
			mav.setViewName("login");
			request.setAttribute("loginAgainMessage", "Please sign in again!");
			return mav;
		}
		return indexHandler(request);
	}
	
}

