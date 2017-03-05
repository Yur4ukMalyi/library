package com.softserve.spring.library.services;

import java.util.List;

import com.softserve.spring.library.entity.Book;
import com.softserve.spring.library.entity.BookInstance;
import com.softserve.spring.library.entity.User;
import com.softserve.spring.library.entity.UserStatisticDTO;

public interface UserService {

	public double getAvgAgeByBook(Integer id);
	
	public double getAvgAgeByBook(Book book);
	
	public double getAvgAgeByBookInstance(Integer id);
	
	public double getAvgAgeByBookInstance(BookInstance bI);
	
	public double avgRequestByPeriod(String startDate, String endDate);
	
	public Long getAvgTimeSinceRegistration();
	
	public Long getTimeSinceRegistration(Integer userId);
	
	public Long getAvgAge();
	
	public List<Book> booksWasTaken(Integer userId);
	
	public List<Book> booksWasNotReturned(Integer userId);
	
	public List<User> getDebtors();
	
	public UserStatisticDTO getStatistic(String startDate, String endDate);
	
	public double getAvgAgeByAuthor(String authorName);
	
	public void addUser(User user);
	
	public void updateUser(User user);
	
	public User getUserById(Integer id);
	
	public void deleteUser(User user);
	
	public List<User> getAllUsers();
}
