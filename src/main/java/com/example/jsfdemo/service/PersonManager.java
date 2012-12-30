package com.example.jsfdemo.service;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.example.jsfdemo.domain.Person;
import com.example.jsfdemo.domain.PersonInterface;
@ApplicationScoped
public class PersonManager implements PersonInterface{
	
	private DBmanager db=DBmanager.getInstance();

	@Override
	public boolean addPerson(Person obj) {
		
		return db.addPerson(obj);
	}

	@Override
	public boolean removePerson(Person obj) {
		
		return db.removePerson(obj);
	}

	@Override
	public List<Person> getAll() {
	
		return db.getAllPersons();
	}

}
