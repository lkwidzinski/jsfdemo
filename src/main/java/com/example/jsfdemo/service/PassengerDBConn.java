package com.example.jsfdemo.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.example.jsfdemo.domain.Person;
import com.example.jsfdemo.domain.Plane;

public class PassengerDBConn {
	
	private Connection connection;
	private Statement statement;
	private ResultSet rs;
	private String createTable3="CREATE TABLE Planes_has_Persons (plane_id bigint," +
			"person_id bigint,FOREIGN KEY(plane_id) references Planes(id), FOREIGN KEY(person_id) references Persons(id));";
	
	private String addPassengerSQL="UPDATE Planes SET passengers=passengers+1 WHERE tailnumber=?;";
	private String addPassengerSQL2="INSERT INTO Planes_has_Persons (plane_id,person_id) VALUES (?,?);";
	private String removePassengerSQL="UPDATE Planes SET passengers=passengers-1 WHERE tailnumber=?;";
	private String removePassengerSQL2="DELETE FROM Planes_has_Persons WHERE plane_id=? AND person_id=?;";
	private String removeAllPassengersSQL="UPDATE Planes SET passengers=0 WHERE tailnumber=?;";
	
	private String getAllPersonsSQL="SELECT * from Persons;";
	private String getAllSQL="SELECT * from Planes;";
	
	private String showPassengersSQL="SELECT m.* "+
			"FROM persons as m, planes_has_persons as php "+
			"WHERE m.id =php.person_id "+
			"AND php.plane_id=?;";
	
	PreparedStatement addPassenger;
	PreparedStatement removePassenger;
	PreparedStatement removeAllPassengers;
	
	PreparedStatement getAll;
	PreparedStatement getAllPersons;
	PreparedStatement showPassengers;
	
	public PassengerDBConn() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("jdbc/hsqldb");
			connection = ds.getConnection();
			statement = connection.createStatement();

			rs = connection.getMetaData().getTables(null, null, null,
			null);
			
			boolean tableExists=false;
			while (rs.next()) {
				if ("Planes_has_Persons".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
				tableExists = true;
				break;
				}
			}
			
			if(!tableExists)
			{
			statement.executeUpdate(createTable3);
			}
			getAll=connection.prepareStatement(getAllSQL);
			getAllPersons=connection.prepareStatement(getAllPersonsSQL);
			showPassengers=connection.prepareStatement(showPassengersSQL);

		} catch (SQLException e) {
		e.printStackTrace();
		}
		catch(NamingException n){
		n.printStackTrace();
		}
	}
	public boolean addPassenger(Plane obj,Person p) throws SQLException {
		connection.setAutoCommit(false);
		try {
		int plane_id = 99;
		int person_id = 99;
		ResultSet rs2=getAll.executeQuery();
		while(rs2.next())
		{
		if(rs2.getString("tailnumber").equalsIgnoreCase(obj.getTailNumber())){
			plane_id=rs2.getInt("id");
			break;}
		}
		rs2=getAllPersons.executeQuery();
		while(rs2.next())
		{
		if(rs2.getInt("pesel")==p.getPesel()){
			person_id=rs2.getInt("id");
			break;}
		}
		addPassenger=connection.prepareStatement(addPassengerSQL);	
		addPassenger.setString(1, obj.getTailNumber());
		addPassenger.execute();
		addPassenger=connection.prepareStatement(addPassengerSQL2);
		addPassenger.setInt(1, plane_id);
		addPassenger.setInt(2, person_id);
		addPassenger.execute();
		connection.commit();
		} catch (SQLException e) {
		e.printStackTrace();
		connection.rollback();
		System.out.println("Blad przypisania pasazera do samolotu");
		}
		connection.setAutoCommit(true);
		return false;
	}
	public boolean removePassenger(Plane obj,Person p) throws SQLException {
		connection.setAutoCommit(false);
		try {
		int plane_id = 99;
		int person_id = 99;
		ResultSet rs2=getAll.executeQuery();
		while(rs2.next())
		{
		if(rs2.getString("tailnumber").equalsIgnoreCase(obj.getTailNumber())){
			plane_id=rs2.getInt("id");
			break;}
		}
		rs2=getAllPersons.executeQuery();
		while(rs2.next())
		{
		if(rs2.getInt("pesel")==p.getPesel()){
			person_id=rs2.getInt("id");
			break;}
		}
		removePassenger=connection.prepareStatement(removePassengerSQL);	
		removePassenger.setString(1, obj.getTailNumber());
		removePassenger.execute();
		removePassenger=connection.prepareStatement(removePassengerSQL2);
		removePassenger.setInt(1, plane_id);
		removePassenger.setInt(2, person_id);
		removePassenger.execute();
		connection.commit();
		
		} catch (SQLException e) {
		e.printStackTrace();
		connection.rollback();
		System.out.println("Blad usuniecia pasazera z samolotu");
		}
		connection.setAutoCommit(true);
		return false;
	}
	public List<Person> showPassengers(Plane obj) throws SQLException{
		List <Person> persons=new ArrayList<Person>();
		ResultSet rs2=getAll.executeQuery();
		int plane_id=99;
		while(rs2.next())
		{
		if(rs2.getString("tailnumber").equalsIgnoreCase(obj.getTailNumber())){
			plane_id=rs2.getInt("id");
			break;}
		}
		showPassengers.setInt(1, plane_id);
		ResultSet rs=showPassengers.executeQuery();
		while(rs.next())
		{
		Person p = new Person(rs.getString("firstname"), rs.getString("lastname"),rs.getInt("pesel"),rs.getString("additionalinfo"));
		persons.add(p);
		}
		
		return persons;
	}

}
