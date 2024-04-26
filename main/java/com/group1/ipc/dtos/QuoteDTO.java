package com.group1.ipc.dtos;

public class QuoteDTO {

	private float sex;
	private String insuranceBegin;
	private String insuranceEnd;
	private float insuredValue;
	private float prodYear;
	private float numSeats;
	private String type;
	private String make;
	private String usage;
	
	public float getSex() {
		return sex;
	}
	
	public void setSex(float sex) {
		this.sex = sex;
	}
	
	public String getInsuranceBegin() {
		return insuranceBegin;
	}
	
	public void setInsuranceBegin(String insuranceBegin) {
		this.insuranceBegin = insuranceBegin;
	}
	
	public String getInsuranceEnd() {
		return insuranceEnd;
	}
	
	public void setInsuranceEnd(String insuranceEnd) {
		this.insuranceEnd = insuranceEnd;
	}
	
	public float getInsuredValue() {
		return insuredValue;
	}
	
	public void setInsuredValue(float insuredValue) {
		this.insuredValue = insuredValue;
	}
	
	public float getProdYear() {
		return prodYear;
	}

	public void setProdYear(float prodYear) {
		this.prodYear = prodYear;
	}

	public float getNumSeats() {
		return numSeats;
	}

	public void setNumSeats(float numSeats) {
		this.numSeats = numSeats;
	}

	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getMake() {
		return make;
	}
	
	public void setMake(String make) {
		this.make = make;
	}
	
	public String getUsage() {
		return usage;
	}
	
	public void setUsage(String usage) {
		this.usage = usage;
	}
	
}
