package com.softserve.spring.library.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.spring.library.dao.interfaces.UserDAO;
import com.softserve.spring.library.entity.Book;
import com.softserve.spring.library.entity.BookInstance;
import com.softserve.spring.library.entity.User;
import com.softserve.spring.library.entity.UserStatisticDTO;
import com.softserve.spring.library.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO userDAO;
	
	public double getAvgAgeByBook(Integer id){
		Double result = userDAO.getAvgAgeByBook(id);
		return result;
	}
	
	public double getAvgAgeByBook(Book book){
		Double result = userDAO.getAvgAgeByBook(book.getId());
		return result;
	}
	
	public double getAvgAgeByBookInstance(Integer id){
		Double result = userDAO.getAvgAgeByBookInstance(id);
		return result;
	}
	
	public double getAvgAgeByBookInstance(BookInstance bI){
		Double result = userDAO.getAvgAgeByBook(bI.getId());
		return result;
	}
	
	public double avgRequestByPeriod(String startDate, String endDate){
		Double result = userDAO.avgRequestByPeriod(startDate, endDate);
		return result;
	}
	
	public Long getAvgTimeSinceRegistration() {
		Double result = userDAO.getAvgTimeSinceRegistration();
		Long roundedResult = Math.round(result);
		return roundedResult;
	}
	
	public Long getTimeSinceRegistration(Integer userId) {
		Long result = userDAO.getTimeSinceRegistration(userId);
		return result;
	}
	
	public Long getAvgAge() {
		Double result = userDAO.getAvgReaderAge();
		Long roundedResult = Math.round(result);
		return roundedResult;
	}
	public List<Book> booksWasTaken(Integer userId){
		List<Book> takenBooks = userDAO.booksWasTaken(userId);
		return takenBooks;
	}
	public List<Book> booksWasNotReturned(Integer userId){
		List<Book> notReturnedBook = userDAO.booksWasNotReturned(userId);
		return notReturnedBook;
	}
	
	public UserStatisticDTO getStatistic(String startDate, String endDate) {
		 Double avgAge = userDAO.getAvgReaderAge();
		 Double avgTimeSinceRegistration = userDAO.getAvgTimeSinceRegistration();
		 Double avgPeriodRequest = userDAO.avgRequestByPeriod(startDate, endDate);
		 UserStatisticDTO result = new UserStatisticDTO(avgAge, avgTimeSinceRegistration, avgPeriodRequest); 
		return result;
		
	}
	
	public void addUser(User user){
		userDAO.addElement(user);
	}
	
	public void updateUser(User user){
		userDAO.updateElement(user);
	}
	
	public User getUserById(Integer id){
		return userDAO.getElementByID(id);
	}
	
	public void deleteUser(User user){
		userDAO.deleteElement(user);
	}
	
	public List<User> getAllUsers() {
		return userDAO.getAllElements();
	}

	@Override
	public double getAvgAgeByAuthor(String authorName) {
		return userDAO.getAvgAgeByAuthor(authorName);
	}

	@Override
	public List<User> getDebtors() {
		List<User> list = userDAO.getDebtors();
		return list;
	}

}


