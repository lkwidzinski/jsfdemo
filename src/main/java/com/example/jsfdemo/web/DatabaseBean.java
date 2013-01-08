package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;


import javax.inject.Inject;
import javax.inject.Named;


import com.example.jsfdemo.domain.Plane;
import com.example.jsfdemo.service.PlaneManager;
@RequestScoped
@Named("databaseBean")
public class DatabaseBean implements Serializable {

	private static final long serialVersionUID = 2L;

	private Plane plane=new Plane();
	
	private List<Plane> planes = new ArrayList<Plane>();
	
	@Inject
	private PlaneManager planeMgr;
	@PostConstruct
	public void init(){
		planes=planeMgr.getAll();
	}
	
	public List<Plane> getPlanes() {
		return planes;
	}

	public void setPlanes(List<Plane> planes) {
		this.planes = planes;
	}

	public Plane getPlane() {
		return plane;
	}

	public void setPlane(Plane plane) {
		this.plane = plane;
	}


	
	//------------
	
	public String addPlane(){
		planeMgr.addPlane(plane);
		return "statusPlane";
		
	}
	

	
}
