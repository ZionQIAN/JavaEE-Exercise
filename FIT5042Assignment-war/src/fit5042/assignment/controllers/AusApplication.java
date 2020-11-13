package fit5042.assignment.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.repositoty.entities.AppUser;
import fit5042.assignment.repositoty.entities.Customer;
import fit5042.assignment.repositoty.entities.CustomerContact;
import fit5042.assignment.mbeans.AppUserManagedBean;
import fit5042.assignment.mbeans.CustomerContactManagedBean;
import fit5042.assignment.mbeans.CustomerManagedBean;

@Named(value = "ausApplication")
@ApplicationScoped

public class AusApplication {
	
	@ManagedProperty(value = "#{customerManagedBean}")
	CustomerManagedBean customerManagedBean;
	
	@ManagedProperty(value = "#{customerContactManagedBean}")
	CustomerContactManagedBean customerContactManagedBean;
	
	@ManagedProperty(value = "#{appUserManagedBean}")
	AppUserManagedBean appUserManagedBean;
	
	private ArrayList<Customer> customers;
	
	private ArrayList<CustomerContact> customerContacts;
	
	private ArrayList<AppUser> appUsers;
	
	private AppUser appUser;
	
	private String userName;
	
	private String userType;
	
	
	///private ArrayList<CustomerContact> oneCustomerContacts;
	
	
	private boolean showForm = true;
	
	public boolean isShowForm() {
		return showForm;
	}
	

	@PostConstruct
	public void init() 
	{
		customers = new ArrayList<>();
		
		customerContacts = new ArrayList<>();
		
		appUsers = new ArrayList<>();
		
		appUser = new AppUser();
		
		ELContext context = FacesContext.getCurrentInstance().getELContext();
		
		customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(context, null, "customerManagedBean");
		
		customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(context, null, "customerContactManagedBean");
		
		appUserManagedBean = (AppUserManagedBean) FacesContext.getCurrentInstance().getApplication()
				.getELResolver().getValue(context, null, "appUserManagedBean");
		
		userName =  FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal().getName();
		
		updateAppUser();
		
		updateCustomerList();
		
		updateCustomerContactList() ;
		
		//updateOneCustomerContactList();
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


	public ArrayList<AppUser> getAppUsers() {
		return appUsers;
	}


	public void setAppUsers(ArrayList<AppUser> appUsers) {
		this.appUsers = appUsers;
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

	
	public AppUser getAppUser() {
		return appUser;
	}


	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}


	public void updateAppUser() 
	{
		if(appUsers != null && appUsers.size() > 0) 
		{
			
		}
		else 
		{
			appUsers.clear();
			
			List<AppUser> tempAppUsers = appUserManagedBean.getAllAppUser();
			
			for (AppUser appUser : appUserManagedBean.getAllAppUser()) 
			{
				appUsers.add(appUser);
			}
		}
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
			
			userType = checkUserType();
			
			customers = updateUserCustomers(userType, customers);
			
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
	
//	public void updateOneCustomerContactList() 
//	{
//		oneCustomerContacts.clear();
//		
//		
//		
//		
//	}
	
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
	
	public void searchAllAppUser() 
	{
		appUsers.clear();
		
		for (AppUser appUser: appUserManagedBean.getAllAppUser()) 
		{
			appUsers.add(appUser);
		}
		
		setAppUsers(appUsers);
	}
	
	public void searchAllCustomers() 
	{
		customers.clear();
		
		List<Customer> temArrayList = new ArrayList<Customer>();
		
		 
		do{
			try {
				temArrayList = customerManagedBean.getAllCustomer();
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		while(temArrayList.size() == 0);
		
		for (Customer customer : temArrayList) 
		{
			customers.add(customer);
		}
		
		if (appUser.getId() == 0) 
		{
			
			setCustomers(customers);
		}else 
		{
			customers = updateUserCustomers(userType, customers);
			
			setCustomers(customers);
		}
		
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
	
	public void searchCustomerByName(String customerName) 
	{
		customers.clear();
		
		for (Customer customer : customerManagedBean.searchCustomerByName(customerName)) 
		{
			customers.add(customer);
		}
		
	}
	
	public void searchCustomerContactById(int customerContactId) 
	{
		customerContacts.clear();
		
		customerContacts.add(customerContactManagedBean.searchCustomerContactById(customerContactId));
	}
	
	
	public String checkCustomerType(ArrayList<Customer> list) 
	{
		ArrayList<Customer> tempArrayList = new ArrayList<Customer>();
		try {
			for (Customer customertemp: list) 
			{
				if(customertemp.getAppUser() != null) 
				{
					AppUser tempAppUser = customertemp.getAppUser();
					
						if (tempAppUser.getUsername().equals(userName)) 
						{
							if (tempAppUser.getUserLevel().equals("A")) 
							{
								return "A";
							}
							else 
							{
								return "S";
							}
							
							
						}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "A";
	}
	
	public String checkUserType() 
	{
		for (AppUser appUser: appUsers) 
		{
			if (appUser.getUsername().equals(userName)) 
			{
				if (appUser.getUserLevel().equals("A")) 
				{
					return "A";
				}
				else 
				{
					this.appUser = appUser;
					return "S";
				}
			}
			
		}
		return "A";
	}
	
	public ArrayList<Customer> updateUserCustomers(String userType, ArrayList<Customer> list)
	{
		ArrayList<Customer> tempArrayList = new ArrayList<Customer>();
		
		if (userType.equals("A")) 
		{
			return list;
			
		}
		else 
		{
			try {
				for (Customer customertemp: list) 
				{
					if(customertemp.getAppUser() != null) 
					{
						AppUser tempAppUser = customertemp.getAppUser();
						
							if (tempAppUser.getUsername().equals(userName)) 
							{
								tempArrayList.add(customertemp);
							}
					}
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return tempArrayList;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}