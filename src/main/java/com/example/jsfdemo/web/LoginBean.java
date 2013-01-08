package com.example.jsfdemo.web;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import com.example.jsfdemo.domain.Login;
@RequestScoped
@Named("loginBean")
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Login login=new Login();

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public String CheckValidUser(){
        if(login.getUser().equals("test") && 
        		login.getPassword().equals("test")){
			return "success";
		}
		else{
			return "fail";
		}
	}
}
