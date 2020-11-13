package fit5042.assignment.controllers;

import java.io.Serializable;
import java.sql.Date;
import java.util.Set;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import fit5042.assignment.repositoty.entities.Industry;

@RequestScoped
@Named(value = "customer")
public class Customer implements Serializable{

	// Industry
	private String industryName;
	
	// Customer
	private int customerId;
	private String CEO;
	private int numberOfemployees;
	private String customerName;
	private String website;
	private int officePhone;
	private String address; 
	private String appUserId;
	
	private Set<fit5042.assignment.repositoty.entities.Customer> customers;
	
	
	public Customer() {}


	


	public Customer(String industryName, int customerId, String cEO, int numberOfemployees, String customerName,
			String website, int officePhone, String address, String appUserId
			) {
		super();
		this.industryName = industryName;
		this.customerId = customerId;
		CEO = cEO;
		this.numberOfemployees = numberOfemployees;
		this.customerName = customerName;
		this.website = website;
		this.officePhone = officePhone;
		this.address = address;
		this.appUserId = appUserId;
		
	}





	public String getIndustryName() {
		return industryName;
	}


	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public String getCEO() {
		return CEO;
	}


	public void setCEO(String cEO) {
		CEO = cEO;
	}


	public int getNumberOfemployees() {
		return numberOfemployees;
	}


	public void setNumberOfemployees(int numberOfemployees) {
		this.numberOfemployees = numberOfemployees;
	}


	


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}


	public String getWebsite() {
		return website;
	}
	
	


	public void setWebsite(String website) {
		this.website = website;
	}


	public int getOfficePhone() {
		return officePhone;
	}


	public void setOfficePhone(int officePhone) {
		this.officePhone = officePhone;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Set<fit5042.assignment.repositoty.entities.Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(Set<fit5042.assignment.repositoty.entities.Customer> customers) {
		this.customers = customers;
	}

	

	public String getAppUserId() {
		return appUserId;
	}


	public void setAppUserId(String appUserId) {
		this.appUserId = appUserId;
	}





	@Override
	public String toString() {
		return "Customer [industryName=" + industryName + ", customerId=" + customerId + ", CEO=" + CEO
				+ ", numberOfemployees=" + numberOfemployees + ", customerName=" + customerName + ", website=" + website
				+ ", officePhone=" + officePhone + ", address=" + address + ", appUserId=" + appUserId + "]";
	}





	

	
	
	
}
