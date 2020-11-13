package fit5042.assignment.controllers;

import java.io.Serializable;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.mbeans.CustomerManagedBean;

@Named("addCustomer")
@RequestScoped
public class AddCustomer implements Serializable{
	@ManagedProperty(value = "#{customerManagedBean}")
	CustomerManagedBean customerManagedBean;
	
	private boolean showForm = true;
	
	private Customer customer;
	
	AusApplication application;
	
	public boolean isShowForm() 
	{
		return showForm;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public AddCustomer() 
	{
		 ELContext context
         = FacesContext.getCurrentInstance().getELContext();

		 application = (AusApplication) FacesContext.getCurrentInstance()
				 .getApplication()
				 .getELResolver()
				 .getValue(context, null, "ausApplication");
 
		 ELContext elContext
         = FacesContext.getCurrentInstance().getELContext();
		 
		 customerManagedBean = (CustomerManagedBean)FacesContext.getCurrentInstance()
				 .getApplication()
				 .getELResolver()
				 .getValue(elContext, null, "customerManagedBean");
		 

	}
	
	public void addCustomer(Customer localCustomer) 
	{
		
		if (application.getAppUser().getId() != 0) 
		{
			
			try {
				customerManagedBean.addStaffCustomer(application.getAppUser(), localCustomer);
				
				application.searchAllCustomers();
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been added succesfully"));
			} catch (Exception e) {
				
			}
		}else 
		{
			try {
				customerManagedBean.addCustomer(localCustomer);
				
				application.searchAllCustomers();
				
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been added succesfully"));
			} catch (Exception e) {
				
			}
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
