package com.softserve.spring.library.services;

import java.util.List;

import com.softserve.spring.library.entity.BookInstance;

public interface BookInstanceService {

	public long getAvgReadingTimeById(Integer bookInstanceId);
	
	public long getTimesTakenById(Integer bookInstanceId);
	
	public boolean isAvailable(Integer boInstanceId);
	
	public long getAvgReadingTimeByInstance(BookInstance bookInstance);
	
	public long getTimesTakenByInstance(BookInstance bookInstance);
	
	public void addBookInstance(BookInstance bookInstance);
	
	public void updateBookInstance(BookInstance bookInstance);
	
	public BookInstance getBookInstanceById(Integer id);
	
	public void deleteBookInstance(BookInstance bookInstance);
	
	public List<BookInstance> getAllBookInstances();
}
