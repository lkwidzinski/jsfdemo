package com.example.jsfdemo.domain;

import javax.validation.constraints.Size;

public class Person {
	
	String firstName="";
	String lastName="";
	int pesel;
	String additionalInfo="";
	
	public Person(String firstName,String lastName, int pesel, String additionalInfo){
		
		this.firstName=firstName;
		this.lastName=lastName;
		this.pesel=pesel;
		this.additionalInfo=additionalInfo;
		
	}
	public Person() {
		// TODO Auto-generated constructor stub
	}
	@Size(min=3,max=20)
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	@Size(min=3,max=20)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Size(min=11)
	public int getPesel() {
		return pesel;
	}

	public void setPesel(int pesel) {
		this.pesel = pesel;
	}

	public String getAdditionalInfo() {
		return additionalInfo;
	}

	public void setAdditionalInfo(String additionalInfo) {
		this.additionalInfo = additionalInfo;
	}

	public String toString(){
		
		String s=String.format("%20s||%20s||%20s||%40s\n",firstName,lastName,pesel,additionalInfo);
		
		return s;
	}
	
}
