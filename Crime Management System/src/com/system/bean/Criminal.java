package com.system.bean;

public class Criminal {
	
	private String criminalName;
	private int age;
	private String gender;
	private String address;
	private String markOnFace;
	private String firstAreaArrested;
	private String criminalCrime;
	
	
	public Criminal() {
		
	}
	
	public Criminal(String criminalName, int age, String gender, String address, String markOnFace,
			String firstAreaArrested, String criminalCrime) {
		super();
		this.criminalName = criminalName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.markOnFace = markOnFace;
		this.firstAreaArrested = firstAreaArrested;
		this.criminalCrime = criminalCrime;
	}

	public String getCriminalName() {
		return criminalName;
	}

	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMarkOnFace() {
		return markOnFace;
	}

	public void setMarkOnFace(String markOnFace) {
		this.markOnFace = markOnFace;
	}

	public String getFirstAreaArrested() {
		return firstAreaArrested;
	}

	public void setFirstAreaArrested(String firstAreaArrested) {
		this.firstAreaArrested = firstAreaArrested;
	}

	public String getCriminalCrime() {
		return criminalCrime;
	}

	public void setCriminalCrime(String criminalCrime) {
		this.criminalCrime = criminalCrime;
	}

	@Override
	public String toString() {
		return "\nCriminal Name: "+ criminalName + "\nAge: " + age + "\nGender: " + gender + "\nAddress: " + address
				+ "\nMark on face: " + markOnFace + "\nArrested place: " + firstAreaArrested + "\nCrime: "
				+ criminalCrime;
	}
	
	
	
	
	
	

}
