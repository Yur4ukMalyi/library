package com.softserve.spring.library.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.spring.library.dao.interfaces.AuthorDAO;
import com.softserve.spring.library.entity.Author;
import com.softserve.spring.library.services.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	AuthorDAO authorDAO;
	
	public void addAuthor(Author author){
		authorDAO.addElement(author);
	}
	
	public void updateAuthor(Author author){
		authorDAO.updateElement(author);
	}
	
	public Author getAuthorById(Integer id){
		return authorDAO.getElementByID(id);
	}
	
	public void deleteAuthor(Author author){
		authorDAO.deleteElement(author);
	}
	
	public List<Author> getAllAuthors() {
		return authorDAO.getAllElements();
	}

}
