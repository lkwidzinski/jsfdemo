package com.example.jsfdemo.service;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Person;
import com.example.jsfdemo.domain.Plane;
import com.example.jsfdemo.domain.PlaneInterface;

@ApplicationScoped
public class PlaneManager implements PlaneInterface{

	private PlaneDBConn db=new PlaneDBConn();
	private PassengerDBConn db2=new PassengerDBConn();
	
	public boolean addPlane(Plane obj) {
		return db.addPlane(obj);
	}

	public boolean removePlane(Plane obj) {
		return db.removePlane(obj);
	}

	public List<Plane> getAll() {
		
		return db.getAll();
	}

	public boolean addPassenger(Plane obj,Person p) throws SQLException {
		return db2.addPassenger(obj,p);
	}

	public boolean removePassenger(Plane obj,Person p) throws SQLException {
		return db2.removePassenger(obj,p);
	}
	
	public List<Person> showPassengers(Plane obj) throws SQLException{
		return db2.showPassengers(obj);
	}
}
