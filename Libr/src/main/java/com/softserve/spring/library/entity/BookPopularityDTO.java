package com.softserve.spring.library.entity;

public class BookPopularityDTO {
	
	private Book book;
	private Long timesPicked;
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Long getTimesPicked() {
		return timesPicked;
	}
	public void setTimesPicked(Long timesPicked) {
		this.timesPicked = timesPicked;
	}
	public BookPopularityDTO(Book book, Long timesPicked) {
		super();
		this.book = book;
		this.timesPicked = timesPicked;
	}
	public BookPopularityDTO() {
		super();
	}
	
	

}
