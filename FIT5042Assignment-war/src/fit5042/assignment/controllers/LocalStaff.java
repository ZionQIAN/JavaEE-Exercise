package fit5042.assignment.controllers;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named(value = "localStaff")
public class LocalStaff implements Serializable{
	private String userName;
	private String password;
	private Date dob;
	private String userLevel;
	
	public LocalStaff() 
	{
		
	}
	
	

	public LocalStaff(String userName, String password, Date dob, String userLevel) {
		super();
		this.userName = userName;
		this.password = password;
		this.dob = dob;
		this.userLevel = userLevel;
	}



	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	@Override
	public String toString() {
		return "LocalStaff [userName=" + userName + ", password=" + password + ", dob=" + dob + ", userLevel="
				+ userLevel + "]";
	}
	
	
}
