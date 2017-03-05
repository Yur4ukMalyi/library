package com.softserve.spring.library.web.controller;

import java.util.ArrayList;
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

import com.softserve.spring.library.entity.Book;
import com.softserve.spring.library.entity.ByBookNameStatisticDTO;
import com.softserve.spring.library.services.BookService;
import com.softserve.spring.library.services.UserService;

@Controller
@RequestMapping(path = "/books")
public class BookController {

	@Autowired
	BookService bs;
	
	@Autowired
	UserService us;

	@RequestMapping(value = { "/all" }, method = RequestMethod.GET)
	public ModelAndView books() {
		ModelAndView mav = new ModelAndView("books");
		List<Book> books = bs.getAllBooks();
		mav.addObject("books", books);
		return mav;
	}

	@GetMapping("/info/{bookId}")
	public ModelAndView getBookInfo(@PathVariable("bookId") String id) {
		Integer bookId =Integer.parseInt(id);
		ModelAndView model = new ModelAndView("bookInfo");
		model.addObject("bookObj", bs.getBookById(bookId));
		model.addObject("book", id);
		model.addObject("isAvailable", bs.checkIfAvailableById(bookId));
		model.addObject("timesPicked", bs.getTimesBookTakenById(bookId));
		model.addObject("avgReadingTime", bs.getAvgReadingTimeById(bookId));
		model.addObject("avgAge", us.getAvgAgeByBook(bookId));
		
		return model;
	}
	
	 @RequestMapping(value = { "/byName/form" }, method = RequestMethod.GET)
	    public String showForm(ModelMap model) {
	        return "bookForm";
	    }
	 
	 @RequestMapping(value = "/byName", method = RequestMethod.POST)
	    public ModelAndView getByCity(@RequestParam String book, ModelMap model) {

	        return new ModelAndView("bookResult", "res", new ArrayList<ByBookNameStatisticDTO>(bs.getStatistic(book)));

	    }
	 
		@RequestMapping(value = { "/indep" }, method = RequestMethod.GET)
		public ModelAndView booksIndep() {
			ModelAndView mav = new ModelAndView("bookIndap");
			List<Book> books = bs.booksIndependanceInstances();
			mav.addObject("books", books);
			return mav;
		}

		
		@RequestMapping(value = { "/popularityForm" }, method = RequestMethod.GET)
	    public String showPopularityForm(ModelMap model) {
	        return "popularityForm";
	    }
		
		 @RequestMapping(value = "/popularity/result", method = RequestMethod.POST)
		    public ModelAndView getPopular(@RequestParam String startDate,
		    		@RequestParam String endDate, ModelMap model) {

			ModelAndView modelAndView = new ModelAndView("popularityResult");
			modelAndView.addObject("mostPopular", bs.getMostPopular(startDate, endDate));
			modelAndView.addObject("leastPopular", bs.getLeastPopular(startDate, endDate));
			
		        return modelAndView;

		    }
}