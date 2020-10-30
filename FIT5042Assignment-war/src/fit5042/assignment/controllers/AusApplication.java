package fit5042.assignment.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.repositoty.entities.Customer;
import fit5042.assignment.repositoty.entities.CustomerContact;
import fit5042.assignment.mbeans.CustomerContactManagedBean;
import fit5042.assignment.mbeans.CustomerManagedBean;

@Named(value = "ausApplication")
@ApplicationScoped

public class AusApplication {
	
	@ManagedProperty(value = "#{customerManagedBean}")
	CustomerManagedBean customerManagedBean;
	
	@ManagedProperty(value = "#{customerContactManagedBean}")
	CustomerContactManagedBean customerContactManagedBean;
	
	private ArrayList<Customer> customers;
	
	private ArrayList<CustomerContact> customerContacts;
	
	
	private boolean showForm = true;
	
	public boolean isShowForm() {
		return showForm;
	}
	

	@PostConstruct
	public void init() 
	{
		customers = new ArrayList<>();
		
		customerContacts = new ArrayList<>();
		
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		
		customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(context, null, "customerManagedBean");
		
		customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(context, null, "customerContactManagedBean");
		
		updateCustomerList();
		
		updateCustomerContactList() ;
	}
	
	public AusApplication() 
	{}
	//public AusApplication() throws Exception
	//{
	//	customers = new ArrayList<>();
		
	//	customerContacts = new ArrayList<>();
		
	//	ELContext context = FacesContext.getCurrentInstance().getELContext();
		
	//	customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
	//			.getELResolver().getValue(context, null, "customerManagedBean");
	//	
	//	customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
	//			.getELResolver().getValue(context, null, "customerContactManagedBean");
	//	
	//	updateCustomerList();
	//	
	//	updateCustomerContactList() ;
	//
	//}


	public ArrayList<Customer> getCustomers() {
		return customers;
	}


	public void setCustomers(ArrayList<Customer> customers) {
		this.customers = customers;
	}
	
	
	public ArrayList<CustomerContact> getCustomerContacts() {
		return customerContacts;
	}


	public void setCustomerContacts(ArrayList<CustomerContact> customerContacts) {
		this.customerContacts = customerContacts;
	}


	public void updateCustomerList() 
	{
		if(customers != null && customers.size() > 0) 
		{
			
		}
		else 
		{
			customers.clear();
			
			List<Customer> tempArrayList = customerManagedBean.getAllCustomer();
			
			for (Customer customer : customerManagedBean.getAllCustomer()) 
			{
				customers.add(customer);
			}
			
			setCustomers(customers);
		}
	}
	
	public void updateCustomerContactList() 
	{
		if(customerContacts != null && customerContacts.size() > 0) 
		{
			
		}
		else 
		{
			customerContacts.clear();
			
			for (CustomerContact customerContact : customerContactManagedBean.getAllCustomerContact()) 
			{
				customerContacts.add(customerContact);
			}
		}
	}
	
	public Customer getCustomerById(int customerId) 
	{
		Customer tempCustomer  = customers.get(customerId);
		
		//for (Customer tempCustomer2 : customers) 
		//{
		//	if (tempCustomer2.getCustomerId() == customerId) 
		//	{
		//		tempCustomer = tempCustomer2;
		//	}
		//}
		
		return tempCustomer;
	}
	
	public CustomerContact getCustomerContactById(int customerContactId) 
	{
		CustomerContact tempCustomerContact = new CustomerContact();
		
		for (CustomerContact tempContact : customerContacts) 
		{
			if (tempContact.getCustomerContactId() == customerContactId) 
			{
				tempCustomerContact = tempContact;
			}
		}
		
		return tempCustomerContact;
	}
	
	public void searchAllCustomers() 
	{
		customers.clear();
		
		for (Customer customer : customerManagedBean.getAllCustomer()) 
		{
			customers.add(customer);
		}
		
		setCustomers(customers);
	}
	
	public void searchAllCustomerContact() 
	{
		customerContacts.clear();
		
		for (CustomerContact customerContact : customerContactManagedBean.getAllCustomerContact()) 
		{
			customerContacts.add(customerContact);
		}
	}
	
	public void searchCustomerById(int customerId) 
	{
		customers.clear();
		
		customers.add(customerManagedBean.searchCustomerById(customerId));
	}
	
	public void searchCustomerContactById(int customerContactId) 
	{
		customerContacts.clear();
		
		customerContacts.add(customerContactManagedBean.searchCustomerContactById(customerContactId));
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}