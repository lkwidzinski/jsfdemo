package com.example.jsfdemo.web;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;


import javax.inject.Inject;
import javax.inject.Named;


import com.example.jsfdemo.domain.Person;
import com.example.jsfdemo.domain.Plane;
import com.example.jsfdemo.service.PersonManager;
import com.example.jsfdemo.service.PlaneManager;
@RequestScoped
@Named("passengerMgrBean")
public class PassengerMgrBean implements Serializable {

	private static final long serialVersionUID = 5L;
	
	private String plane="";
	
	private List<Person> persons = new ArrayList<Person>();
	
	private List<String>  selectedPersons;
	
	private Map<Integer,Integer> personsMap=new HashMap<Integer, Integer>();  
		
	private List<Plane> planes = new ArrayList<Plane>();
	
	private List<String>  selectedPlanes;
	
	private Map<String,String> planesMap=new HashMap<String, String>();  
	
	@Inject
	private PlaneManager planeMgr;
	
	@Inject
	private PersonManager personMgr;
	@PostConstruct
	public void init(){
		persons=personMgr.getAll();
		for(Person p:persons)
		personsMap.put(p.getPesel(), p.getPesel());
		planes=planeMgr.getAll();
		for(Plane p:planes)
		planesMap.put(p.getTailNumber(), p.getTailNumber());
	}
	//------------
	
	public void setPersonsMap(Map<Integer, Integer> personsMap) {
		this.personsMap = personsMap;
	}

	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public List<String> getSelectedPersons() {
		return selectedPersons;
	}

	public void setSelectedPersons(List<String> selectedPersons) {
		this.selectedPersons = selectedPersons;
	}

	public Map<Integer, Integer> getPersonsMap() {
		return personsMap;
	}

	public List<Plane> getPlanes() {
		return planes;
	}

	public void setPlanes(List<Plane> planes) {
		this.planes = planes;
	}

	public List<String> getSelectedPlanes() {
		return selectedPlanes;
	}

	public void setSelectedPlanes(List<String> selectedPlanes) {
		this.selectedPlanes = selectedPlanes;
	}

	public Map<String, String> getPlanesMap() {
		return planesMap;
	}

	public void setPlanesMap(Map<String, String> planesMap) {
		this.planesMap = planesMap;
	}
	public String getPlane() {
		return plane;
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}

	//-------------------------------------
	
		public String addPassenger() throws SQLException{
			for(String s:selectedPersons){
				int i=Integer.parseInt(s);
				planeMgr.addPassenger(new Plane("",plane,0,0,"",false),new Person("","",i,""));
			}
			return "statusPlane";
		}
		public String removePassenger() throws SQLException{
			for(String s:selectedPersons){
				int i=Integer.parseInt(s);
				planeMgr.removePassenger(new Plane("",plane,0,0,"",false),new Person("","",i,""));
			}
			return "statusPlane";
		}
		
	
}
