package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named("searchCustomer")
@RequestScoped
public class SearchCustomer {

private boolean showForm = true;
	
	private Customer customer;
	
	AusApplication application;
	
	private int searchByInt;
	
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

	public AusApplication getApplication() {
		return application;
	}

	public void setApplication(AusApplication application) {
		this.application = application;
	}

	public int getSearchByInt() {
		return searchByInt;
	}

	public void setSearchByInt(int searchByInt) {
		this.searchByInt = searchByInt;
	}
	
	public SearchCustomer() 
	{
		ELContext context
        = FacesContext.getCurrentInstance().getELContext();

		application = (AusApplication) FacesContext.getCurrentInstance()
        .getApplication()
        .getELResolver()
        .getValue(context, null, "ausApplication");

		application.updateCustomerList();

	}
	
	public void searchCustomerByInt(int customerId) 
	{
		try {
			application.searchCustomerById(customerId);
		} catch (Exception e) {
		
		}
	}
	
	public void searchAllCustomer() {
		try {
			application.searchAllCustomers();
		} catch (Exception e) {
			
		}
		
		showForm = true;
	}
	
	
	
	
	
	
	
	
	
	
	
}
