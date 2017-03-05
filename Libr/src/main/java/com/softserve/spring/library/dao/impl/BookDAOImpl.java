package com.softserve.spring.library.dao.impl;

import java.text.DateFormat;
import java.text.ParseException;import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.TemporalType;

import org.hibernate.query.Query;
import org.hibernate.Session;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.softserve.spring.library.dao.interfaces.BookDAO;
import com.softserve.spring.library.entity.Book;
import com.softserve.spring.library.entity.BookInstance;
import com.softserve.spring.library.entity.BookPopularityDTO;
import com.softserve.spring.library.entity.ByBookNameStatisticDTO;

@Repository
@Transactional
public class BookDAOImpl extends GenericDAOImpl<Book, Integer>implements BookDAO {

	
	
	public BookDAOImpl() {
		super(Book.class);
	}

	public BookDAOImpl(Class<Book> genericClass) {
		super(genericClass);

	}

	/**
	 * @param bookId
	 *            book id of object needed to check
	 * @return quantity of available instances
	 */
	@SuppressWarnings("unchecked")
	public long countAvailableInstances(Integer bookId) {
		Session session = null;
		String queryString = "select count(*) from BookInstance bookinstance "
				+ "where bookinstance.book.id =:bookid and not exists "
				+ "(from ReadSession readsession where readsession.returnDate is null"
				+ " and readsession.bookInstance.id = bookinstance.id)";

		long res;
		
			session = sessionFactory.getCurrentSession();
			Query<Long> query = session.createQuery(queryString);
			query.setParameter("bookid", bookId);
			res = (Long) query.getSingleResult();

		return res;

	}

	/**
	 * @param book
	 *            book id of object needed to check
	 * @return quantity of all instances of this book
	 */
	public long countAll(Integer bookId) {
		Session session = null;
		String queryString = "select count(*) from BookInstance bookinstance " + "where bookinstance.book.id =:bookid";
		long res;
		
		session = sessionFactory.getCurrentSession();
			Query<?> query = session.createQuery(queryString);
			query.setParameter("bookid", bookId);
			res = (Long) query.getSingleResult();

		
		return res;

	}

	/**
	 * @param book
	 *            book id of object needed to check
	 * @return number of times book was taken
	 */
	public long timesWasTaken(Integer bookId) {
		Session session = null;

		String queryString = "select count(*) from ReadSession readsession " + "inner join readsession.bookInstance "
				+ "inner join readsession.bookInstance.book " + "where readsession.bookInstance.book.id =:bookid";
		long res;
		
		session = sessionFactory.getCurrentSession();
			Query<?> query = session.createQuery(queryString);
			query.setParameter("bookid", bookId);
			res = (Long) query.getSingleResult();

		return res;
	}

	@SuppressWarnings("unchecked")
	public Double getAvgReadingTime(Integer bookId) {
		Session session = null;
		String queryString = "select (AVG(UNIX_TIMESTAMP(readsession.returnDate))-"
				+ "AVG(UNIX_TIMESTAMP(readsession.getDate)))/86400" + " from ReadSession readsession "
				+ "inner join readsession.bookInstance " + "inner join readsession.bookInstance.book "
				+ "where readsession.bookInstance.book.id =:bookid " + "and readsession.returnDate is not null";
		Double res;
	
			session = sessionFactory.getCurrentSession();
			Query<Double> query = session.createQuery(queryString);
			query.setParameter("bookid", bookId);
			res = (Double) query.getSingleResult();
		return res;
	}

	@SuppressWarnings("unchecked")
	public List<Book> bookByAuthor(int authorId) {
		Session session = null;

		String queryString = "select book from Book book  " + "inner join book.author  "
				+ "where book.author.id =:authorid";
		List<Book> res;
		
		session = sessionFactory.getCurrentSession();
		Query<Book> query = session.createQuery(queryString);
			query.setParameter("authorid", authorId);
			res = (List<Book>) query.getResultList();

		
		return res;
	}

