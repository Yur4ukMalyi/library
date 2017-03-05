package com.softserve.spring.library.services;

import java.util.List;

import com.softserve.spring.library.entity.Author;

public interface AuthorService {

	public void addAuthor(Author author);
	public void updateAuthor(Author author);
	public Author getAuthorById(Integer id);
	public void deleteAuthor(Author author);
	public List<Author> getAllAuthors();
}
