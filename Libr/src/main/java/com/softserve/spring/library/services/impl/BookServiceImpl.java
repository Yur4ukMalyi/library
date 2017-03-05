package com.softserve.spring.library.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softserve.spring.library.dao.interfaces.BookDAO;
import com.softserve.spring.library.entity.Book;
import com.softserve.spring.library.entity.BookInstance;
import com.softserve.spring.library.entity.BookPopularityDTO;
import com.softserve.spring.library.entity.ByBookNameStatisticDTO;
import com.softserve.spring.library.services.BookService;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookDAO bookDAO;
	
	/**
	 * 
	 * @param book
	 * @return <code>true</code> if there are available instances for this book, otherwise - <code>false</code>
	 */
	public boolean checkIfAvailableById(Integer bookId){
		boolean result= false;
		Long available = bookDAO.countAvailableInstances(bookId);
		if (available>0) {
			result = true;
		}
		return result;
	}
	
	public long getAvgReadingTimeById(Integer bookId) {
		Double avgReadingTime = bookDAO.getAvgReadingTime(bookId);
		if(avgReadingTime == null){
			avgReadingTime =new Double(0.0);
		}
		return Math.round(avgReadingTime);
	}
	
	public long getTimesBookTakenById(Integer bookId) {
		Long timesTaken = bookDAO.timesWasTaken(bookId);
		return timesTaken;
	}
	
	public boolean checkIfAvailable(Book book){
		boolean result= false;
		Long available = bookDAO.countAvailableInstances(book.getId());
		if (available>0) {
			result = true;
		}
		return result;
	}
	
	public long getAvgReadingTime(Book book) {
		Double avgReadingTime = bookDAO.getAvgReadingTime(book.getId());
		return Math.round(avgReadingTime);
	}
	
	public long getTimesBookTaken(Book book) {
		Long timesTaken = bookDAO.timesWasTaken(book.getId());
		return timesTaken;
	}

	 
	public List<Book> findBookByAuthor(int authorId){
		List<Book> findedBook= bookDAO.bookByAuthor(authorId);
		return findedBook;
	}
	
	public List<Book> bookByCoAuthor(int coAuthorId){
		List<Book> findedBook = bookDAO.bookByCoAuthor(coAuthorId);
		return findedBook;
	}
	
	public List<Book> booksIndependanceInstances() {
		List<Book> independentBook = bookDAO.booksPublishedInUkraine();
		return independentBook;
	}
	
	public long countInstances(String bookName){
		Long countInst=bookDAO.countInstances(bookName);
		return countInst;
	}
	
	public List<BookPopularityDTO> getNotPopular(String startDateString, String endDateString){
		List<BookPopularityDTO> notPopularList = bookDAO.getNotPopular(startDateString, endDateString);
		return notPopularList;
	}
	
	public List<BookPopularityDTO> getPopular(String startDateString, String endDateString){
		List<BookPopularityDTO> popularList = bookDAO.getPopular(startDateString, endDateString);
		return popularList;
	}
	
	public BookPopularityDTO getLeastPopular(String startDateString, String endDateString){
		BookPopularityDTO notPopular = bookDAO.getLeastPopular(startDateString, endDateString);
		return notPopular;
	}
	
	public BookPopularityDTO getMostPopular(String startDateString, String endDateString){
		BookPopularityDTO popular = bookDAO.getMostPopular(startDateString, endDateString);
		return popular;
	}
	
	public List<Book> getBookInfo(int bookId){
		List<Book> bookInfo =bookDAO.getBookInfo(bookId);
		return bookInfo;
	}
	
	public List<BookInstance> getBookInstances(int bookId){
		List<BookInstance> bookInfo =bookDAO.getinstances(bookId);
		return bookInfo;
	}
	
	
	public void addBook(Book book){
		bookDAO.addElement(book);
	}
	
	public void updateBook(Book book){
		bookDAO.updateElement(book);
	}
	
	public Book getBookById(Integer id){
		return bookDAO.getElementByID(id);
	}
	
	public void deleteBook(Book book){
		bookDAO.deleteElement(book);
	}
	
	public List<Book> getAllBooks() {
		return bookDAO.getAllElements();
	}

	@Override
	public List<ByBookNameStatisticDTO> getStatistic(String bookName) {
		return bookDAO.getStatistic(bookName);
	}
}
