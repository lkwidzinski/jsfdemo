package com.example.jsfdemo.domain;


public class Plane{
	
	private String name="";
	private String tailNumber="";
	private int capacity=0;
	private int passengers=0;
	private String destination="";
	private boolean readyToGo=false;
	
	public Plane(String name, String tailNumber, int capacity,int passengers, String destination, boolean readyToGo){
		this.name=name;
		this.tailNumber=tailNumber;
		this.capacity=capacity;
		this.passengers=passengers;
		this.destination=destination;
		this.readyToGo=readyToGo;
		
	}
	public Plane() {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTailNumber() {
		return tailNumber;
	}
	public void setTailNumber(String tailNumber) {
		this.tailNumber = tailNumber;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getPassengers() {
		return passengers;
	}
	public void setPassengers(int passengers) {
		this.passengers = passengers;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public boolean isReadyToGo() {
		return readyToGo;
	}
	public void setReadyToGo(boolean readyToGo) {
		this.readyToGo = readyToGo;
	}
	
}
