package com.softserve.spring.library.services;

import java.util.List;

import com.softserve.spring.library.entity.Book;
import com.softserve.spring.library.entity.BookInstance;
import com.softserve.spring.library.entity.BookPopularityDTO;
import com.softserve.spring.library.entity.ByBookNameStatisticDTO;

public interface BookService {

	public boolean checkIfAvailableById(Integer bookId);
	
	public long getAvgReadingTimeById(Integer bookId);
	
	public long getTimesBookTakenById(Integer bookId);
	
	public boolean checkIfAvailable(Book book);
	
	public long getAvgReadingTime(Book book);
	
	public long getTimesBookTaken(Book book);

	public List<BookInstance> getBookInstances(int bookId);
	 
	public List<Book> findBookByAuthor(int authorId);
	
	public List<Book> bookByCoAuthor(int coAuthorId);
	
	public List<Book> booksIndependanceInstances();
	
	public long countInstances(String bookName);
	
	public List<ByBookNameStatisticDTO> getStatistic(String bookName);
	
	public List<BookPopularityDTO> getNotPopular(String startDateString, String endDateString);
	
	public List<BookPopularityDTO> getPopular(String startDateString, String endDateString);
	public BookPopularityDTO getLeastPopular(String startDateString, String endDateString);
	public BookPopularityDTO getMostPopular(String startDateString, String endDateString);
	
	public List<Book> getBookInfo(int BookId);
	
	public void addBook(Book book);
	
	public void updateBook(Book book);
	
	public Book getBookById(Integer id);
	
	public void deleteBook(Book book);
	
	public List<Book> getAllBooks();
}
