package fit5042.assignment.mbeans;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fit5042.assignment.repositoty.CustomerRepository;
import fit5042.assignment.repositoty.entities.Customer;
import fit5042.assignment.repositoty.entities.Industry;


@ManagedBean(name = "customerManagedBean")
@SessionScoped
public class CustomerManagedBean implements Serializable{

	@EJB
	CustomerRepository customerRepository;
	
	public CustomerManagedBean() 
	{
		
	}
	
	@PostConstruct
	public void init() 
	{
		
	}
	
	public List<Customer> getAllCustomer()
	{
		try {
            List<Customer> customers = customerRepository.getAllCustomer();
            return customers;
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}
	
	public void addCustomer(Customer customer) 
	{
		try {
			customerRepository.addCustomer(customer);
		} catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public Customer searchCustomerById(int customerId) 
	{
		
		try {
			return customerRepository.searchCustomerById(customerId);
		} catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
		
		return null;
	}
	
	public void removeCustomer(int customerId) 
	{
		try {
			customerRepository.removeCustomer(customerId);
		} catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void editCustomer(Customer customer) 
	{
		try {
            //String industryString = customer.getIndustry().getIndustryName();
            //Industry industry = customer.getIndustry();
            //industry.setIndustryName(industryString);
            //customer.setIndustry(industry);

            customerRepository.editCustomer(customer);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Customer has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void addCustomer(fit5042.assignment.controllers.Customer localCustomer) 
	{
		Customer customer = convertCustomerToEntity(localCustomer);
		try {
			customerRepository.addCustomer(customer);
		} catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	private Customer convertCustomerToEntity(fit5042.assignment.controllers.Customer localCustomer) 
	{
		Customer customer = new Customer();
		String industryName = localCustomer.getIndustryName();
		Industry industry = new Industry(industryName);
		customer.setIndustry(industry);
		customer.setAddress(localCustomer.getAddress());
		customer.setCEO(localCustomer.getCEO());
		customer.setCustomerId(localCustomer.getCustomerId());
		customer.setNumberOfemployees(localCustomer.getNumberOfemployees());
		customer.setOfficePhone(localCustomer.getOfficePhone());
		customer.setWebsite(localCustomer.getWebsite());
		customer.setCustomerName(localCustomer.getCustomerName());
		
		
		return customer;
	}
	
	
	
}
