package com.softserve.spring.library.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.spring.library.entity.User;
import com.softserve.spring.library.services.BookService;
import com.softserve.spring.library.services.UserService;

@Controller
@RequestMapping(path = "/users")
public class UserController {

	@Autowired
	BookService bs;
	
     @Autowired
	UserService us;

	@RequestMapping(value = { "/all" }, method = RequestMethod.GET)
	public ModelAndView books() {
		ModelAndView mav = new ModelAndView("users");
		List<User> users = us.getAllUsers();
		mav.addObject("users", users);
		return mav;
	}

	@GetMapping("/info/{userId}")
	public ModelAndView getBookInfo(@PathVariable("userId") String id) {
		Integer userId =Integer.parseInt(id);
		ModelAndView model = new ModelAndView("userInfo");
		model.addObject("userObj", us.getUserById(userId));
		model.addObject("bookOnHands", us.booksWasNotReturned(userId));
		model.addObject("bookTaken", us.booksWasTaken(userId));
		model.addObject("timeSinceRegistration", us.getTimeSinceRegistration(userId));
		
		return model;
	}
	
	@RequestMapping(value = { "/statisticForm" }, method = RequestMethod.GET)
    public String showPopularityForm(ModelMap model) {
        return "statisticForm";
    }
	
	 @RequestMapping(value = "/statistic/result", method = RequestMethod.POST)
	    public ModelAndView getStatistic(@RequestParam String startDate,
	    		@RequestParam String endDate, ModelMap model) {

		ModelAndView modelAndView = new ModelAndView("userStatisticResult");
		modelAndView.addObject("statistic", us.getStatistic(startDate, endDate));
		
	        return modelAndView;

	    }
	
	 @RequestMapping(value = { "/byAuthorName" }, method = RequestMethod.GET)
	    public String showByAuthorForm(ModelMap model) {
	        return "byAuthorForm";
	    }

	 @RequestMapping(value = "/byAuthorName", method = RequestMethod.POST)
	    public ModelAndView avgUserAgeByAuthor(@RequestParam String author,
	    		 ModelMap model) {

		ModelAndView modelAndView = new ModelAndView("userAgeByAuthorResult");
		modelAndView.addObject("age", us.getAvgAgeByAuthor(author));
		modelAndView.addObject("name", author);
	        return modelAndView;

	    }
	

}