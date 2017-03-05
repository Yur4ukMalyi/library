package com.softserve.spring.library.entity;

public class UserStatisticDTO {

	private Double avgAge;
	private Double avgTimeSinceRegistration;
	private Double avgRequestByPeriod;

	public UserStatisticDTO() {
		super();
	}

	public UserStatisticDTO(Double avgAge, Double avgTimeSinceRegistration, Double avgRequestByPeriod) {
		super();
		this.avgAge = avgAge;
		this.avgTimeSinceRegistration = avgTimeSinceRegistration;
		this.avgRequestByPeriod = avgRequestByPeriod;
	}

	public Double getAvgAge() {
		return avgAge;
	}

	public void setAvgAge(Double avgAge) {
		this.avgAge = avgAge;
	}

	public Double getAvgTimeSinceRegistration() {
		return avgTimeSinceRegistration;
	}

	public void setAvgTimeSinceRegistration(Double avgTimeSinceRegistration) {
		this.avgTimeSinceRegistration = avgTimeSinceRegistration;
	}

	public Double getAvgRequestByPeriod() {
		return avgRequestByPeriod;
	}

	public void setAvgRequestByPeriod(Double avgRequestByPeriod) {
		this.avgRequestByPeriod = avgRequestByPeriod;
	}
	

	
}
