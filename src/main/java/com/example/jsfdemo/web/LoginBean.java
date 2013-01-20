package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.example.jsfdemo.domain.Login;
@RequestScoped
@Named("loginBean")
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Date date1;
	
	private Login login=new Login();

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String checkValidUser(){
        if(login.getUser().equals("test") && 
        		login.getPassword().equals("test")){
			return "success";
		}
		else{
			return "fail";
		}
	}

	public Date getDate1() {
		return date1;
	}

	public void setDate1(Date date1) {
		this.date1 = date1;
	}
}
