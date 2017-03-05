package com.softserve.spring.library.web.controller;

import com.softserve.spring.library.entity.Author;
import com.softserve.spring.library.services.AuthorService;
import com.softserve.spring.library.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping(path = "/authors")
public class AuthorController {

    @Autowired
    BookService bookService;

    @Autowired
    AuthorService authorService;

    @RequestMapping(value = { "/all" }, method = RequestMethod.GET)
    public ModelAndView authors() {
        ModelAndView mav = new ModelAndView("authors");
        List<Author> authors = authorService.getAllAuthors();
        mav.addObject("authors", authors);
        return mav;
    }

    @RequestMapping(value = { "/author/{authorId}" })
    public ModelAndView booksByAuthor(@PathVariable("authorId") int id) {
        ModelAndView mav = new ModelAndView("booksByAuthor");
        mav.addObject("author", authorService.getAuthorById(id));
        mav.addObject("books", bookService.findBookByAuthor(id));
        return mav;
    }

    @RequestMapping(value = {"/coauthor/{authorId}"})
    public ModelAndView booksByCoAuthor(@PathVariable("authorId") int id) {
        ModelAndView mav = new ModelAndView("booksByCoauthor");
        mav.addObject("author", authorService.getAuthorById(id));
        mav.addObject("books", bookService.bookByCoAuthor(id));
        return mav;
    }
}
