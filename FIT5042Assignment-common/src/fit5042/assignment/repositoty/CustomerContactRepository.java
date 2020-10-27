package fit5042.assignment.repositoty;

import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import fit5042.assignment.repositoty.entities.Customer;
import fit5042.assignment.repositoty.entities.CustomerContact;

@Remote
public interface CustomerContactRepository {
	
	
	public void addCustomerContact(CustomerContact customerContact) throws Exception;
	
	public CustomerContact searchCustomerContactById(int id) throws Exception;
	
	public List<CustomerContact> getAllCustomerContact() throws Exception;
	
	public void removeCustomerContact(int customerContactId) throws Exception;
	
	public void editCustomerContact(CustomerContact customerContact) throws Exception;

	public Set<CustomerContact> searchCustomerContactByCustomer(Customer customer) throws Exception;

}
