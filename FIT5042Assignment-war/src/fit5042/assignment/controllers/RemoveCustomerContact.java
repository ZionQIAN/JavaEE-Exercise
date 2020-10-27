package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.mbeans.CustomerContactManagedBean;


@RequestScoped
@Named("removeCustomerContact")
public class RemoveCustomerContact {
	
	@ManagedProperty(value = "#{customerContactManagedBean}")
	CustomerContactManagedBean customerContactManagedBean;
	
	private boolean showForm = true;
	
	private CustomerContact customerContact;
	
	AusApplication application;
	
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
	
	public RemoveCustomerContact() {
        ELContext context
                = FacesContext.getCurrentInstance().getELContext();

        application = (AusApplication) FacesContext.getCurrentInstance()
                .getApplication()
                .getELResolver()
                .getValue(context, null, "ausApplication");

        application.updateCustomerContactList();

        //instantiate propertyManagedBean
        ELContext elContext = FacesContext.getCurrentInstance().getELContext();
        customerContactManagedBean = (CustomerContactManagedBean) FacesContext.getCurrentInstance().getApplication()
                .getELResolver().getValue(elContext, null, "customerContactManagedBean");
    }
	
	public void removeCustomerContact(int customerContactId) 
	{
		try {
			customerContactManagedBean.removeCustomerContact(customerContactId);
			
			application.searchAllCustomerContact();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("CustomerContact has been deleted succesfully"));
		} catch (Exception e) {
			
		}
		
		showForm = true;
	}

}
