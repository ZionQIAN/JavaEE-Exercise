package fit5042.assignment.controllers;

import java.io.Serializable;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.mbeans.CustomerContactManagedBean;



@Named("addCustomerContact")
@RequestScoped
public class AddCustomerContact implements Serializable{

	@ManagedProperty(value = "#{customerContactManagedBean}")
	CustomerContactManagedBean customerContactManagedBean;
	
	private boolean showForm = true;
	
	AusApplication ausApplication;
	
	private int customerId;
	
	private fit5042.assignment.repositoty.entities.Customer addCustomer;
	
	public boolean isShowForm() 
	{
		return showForm;
	}
	
	public AddCustomerContact() 
	{
		customerId = Integer.valueOf(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("customerID"));
				
		ELContext context
        = FacesContext.getCurrentInstance().getELContext();

		 ausApplication = (AusApplication) FacesContext.getCurrentInstance()
				 .getApplication()
				 .getELResolver()
				 .getValue(context, null, "ausApplication");

		 ELContext elContext
        = FacesContext.getCurrentInstance().getELContext();
		 
		 customerContactManagedBean = (CustomerContactManagedBean)FacesContext.getCurrentInstance()
				 .getApplication()
				 .getELResolver()
				 .getValue(elContext, null, "customerContactManagedBean");
		 
		 
		 
		 addCustomer = ausApplication.getCustomerById(customerId);
	}
	
	public void addCustomerContact(CustomerContact customerContact) 
	{
		customerContact.setCustomer(addCustomer);
		
		try {
			customerContactManagedBean.addCustomerContact(customerContact);
			
			ausApplication.searchAllCustomerContact();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("CustomerContact has been added succesfully"));
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
}
