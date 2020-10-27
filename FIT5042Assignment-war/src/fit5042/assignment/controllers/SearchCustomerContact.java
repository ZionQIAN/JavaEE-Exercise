package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named("searchCustomerContact")
@RequestScoped
public class SearchCustomerContact {
private boolean showForm = true;
	
	private CustomerContact customerContact;
	
	AusApplication application;
	
	private int searchByInt;
	
	public boolean isShowForm() 
	{
		return showForm;
	}

	public CustomerContact getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(CustomerContact customerContact) {
		this.customerContact = customerContact;
	}
	
	
	public int getSearchByInt() {
		return searchByInt;
	}

	public void setSearchByInt(int searchByInt) {
		this.searchByInt = searchByInt;
	}

	public SearchCustomerContact() 
	{
		ELContext context
        = FacesContext.getCurrentInstance().getELContext();

		application = (AusApplication) FacesContext.getCurrentInstance()
        .getApplication()
        .getELResolver()
        .getValue(context, null, "ausApplication");

		application.updateCustomerContactList();

	}
	
	public void searchCustomerContactByInt(int customerContactId) 
	{
		try {
			application.searchCustomerContactById(customerContactId);
		} catch (Exception e) {
		
		}
	}
	
	public void searchAllCustomerContact() {
		try {
			application.searchAllCustomerContact();
		} catch (Exception e) {
			
		}
		
		showForm = true;
	}
}
