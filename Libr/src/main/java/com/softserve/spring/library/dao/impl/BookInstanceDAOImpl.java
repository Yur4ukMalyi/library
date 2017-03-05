package com.softserve.spring.library.dao.impl;

import org.hibernate.query.Query;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.spring.library.entity.BookInstance;
import com.softserve.spring.library.dao.interfaces.BookInstanceDAO;

@Repository
@Transactional
public class BookInstanceDAOImpl extends GenericDAOImpl<BookInstance, Integer> implements BookInstanceDAO {

	public BookInstanceDAOImpl() {
		super(BookInstance.class);
	}

	public BookInstanceDAOImpl(Class<BookInstance> genericClass) {
		super(genericClass);
	}
	
	@Override
	public Double getAvgReadingTime(Integer bookInstanceID) {
		Session session = null;
		String queryString = "select (AVG(UNIX_TIMESTAMP(readsession.returnDate)-"
				+ "UNIX_TIMESTAMP(readsession.getDate)))/86400 "
				+ "from ReadSession readsession " 
				+ "inner join readsession.bookInstance " 
				+ "where readsession.bookInstance.id =:bookInstanceid "
				+ "and readsession.returnDate is not null";
		Double res;
		
			session = sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			Query<Double> query = session.createQuery(queryString);
			query.setParameter("bookInstanceid", bookInstanceID);
			res = (Double) query.getSingleResult();

	
		return res;
	}
	


	@SuppressWarnings("unchecked")
	public long timesWasTaken(Integer bookInstanceId) {
		Session session = null;

		String queryString = "select count(*) from ReadSession readsession " 
				+ "inner join readsession.bookInstance " 
				+ "where readsession.bookInstance.id =:bookinstanceid";
		long res;
	
			session = sessionFactory.getCurrentSession();
			Query<Long> query = session.createQuery(queryString);
			query.setParameter("bookinstanceid", bookInstanceId);
			res = (Long) query.getSingleResult();

		
		return res;
	}
	
	public boolean isAvailable(Integer bookInstanceId) {
		Session session = null;

		String queryString = "select count(*) from ReadSession rs " 
				+ "inner join rs.bookInstance " 
				+ "where rs.bookInstance.id =:bookinstanceid and rs.returnDate is null";
		boolean available;
	
			session = sessionFactory.getCurrentSession();
			@SuppressWarnings("unchecked")
			Query<Long> query = session.createQuery(queryString);
			query.setParameter("bookinstanceid", bookInstanceId);
			available = !((Long) query.getSingleResult() > 0);

		
		return available;
	}
	
	

}