	@SuppressWarnings("unchecked")
	public List<Book> bookByCoAuthor(int coAuthorId) {
		Session session = null;

		String queryString = "select distinct book from Book book  " + "inner join book.subauthors sa "
				+ "where sa.id =:coauthorid";
		List<Book> res;
		
		session = sessionFactory.getCurrentSession();
			Query<Book> query = session.createQuery(queryString);
			query.setParameter("coauthorid", coAuthorId);
			res =  query.getResultList();

		
		return res;
	}

	@SuppressWarnings("unchecked")
	public List<Book> booksPublishedInUkraine() {
		
		String date="1991-08-24";
		
		Session session = null;

		String queryString = "from Book book  " + "where book.publishDate > :date ";

		List<Book> res = null;

		try {

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date Date = formatter.parse(date);

			session = sessionFactory.getCurrentSession();
			Query<Book> query = session.createQuery(queryString);
			query.setParameter("date", Date, TemporalType.DATE);
			res =  query.getResultList();

		} catch (ParseException e) {

			System.out.println("Wrong Input");
		} 
		return res;
	}

	// 6
	@SuppressWarnings("unchecked")
	public List<BookPopularityDTO> getPopular(String startDateString, String endDateString) {
		
		List<Object[]> tempRes = null;
		List<BookPopularityDTO> res = null;
		Session session = null;
		String queryString = "select rs.bookInstance.book, "
				+ "count(rs.bookInstance.id) as times from ReadSession rs inner join rs.bookInstance"
				+ " inner join rs.bookInstance.book " + "where rs.getDate between :stDate and :edDate"
				+ " group by rs.bookInstance.id " + "order by times";
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = formatter.parse(startDateString);
			Date endDate = formatter.parse(endDateString);
			session = sessionFactory.getCurrentSession();
			Query<Object[]> query = session.createQuery(queryString);
			query.setParameter("stDate", startDate, TemporalType.DATE);
			query.setParameter("edDate", endDate, TemporalType.DATE);

			tempRes = query.getResultList();
			if (tempRes != null) {
				for (Object[] obj : tempRes) {
					res.add(new BookPopularityDTO((Book) obj[0], (Long) obj[1]));
				}
			}

		} catch (ParseException | NullPointerException e) {

			System.out.println("Wrong Input");
			e.printStackTrace();
		} 
		return res;
	}

	@SuppressWarnings("unchecked")
	public List<BookPopularityDTO> getNotPopular(String startDateString, String endDateString) {
	
		List<Object[]> tempRes = null;
		List<BookPopularityDTO> res = null;
		Session session = null;
		String queryString = "select rs.bookInstance.book, "
				+ "count(rs.bookInstance.book.id) as times from ReadSession rs inner join rs.bookInstance"
				+ " inner join rs.bookInstance.book " + "where rs.getDate between :stDate and :edDate"
				+ " group by rs.bookInstance.book.id " + "order by times desc";
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = formatter.parse(startDateString);
			Date endDate = formatter.parse(endDateString);
			session = sessionFactory.getCurrentSession();
			Query<Object[]> query = session.createQuery(queryString);
			query.setParameter("stDate", startDate, TemporalType.DATE);
			query.setParameter("edDate", endDate, TemporalType.DATE);
			tempRes = query.getResultList();
			
			if (tempRes != null) {
				for (Object[] obj : tempRes) {
					res.add(new BookPopularityDTO((Book) obj[0], (Long) obj[1]));
				}
			}

		} catch (ParseException | NullPointerException e) {
			System.out.println("Wrong Input");
			e.printStackTrace();
		} 
		return res;

	}

	public long countInstances(String bookName) {
		Session session = null;

		String queryString = "select count(*) BookInstance bi inner join bi.book " + "where bi.book.name =:bookname";
		Long available;
			session = sessionFactory.getCurrentSession();
			Query<?> query = session.createQuery(queryString);
			query.setParameter("bookname", bookName);
			available = (Long) query.getSingleResult();

		return available;
	}

	@SuppressWarnings("unchecked")
	public List<Book> getBookInfo(int BookId) {

		Session session = null;
		List<Book> res;
		String queryString = "select rs.bookInstance.book from ReadSession rs inner join rs.bookInstance "
				+ "inner join rs.bookInstance.book " + "where rs.bookInstance.book.id= :idbook";

		
		session = sessionFactory.getCurrentSession();
			Query<Book> query = session.createQuery(queryString);
			query.setParameter("idbook", BookId);
			res =  query.getResultList();
		 
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<BookInstance> getinstances(int BookId) {

		Session session = null;
		List<BookInstance> res;
		String queryString = "select bi from BookInstance bi "
				+ "inner join bi.book " + "where bi.book.id= :idbook";

		
		session = sessionFactory.getCurrentSession();
			Query<BookInstance> query = session.createQuery(queryString);
			query.setParameter("idbook", BookId);
			res =  query.getResultList();
		
		return res;
	}
	
	@SuppressWarnings("unchecked")
	public List<ByBookNameStatisticDTO> getStatistic(String bookName) {
		Session session = null;
		String queryString = "select rs.bookInstance, (case when (count( case when rs.returnDate is null then 1 else null end) > 0) then false else true end) AS isavailable"
				+ " from ReadSession rs "
				+ "where rs.bookInstance.book.name =:bookName "
				+ "group by rs.bookInstance.id";

		List<Object[]> tempRes;
		List<ByBookNameStatisticDTO> res = new ArrayList<>();
		
			session = sessionFactory.getCurrentSession();
			Query<Object[]> query = session.createQuery(queryString);
			query.setParameter("bookName", bookName);
			tempRes = (List<Object[]>) query.getResultList();
			if (tempRes != null) {
				for (Object[] obj : tempRes) {
					res.add(new ByBookNameStatisticDTO( (BookInstance) obj[0], (Boolean)obj[1]));
				}
			}
			
		return res;

	}

	@SuppressWarnings("unchecked")
	@Override
	public BookPopularityDTO getMostPopular(String startDateString, String endDateString) {
		List<Object[]> res = null;
		Session session = null;
		BookPopularityDTO mostPopular = null;
		String queryString = "select rs.bookInstance.book, "
				+ "count(rs.bookInstance.book.id) as times from ReadSession rs inner join rs.bookInstance"
				+ " inner join rs.bookInstance.book " + "where rs.getDate between :stDate and :edDate"
				+ " group by rs.bookInstance.book.id " + "order by times";
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = formatter.parse(startDateString);
			Date endDate = formatter.parse(endDateString);
			session = sessionFactory.getCurrentSession();
			Query<Object[]> query = session.createQuery(queryString);
			query.setParameter("stDate", startDate, TemporalType.DATE);
			query.setParameter("edDate", endDate, TemporalType.DATE);

			res = query.getResultList();
			Object[] neededObject = res.get(res.size()-1);
			mostPopular = new BookPopularityDTO((Book) neededObject[0], (Long)neededObject[1]);
			

		} catch (ParseException | NullPointerException | IndexOutOfBoundsException e) {

			System.out.println("Wrong Input");
			e.printStackTrace();
		} 
		return mostPopular;
	}

	@SuppressWarnings("unchecked")
	@Override
	public BookPopularityDTO getLeastPopular(String startDateString, String endDateString) {
		List<Object[]> res = null;
		Session session = null;
		BookPopularityDTO leastPopular = null;
		String queryString = "select rs.bookInstance.book, "
				+ "count(rs.bookInstance.book.id) as times from ReadSession rs inner join rs.bookInstance"
				+ " inner join rs.bookInstance.book " + "where rs.getDate between :stDate and :edDate"
				+ " group by rs.bookInstance.book.id " + "order by times";
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date startDate = formatter.parse(startDateString);
			Date endDate = formatter.parse(endDateString);
			session = sessionFactory.getCurrentSession();
			Query<Object[]> query = session.createQuery(queryString);
			query.setParameter("stDate", startDate, TemporalType.DATE);
			query.setParameter("edDate", endDate, TemporalType.DATE);

			res = query.getResultList();
			Object[] neededObject = res.get(0);
			leastPopular = new BookPopularityDTO((Book) neededObject[0], (Long)neededObject[1]);
			

		} catch (ParseException | NullPointerException | IndexOutOfBoundsException e) {

			System.out.println("Wrong Input");
			e.printStackTrace();
		} 
		return leastPopular;
	}

}
