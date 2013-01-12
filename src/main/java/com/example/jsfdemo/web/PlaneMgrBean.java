package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;


import javax.inject.Inject;
import javax.inject.Named;


import com.example.jsfdemo.domain.Plane;
import com.example.jsfdemo.service.PlaneManager;
@RequestScoped
@Named("planeMgrBean")
public class PlaneMgrBean implements Serializable {

	private static final long serialVersionUID = 2L;

	private Plane plane=new Plane();
	
	private List<Plane> planes = new ArrayList<Plane>();
	
	private List<String>  selectedPlanes;
	
	private Map<String,String> planesMap=new HashMap<String, String>();  
	
	public Map<String, String> getPlanesMap() {
		return planesMap;
	}

	public List<String> getSelectedPlanes() {
		return selectedPlanes;
	}

	public void setSelectedPlanes(List<String> selectedPlanes) {
		this.selectedPlanes = selectedPlanes;
	}



	@Inject
	private PlaneManager planeMgr;
	@PostConstruct
	public void init(){
		planes=planeMgr.getAll();
		for(Plane p:planes)
		planesMap.put(p.getTailNumber(), p.getTailNumber());
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
	
	public String removePlane(){
		for(String s:selectedPlanes){
			planeMgr.removePlane(new Plane("",s,0,0,"",false));
		}
		
		return "statusPlane";
	}
	

	
}
