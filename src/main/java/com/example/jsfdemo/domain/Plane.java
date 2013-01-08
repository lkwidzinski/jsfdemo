package com.example.jsfdemo.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;


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
	@Size(min=2,max=20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Size(min=2,max=20)
	public String getTailNumber() {
		return tailNumber;
	}
	public void setTailNumber(String tailNumber) {
		this.tailNumber = tailNumber;
	}
	@Min(1)
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	@Min(0)
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
	public String toString(){
		String s=String.format("%15s||%10s||%8s||%10s||%15s||%8s\n",name,tailNumber,capacity,passengers,destination,readyToGo);
		return s;
	}
}
