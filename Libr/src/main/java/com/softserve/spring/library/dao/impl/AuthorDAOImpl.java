package com.softserve.spring.library.dao.impl;



import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.spring.library.dao.interfaces.AuthorDAO;
import com.softserve.spring.library.entity.Author;

@Repository
@Transactional
public class AuthorDAOImpl extends GenericDAOImpl<Author, Integer> implements AuthorDAO  {

	public AuthorDAOImpl() {
		super(Author.class);
		
	}

	public AuthorDAOImpl(Class<Author> genericClass) {
		super(genericClass);
		// TODO Auto-generated constructor stub
	}

	
	}



