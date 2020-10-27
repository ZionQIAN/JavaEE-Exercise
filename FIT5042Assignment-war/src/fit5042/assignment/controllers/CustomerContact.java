package fit5042.assignment.controllers;

import java.io.Serializable;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import fit5042.assignment.repositoty.entities.Customer;


@RequestScoped
@Named(value = "customerContact")
public class CustomerContact implements Serializable{

	private int cutomerContactId;
	private String name;
	private String gender;
	private int age;
	private int workPhone;
	private String position; 
	private fit5042.assignment.repositoty.entities.Customer customer;
	
	private Set<fit5042.assignment.repositoty.entities.CustomerContact> customerContacts;

	public CustomerContact() 
	{
		
	}
	
	public CustomerContact(int cutomerContactId, String name, String gender, int age, int workPhone, String position) {
		
		this.cutomerContactId = cutomerContactId;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.workPhone = workPhone;
		this.position = position;
	}

	public int getCutomerContactId() {
		return cutomerContactId;
	}

	public void setCutomerContactId(int cutomerContactId) {
		this.cutomerContactId = cutomerContactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(int workPhone) {
		this.workPhone = workPhone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Set<fit5042.assignment.repositoty.entities.CustomerContact> getCustomerContacts() {
		return customerContacts;
	}

	public void setCustomerContacts(Set<fit5042.assignment.repositoty.entities.CustomerContact> customerContacts) {
		this.customerContacts = customerContacts;
	}

	public fit5042.assignment.repositoty.entities.Customer getCustomer() {
		return customer;
	}

	public void setCustomer(fit5042.assignment.repositoty.entities.Customer customer) {
		this.customer = customer;
	}

	
	
	
	
}
