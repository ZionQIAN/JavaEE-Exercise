package fit5042.assignment.mbeans;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fit5042.assignment.repositoty.CustomerContactRepository;
import fit5042.assignment.repositoty.CustomerRepository;
import fit5042.assignment.repositoty.entities.Customer;
import fit5042.assignment.repositoty.entities.CustomerContact;
import fit5042.assignment.repositoty.entities.Industry;


@ManagedBean(name = "customerContactManagedBean")
@SessionScoped
public class CustomerContactManagedBean implements Serializable{

	@EJB
	CustomerContactRepository customerContactRepository;
	
	public CustomerContactManagedBean() 
	{
		
	}
	
	public List<CustomerContact> getAllCustomerContact()
	{
		try {
            List<CustomerContact> customerContacts = customerContactRepository.getAllCustomerContact();
            return customerContacts;
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}
	
	public void addCustomerContact(fit5042.assignment.controllers.CustomerContact localCustomerContact) 
	{
		CustomerContact customerContact = convertCustomerToEntity(localCustomerContact);
		
		try {
			customerContactRepository.addCustomerContact(customerContact);
		} catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public CustomerContact searchCustomerContactById(int customerId) 
	{
		
		try {
			return customerContactRepository.searchCustomerContactById(customerId);
		} catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return null;
	}
	
	public void removeCustomerContact(int customerId) 
	{
		try {
			customerContactRepository.removeCustomerContact(customerId);
		} catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void editCustomerContact(CustomerContact customerContact) 
	{
		try {
            //String industryString = customer.getIndustry().getIndustryName();
            //Industry industry = customer.getIndustry();
            //industry.setIndustryName(industryString);
            //customer.setIndustry(industry);

			customerContactRepository.editCustomerContact(customerContact);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	
	
	private CustomerContact convertCustomerToEntity(fit5042.assignment.controllers.CustomerContact localCustomerContact) 
	{
		CustomerContact customerContact = new CustomerContact();
		
		customerContact.setAge(localCustomerContact.getAge());
		customerContact.setGender(localCustomerContact.getGender());
		customerContact.setName(localCustomerContact.getName());
		customerContact.setPosition(localCustomerContact.getPosition());
		customerContact.setWorkPhone(localCustomerContact.getWorkPhone());
		customerContact.setCustomer(localCustomerContact.getCustomer());
		
		return customerContact;
	}
	
}
