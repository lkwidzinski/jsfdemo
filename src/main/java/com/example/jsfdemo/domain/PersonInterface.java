package com.example.jsfdemo.domain;

import java.util.List;

public interface PersonInterface {
	
	boolean addPerson(Person obj);
	boolean removePerson(Person obj);
	List<Person> getAll();

}
