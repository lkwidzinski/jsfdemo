package com.example.jsfdemo.domain;

import com.example.jsfdemo.service.PlaneManager;

public class ExamplePlaneMaker {
	
	public ExamplePlaneMaker() {
		PlaneManager mgr=new PlaneManager();
		mgr.addPlane(new Plane("Boeing 747","7C456W",200,0,"Rio de Janeiro",true));
		mgr.addPlane(new Plane("Boeing 747","7C457W",200,0,"Washington",true));
		mgr.addPlane(new Plane("Boeing 747","7C231A",200,0,"Rome",true));
		mgr.addPlane(new Plane("Boeing 747","7C7761",200,0,"Beijing",true));
		mgr.addPlane(new Plane("AirBus A380","98K56W",500,0,"Tokyo",true));
		mgr.addPlane(new Plane("AirBus A380","98K361",500,0,"London",true));
		mgr.addPlane(new Plane("AirBus A380","98K21W",500,0,"Beiping",true));
		mgr.addPlane(new Plane("Boeing 787","304DWW",400,0,"Shanghai",true));
		mgr.addPlane(new Plane("Boeing 787","304JEW",400,0,"Berlin",true));
		mgr.addPlane(new Plane("Boeing 787","304RE3",400,0,"Toronto",true));
		mgr.addPlane(new Plane("Boeing 787","304FFS",400,0,"Dublin",true));
		mgr.addPlane(new Plane("Embraer 195","99803W",300,0,"Vienna",true));
		mgr.addPlane(new Plane("Embraer 195","99820W",300,0,"Osaka",true));
		mgr.addPlane(new Plane("Embraer 195","99866W",300,0,"New York",true));
		mgr.addPlane(new Plane("Embraer 195","99807W",300,0,"Paris",true));
		mgr.addPlane(new Plane("Embraer 195","99821W",300,0,"Narita",true));
		mgr.addPlane(new Plane("Embraer 195","99811W",300,0,"BlackSite",true));
		
	}

}
