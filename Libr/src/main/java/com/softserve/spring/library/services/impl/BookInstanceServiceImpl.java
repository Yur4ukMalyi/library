package com.softserve.spring.library.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.spring.library.services.BookInstanceService;
import com.softserve.spring.library.dao.interfaces.BookInstanceDAO;
import com.softserve.spring.library.entity.BookInstance;

@Service
public class BookInstanceServiceImpl implements BookInstanceService {
	
	@Autowired
	BookInstanceDAO bookInstanceDAO;

	public long getAvgReadingTimeById(Integer bookInstanceId) {
		Double avgReadingTime = bookInstanceDAO.getAvgReadingTime(bookInstanceId);
		if (avgReadingTime==null) {
			avgReadingTime = 0.0;
		}
		return Math.round(avgReadingTime);
	}
	
	public long getTimesTakenById(Integer bookInstanceId) {
		Long timesTaken = bookInstanceDAO.timesWasTaken(bookInstanceId);
		return timesTaken;
	}
	
	public long getAvgReadingTimeByInstance(BookInstance bookInstance) {
		Double avgReadingTime = bookInstanceDAO.getAvgReadingTime(bookInstance.getId());
		return Math.round(avgReadingTime);
	}
	
	public long getTimesTakenByInstance(BookInstance bookInstance) {
		Long timesTaken = bookInstanceDAO.timesWasTaken(bookInstance.getId());
		return timesTaken;
	}
	
	public void addBookInstance(BookInstance bookInstance){
		bookInstanceDAO.addElement(bookInstance);
	}
	
	public void updateBookInstance(BookInstance bookInstance){
		bookInstanceDAO.updateElement(bookInstance);
	}
	
	public BookInstance getBookInstanceById(Integer id){
		return bookInstanceDAO.getElementByID(id);
	}
	
	public void deleteBookInstance(BookInstance bookInstance){
		bookInstanceDAO.deleteElement(bookInstance);
	}
	
	public List<BookInstance> getAllBookInstances() {
		return bookInstanceDAO.getAllElements();
	}

	@Override
	public boolean isAvailable(Integer boInstanceId) {
		
		return bookInstanceDAO.isAvailable(boInstanceId);
	}
}
