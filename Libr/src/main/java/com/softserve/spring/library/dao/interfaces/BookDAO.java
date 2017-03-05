package com.softserve.spring.library.dao.interfaces;

import java.util.List;

import com.softserve.spring.library.entity.Book;
import com.softserve.spring.library.entity.BookInstance;
import com.softserve.spring.library.entity.BookPopularityDTO;
import com.softserve.spring.library.entity.ByBookNameStatisticDTO;

public interface BookDAO extends GenericDAO<Book, Integer> {

	
	public List<ByBookNameStatisticDTO> getStatistic(String bookName);
	public long countAvailableInstances(Integer bookId);
	
	public long countAll(Integer bookId);
	
	public long timesWasTaken(Integer bookId);
	
	public Double getAvgReadingTime(Integer bookId);
	
	public List<Book> bookByAuthor(int i);
	
	public List<Book> bookByCoAuthor(int i);
	
	public List<Book> booksPublishedInUkraine();
	
	public List<BookPopularityDTO> getPopular(String startDate, String endDate);
	
	public List<BookPopularityDTO> getNotPopular(String startDateString, String endDateString);
	
public BookPopularityDTO getMostPopular(String startDate, String endDate);
	
	public BookPopularityDTO getLeastPopular(String startDateString, String endDateString);
	
	public List<Book> getBookInfo(int BookId);
	
	public long countInstances(String bookName);
	public List<BookInstance> getinstances(int BookId);
}
