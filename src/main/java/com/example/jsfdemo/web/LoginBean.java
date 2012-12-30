package com.example.jsfdemo.web;

import javax.enterprise.context.RequestScoped;

import javax.inject.Named;
@RequestScoped
@Named("LoginBean")
public class LoginBean{
	String user;
	String password;

	public LoginBean(){}

	public String getUser(){
		return user;
	}

	public void setUser(String loginname){
		this.user = loginname;
	}

	public String getPassword(){
		return password;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String CheckValidUser(){
        if(user.equals("chandan") && 
        		password.equals("chand")){
        	System.out.println("chandan");
			return "success";
		}
		else{
			return "fail";
		}
	}
}
