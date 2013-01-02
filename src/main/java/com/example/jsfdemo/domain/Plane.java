package com.example.jsfdemo.domain;

import java.util.List;

import javax.validation.constraints.Size;


public class Plane{
	
	private String name;
	private String tailNumber;
	private int capacity;
	private int passengers;
	private String destination;
	private boolean readyToGo;
	
	public Plane(String name, String tailNumber, int capacity,int passengers, String destination, boolean readyToGo){
		this.name=name;
		this.tailNumber=tailNumber;
		this.capacity=capacity;
		this.passengers=passengers;
		this.destination=destination;
		this.readyToGo=readyToGo;
		
	}
	public Plane() {
		// TODO Auto-generated constructor stub
	}
	//get
	@Size(min=1)
	public String getName() {
		return name;
	}
	@Size(min=1)
	public String getTailNumber() {
		return tailNumber;
	}
	@Size(min=1)
	public int getCapacity() {
		return capacity;
	}
	@Size(min=0)
	public int getPassengers() {
		return passengers;
	}

	public String getDestination() {
		return destination;
	}

	public boolean isReadyToGo() {
		return readyToGo;
	}

	public String toString(){
	
		String s=String.format("%15s||%10s||%8s||%10s||%15s||%8s\n",name,tailNumber,capacity,passengers,destination,readyToGo);
		
		return s;
	}


}
