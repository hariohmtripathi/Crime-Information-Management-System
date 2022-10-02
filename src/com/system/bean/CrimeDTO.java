package com.system.bean;

public class CrimeDTO {
	
	
	private String place;
	private String crimeName;
	private String criminalName;
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getCrimeName() {
		return crimeName;
	}
	public void setCrimeName(String crimeName) {
		this.crimeName = crimeName;
	}
	public String getCriminalName() {
		return criminalName;
	}
	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}
	
	public CrimeDTO() {
		
	}
	public CrimeDTO(String place, String crimeName, String criminalName) {
		super();
		this.place = place;
		this.crimeName = crimeName;
		this.criminalName = criminalName;
	}
	@Override
	public String toString() {
		return "\nCrime place: " + place + "\nCrime Name: " + crimeName + "\nCriminal Name: " + criminalName ;
	}
	
	
	
	
	
	

}
