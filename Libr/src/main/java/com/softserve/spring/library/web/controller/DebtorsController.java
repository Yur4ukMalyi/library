package com.softserve.spring.library.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.spring.library.entity.Book;
import com.softserve.spring.library.entity.User;
import com.softserve.spring.library.services.BookService;
import com.softserve.spring.library.services.UserService;

@Controller
@RequestMapping(path = "/debtors")
public class DebtorsController {
	
	@Autowired
	BookService bs;
	
	@Autowired
	UserService us;
	
	@RequestMapping(value = { "/all" }, method = RequestMethod.GET)
	public ModelAndView debtors() {
		ModelAndView mav = new ModelAndView("debtors");
		List<User> debtors = us.getDebtors();
		mav.addObject("debtors", debtors);
		return mav;
	}
}
