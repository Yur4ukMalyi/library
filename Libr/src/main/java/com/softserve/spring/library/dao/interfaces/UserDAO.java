package com.softserve.spring.library.dao.interfaces;

import java.util.List;

import com.softserve.spring.library.entity.Book;
import com.softserve.spring.library.entity.User;

public interface UserDAO extends GenericDAO<User, Integer> {

	public Double getAvgReaderAge() ;
	public Long getTimeSinceRegistration(Integer userId);
	public double getAvgTimeSinceRegistration();
	public double avgRequestByPeriod(String startDate, String endDate);
	public double getAvgAgeByBook(Integer bookId);
	public double getAvgAgeByAuthor(String authorName);
	public double getAvgAgeByBookInstance(Integer bookInstanceId);

	public List<User> getDebtors();

	public List<Book> booksWasTaken(Integer userId);
	public List<Book> booksWasNotReturned(Integer userId);

}
