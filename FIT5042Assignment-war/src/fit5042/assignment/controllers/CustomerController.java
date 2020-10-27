package fit5042.assignment.controllers;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.repositoty.entities.CustomerContact;

@Named(value = "customerController")
@RequestScoped
public class CustomerController {
		private int customerId;
		
		private fit5042.assignment.repositoty.entities.Customer customer;
		
		private ArrayList<CustomerContact> customerContacts = new ArrayList<CustomerContact>();
		
		public int getCustomerId() {
			return customerId;
		}


		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}

		public CustomerController() 
		{
			
		}
		
		@PostConstruct
		public void init() 
		{
			customerId = Integer.valueOf(FacesContext.getCurrentInstance()
					.getExternalContext()
					.getRequestParameterMap()
					.get("customerID"));
			
			customer = getCustomer();
			
			customerContacts = getCustomerContacts();
		}
		
		//public CustomerController() 
		//{
		//	customerId = Integer.valueOf(FacesContext.getCurrentInstance()
		//			.getExternalContext()
		//			.getRequestParameterMap()
		//			.get("customerID"));
		//	
		//	customer = getCustomer();
		//	
		//	customerContacts = getCustomerContacts();
		//	
		//}
		
		public fit5042.assignment.repositoty.entities.Customer getCustomer()
		{
			if(customer == null) 
			{
				ELContext context = FacesContext.getCurrentInstance().getELContext();
				
				AusApplication application = (AusApplication) FacesContext.getCurrentInstance()
						.getApplication()
						.getELResolver()
						.getValue(context, null, "ausApplication");
				
				application.searchAllCustomers();
				application.searchAllCustomerContact();
				
				return application.getCustomers().get(customerId);
			}
			
			return customer;
		}
		
		public ArrayList<fit5042.assignment.repositoty.entities.CustomerContact> getCustomerContacts()
		{
			
				customerContacts.clear();
				
				for (CustomerContact customerContact : customer.getCustomerContacts()) 
				{
					customerContacts.add(customerContact);
				}
			
			
			return customerContacts;
		}
}
