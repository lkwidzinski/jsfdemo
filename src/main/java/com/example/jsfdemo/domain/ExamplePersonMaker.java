package com.example.jsfdemo.domain;

import com.example.jsfdemo.service.PersonManager;

public class ExamplePersonMaker {

	public ExamplePersonMaker() {
		PersonManager mgr=new PersonManager();
		mgr.addPerson(new Person("Francis","Broomhead",12056613,"VIP"));
		mgr.addPerson(new Person("Zenon","Trawa",99086683,"VIP"));
		mgr.addPerson(new Person("Travis","Gates",44050913,"VIP"));
		mgr.addPerson(new Person("John","Smith",10000003,"Golden Membership"));
		mgr.addPerson(new Person("Roger","Pasta",14456413,"VIP"));
		mgr.addPerson(new Person("Alojzy","Zomb",12056613,"Normal"));
		mgr.addPerson(new Person("Janek","Kwiatkowski",67056213,"Golden Membership"));
		mgr.addPerson(new Person("Pierre","Johnson",77096613,"VIP"));
		mgr.addPerson(new Person("Emily","Wilson",43956511,"VIP"));
		mgr.addPerson(new Person("Sonnya","Walowsky",52056313,"Normal"));
		mgr.addPerson(new Person("Greg","House",92115113,"Normal"));
		mgr.addPerson(new Person("Charles","Xavier",69969613,"VIP"));
		mgr.addPerson(new Person("Julie","Stenton",78876813,"Golden Membership"));
		mgr.addPerson(new Person("Jerry","Zulu",12566618,"Normal"));
		mgr.addPerson(new Person("Piotr","Catacomb",41056617,"VIP"));
		mgr.addPerson(new Person("Caroline","Zielinsky",87656619,"VIP"));
	}
}
