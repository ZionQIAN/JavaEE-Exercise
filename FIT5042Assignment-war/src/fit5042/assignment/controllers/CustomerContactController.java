package fit5042.assignment.controllers;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import fit5042.assignment.repositoty.entities.CustomerContact;;

@Named(value = "customerContactController")
@RequestScoped
public class CustomerContactController {
	
	private int customerContactId;
	
	private int customerId;
	
	private CustomerContact customerContact;
	
	public CustomerContactController() 
	{
		
	}
	
	@PostConstruct
	public void init() 
	{
		
		customerContact = new CustomerContact();
		
		customerId = Integer.valueOf(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("customerID"));
		
		String temp = FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("customerContactID");
				
		//int tempContactId = Integer.valueOf(FacesContext.getCurrentInstance()
		//		.getExternalContext()
		//		.getRequestParameterMap()
		//		.get("customerContactID"));
		
		if(temp != null) 
		{
			customerContactId = Integer.valueOf(temp);
			
			customerContact = getCustomerContact();
		}else {
			customerContactId = 0;
		}
		
	}
	
	//private CustomerContactController() 
	//{
	//	
	//	customerContactId = Integer.valueOf(FacesContext.getCurrentInstance()
	//			.getExternalContext()
	//			.getRequestParameterMap()
	//			.get("customerContactID"));
	//	
	//	customerId = Integer.valueOf(FacesContext.getCurrentInstance()
	//			.getExternalContext()
	//			.getRequestParameterMap()
	//			.get("customerID"));
	//	
	//}

	public int getCustomerContactId() {
		return customerContactId;
	}

	public void setCustomerContactId(int customerContactId) {
		this.customerContactId = customerContactId;
	}
	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public CustomerContact getCustomerContact() 
	{
		//if(customerContact == null)
		//{
			ELContext context = FacesContext.getCurrentInstance().getELContext();
			
			AusApplication application = (AusApplication)FacesContext.getCurrentInstance()
					.getApplication()
					.getELResolver()
					.getValue(context, null, "ausApplication");
			
			application.searchAllCustomers();
			application.searchAllCustomerContact();
			
			return application.getCustomerContactById(customerContactId);
			
		//}
		
	}
}