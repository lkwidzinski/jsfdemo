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


import com.example.jsfdemo.domain.ExamplePersonMaker;
import com.example.jsfdemo.domain.Person;
import com.example.jsfdemo.domain.Plane;
import com.example.jsfdemo.service.PersonManager;
import com.example.jsfdemo.service.PlaneManager;
@RequestScoped
@Named("personMgrBean")
public class PersonMgrBean implements Serializable {

	private static final long serialVersionUID = 3L;

	private Person person=new Person();
	
	private List<Person> persons = new ArrayList<Person>();
	

	private List<String>  selectedPersons;
	
	private Map<Integer,Integer> personsMap=new HashMap<Integer, Integer>();  
	
	@Inject
	private PersonManager personMgr;
	@PostConstruct
	public void init(){
		persons=personMgr.getAll();
		for(Person p:persons)
		personsMap.put(p.getPesel(), p.getPesel());
	}
	//------------
	
	public void setPersonsMap(Map<Integer, Integer> personsMap) {
		this.personsMap = personsMap;
	}

	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public List<Person> getPersons() {
		return persons;
	}
	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	public PersonManager getPersonMgr() {
		return personMgr;
	}
	public void setPersonMgr(PersonManager personMgr) {
		this.personMgr = personMgr;
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
//-------------------------------------
	public String addPerson(){
		personMgr.addPerson(person);
		return "statusPerson";
		
	}
	public String removePerson(){
		for(String s:selectedPersons){
			int i=Integer.parseInt(s);
			personMgr.removePerson(new Person("","",i,""));
		}
		return "statusPerson";
	}
	public void personMaker(){
		ExamplePersonMaker nk= new ExamplePersonMaker();
	}
	
}
