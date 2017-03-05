package com.softserve.spring.library.entity;

public class ByBookNameStatisticDTO {
	
	private BookInstance bi;
	private	Boolean isAvailable;
	public BookInstance getBi() {
		return bi;
	}
	public void setBi(BookInstance bi) {
		this.bi = bi;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	public ByBookNameStatisticDTO(BookInstance bi, Boolean isAvailable) {
		super();
		this.bi = bi;
		this.isAvailable = isAvailable;
	}
	public ByBookNameStatisticDTO() {
		super();
	}
	
	

}
