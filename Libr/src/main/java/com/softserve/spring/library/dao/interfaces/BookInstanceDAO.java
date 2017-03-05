package com.softserve.spring.library.dao.interfaces;

import com.softserve.spring.library.entity.BookInstance;

public interface BookInstanceDAO extends GenericDAO<BookInstance, Integer> {

	public long timesWasTaken(Integer bookInstanceId);
	public Double getAvgReadingTime(Integer bookInstanceId);
	public boolean isAvailable(Integer bookInstanceId);
}
