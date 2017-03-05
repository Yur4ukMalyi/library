package com.softserve.spring.library.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.query.Query;
import javax.persistence.TemporalType;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.spring.library.entity.Book;
import com.softserve.spring.library.entity.User;
import com.softserve.spring.library.dao.interfaces.UserDAO;

@Repository
@Transactional
public class UserDAOImpl extends GenericDAOImpl<User, Integer> implements UserDAO {

	public UserDAOImpl() {
		super(User.class);
	}

	public UserDAOImpl(Class<User> genericClass) {
		super(genericClass);

	}

	@SuppressWarnings("unchecked")
	public double avgRequestByPeriod(String startDate, String endDate) {
		double res = 0;
		Session session = null;
		String queryString = "select count(*)*1.0/count(distinct rs.user.name) "
				+ "from ReadSession rs inner join rs.user " + "where rs.getDate between :stDate and :edDate";

		try {

			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date stDate = formatter.parse(startDate);
			Date enDate = formatter.parse(endDate);
			session = sessionFactory.getCurrentSession();
			Query<Double> query = session.createQuery(queryString);
			query.setParameter("stDate", stDate, TemporalType.DATE);
			query.setParameter("edDate", enDate, TemporalType.DATE);
			res = query.getSingleResult();
		} catch (ParseException | NullPointerException e) {
			System.out.println("Wrong Input");
			e.printStackTrace();
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public double getAvgTimeSinceRegistration() {
		Session session = null;
		String queryString = "select (AVG(UNIX_TIMESTAMP()-" + "UNIX_TIMESTAMP(user.registrationDate)))/86400 "
				+ "from User user";
		Double res;

		session = sessionFactory.getCurrentSession();
		Query<Double> query = session.createQuery(queryString);
		res = query.getSingleResult();

		return res;
	}

	@SuppressWarnings("unchecked")
	public Long getTimeSinceRegistration(Integer userId) {
		Session session = null;
		String queryString = "select (UNIX_TIMESTAMP()-" + "UNIX_TIMESTAMP(user.registrationDate))/86400 "
				+ "from User user " + "where user.id=:userId";
		Long res;
		session = sessionFactory.getCurrentSession();
		Query<Long> query = session.createQuery(queryString);
		query.setParameter("userId", userId);
		res = query.getSingleResult();

		return res;
	}

	@SuppressWarnings("unchecked")
	public Double getAvgReaderAge() {
		Session session = null;
		String queryString = "select (AVG(UNIX_TIMESTAMP()-" + "UNIX_TIMESTAMP(user.birthDate)))/31557600 "
				+ "from User user";
		Double res;

		session = sessionFactory.getCurrentSession();
		Query<Double> query = session.createQuery(queryString);
		res = query.getSingleResult();

		return res;

	}

	@Override
	public double getAvgAgeByBook(Integer bookId) {
		Session session = null;
		String queryString = "select (AVG(UNIX_TIMESTAMP()-" + "UNIX_TIMESTAMP(user.birthDate)))/31557600 "
				+ "from User user " + "where user.id in " + "(select distinct rs.user.id from "
				+ "ReadSession rs inner join rs.user inner join rs.bookInstance inner join rs.bookInstance.book "
				+ "where rs.bookInstance.book.id = :bookId)";
		Double res;

		session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<Double> query = session.createQuery(queryString);
		query.setParameter("bookId", bookId);
		res = query.getSingleResult();
		if (res == null) {
			res = new Double(0.0);
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	public double getAvgAgeByBookInstance(Integer bookInstanceId) {
		Session session = null;
		String queryString = "select (AVG(UNIX_TIMESTAMP()-" + "UNIX_TIMESTAMP(user.birthDate)))/31557600 "
				+ "from User user " + "where user.id in " + "(select distinct rs.user.id from "
				+ "ReadSession rs inner join rs.user inner join rs.bookInstance " + "where rs.bookInstance.id = :BIId)";
		Double res;

		session = sessionFactory.getCurrentSession();
		Query<Double> query = session.createQuery(queryString);
		query.setParameter("BIId", bookInstanceId);
		res = query.getSingleResult();

		return res;
	}

	@SuppressWarnings("unchecked")
	public List<Book> booksWasTaken(Integer userId) {
		Session session = null;
		String queryString = "select rs.bookInstance.book from ReadSession rs " + "inner join rs.bookInstance "
				+ "inner join rs.bookInstance.book " + "inner join rs.user " + "where rs.user.id =:idUser";
		List<Book> res;

		session = sessionFactory.getCurrentSession();
		Query<Book> query = session.createQuery(queryString);
		query.setParameter("idUser", userId);
		res = query.getResultList();

		return res;
	}

	@SuppressWarnings("unchecked")
	public List<Book> booksWasNotReturned(Integer userId) {
		Session session = null;
		String queryString = "select rs.bookInstance.book from ReadSession rs " + "inner join rs.bookInstance "
				+ "inner join rs.bookInstance.book " + "inner join rs.user "
				+ "where rs.user.id =:idUser and rs.returnDate is null";
		List<Book> res;

		session = sessionFactory.getCurrentSession();
		Query<Book> query = session.createQuery(queryString);
		query.setParameter("idUser", userId);
		res = query.getResultList();

		return res;
	}

	// 7
	@SuppressWarnings("unchecked")
	public List<User> getDebtors() {
		Session session = null;
		String queryString = "select distinct rs.user from ReadSession rs " + "inner join rs.user "
				+ "where rs.returnDate is null ";
		List<User> res;

		session = sessionFactory.getCurrentSession();
		Query<User> bla = session.createQuery(queryString);
		res = bla.getResultList();

		return res;
	}
	
	@Override
	public double getAvgAgeByAuthor(String authorName) {
		Session session = null;
		String queryString = "select (AVG(UNIX_TIMESTAMP()-" + "UNIX_TIMESTAMP(user.birthDate)))/31557600 "
				+ "from User user " + "where user.id in " + "(select distinct rs.user.id from "
				+ "ReadSession rs inner join rs.user inner join rs.bookInstance inner join rs.bookInstance.book "
				+ "inner join rs.bookInstance.book.author as au "
				+ "where au.name = :authorName)";
		Double res;

		session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		Query<Double> query = session.createQuery(queryString);
		query.setParameter("authorName", authorName);
		res = query.getSingleResult();
		if (res == null) {
			res = new Double(0.0);
		}
		return res;
	}
}
