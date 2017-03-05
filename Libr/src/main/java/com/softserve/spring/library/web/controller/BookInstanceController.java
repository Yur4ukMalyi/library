package com.softserve.spring.library.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.softserve.spring.library.entity.BookInstance;
import com.softserve.spring.library.services.BookInstanceService;
import com.softserve.spring.library.services.BookService;
import com.softserve.spring.library.services.UserService;

@Controller
@RequestMapping(path = "/inst")
public class BookInstanceController {

	@Autowired
	BookInstanceService bis;
	
	@Autowired
	BookService bs;
	
	@Autowired
	UserService us;

	@RequestMapping(value = { "/all" }, method = RequestMethod.GET)
	public ModelAndView books() {
		ModelAndView mav = new ModelAndView("bookInstances");
		List<BookInstance> bookinstances = bis.getAllBookInstances();
		mav.addObject("instances", bookinstances);
		return mav;
	}

	
	
	@GetMapping("/{bookId}")
	public ModelAndView getInstances(@PathVariable("bookId") String id) {
		Integer bookId =Integer.parseInt(id);
		ModelAndView model = new ModelAndView("bookInstances");
		model.addObject("instances", bs.getBookInstances(bookId));
		return model;
	}

	@GetMapping("info/{instanceId}")
	public ModelAndView getInstanceInfo(@PathVariable("instanceId") String id) {
		Integer bookInstId =Integer.parseInt(id);
		ModelAndView model = new ModelAndView("bookInstInfo");
		model.addObject("biObj", bis.getBookInstanceById(bookInstId));
		model.addObject("timesPicked", bis.getTimesTakenById(bookInstId));
		model.addObject("avgReadTime", bis.getAvgReadingTimeById(bookInstId));
		model.addObject("isAvailable", bis.isAvailable(bookInstId));
		return model;
	}
}