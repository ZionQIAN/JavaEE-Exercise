package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.mbeans.CustomerManagedBean;

@Named("removeCustomer")
@RequestScoped
public class RemoveCustomer {

	
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
	
	public RemoveCustomer() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        application = (AusApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "ausApplication");

        application.updateCustomerList();

        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        customerManagedBean = (CustomerManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "customerManagedBean");
    }
	
	public void removeCustomer(int customerId) 
	{
		try {
			customerManagedBean.removeCustomer(customerId);
			
			application.searchAllCustomers();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been deleted succesfully"));
		} catch (Exception e) {
			
		}
		
		showForm = true;
	}
}
