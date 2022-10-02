package com.system.bean;

import java.io.File;
import java.sql.Date;
import java.time.LocalDate;

public class Crime {
	
	private int count;
	private String crime;
	private String date;
	private String place;
	private String victims;
	private String description;
	private String suspected;
	private String solved;
	
	public String getCrime() {
		return crime;
	}
	public void setCrime(String crime) {
		this.crime = crime;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getVictims() {
		return victims;
	}
	public void setVictims(String victims) {
		this.victims = victims;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSuspected() {
		return suspected;
	}
	public void setSuspected(String suspected) {
		this.suspected = suspected;
	}
	
	public Crime() {
		
	}
	public Crime(int count,String crime, String date, String place, String victims, String description, String suspected,String solved) {
		super();
		this.count= count;
		this.crime = crime;
		this.date = date;
		this.place = place;
		this.victims = victims;
		this.description = description;
		this.suspected = suspected;
		this.solved= solved;
	}
	
	@Override
	public String toString() {
		return "\nCrime No.: " + count + "\nCrime name: " + crime + "\nCrime date: " + date + "\nCrime place: " + place + ",\nCrime victims: " + victims
				+ "\nCrime description: " + description + "\nSuspected: " + suspected + "\nCase Status: " + solved;
	}
	public String getSolved() {
		return solved;
	}
	public void setSolved(String solved) {
		this.solved = solved;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
	

}
