package fit5042.assignment.repositoty;

import java.util.List;

import javax.ejb.Remote;

import fit5042.assignment.repositoty.entities.Customer;


@Remote
public interface CustomerRepository {

	public void addCustomer(Customer customer) throws Exception;
	
	public Customer searchCustomerById(int id) throws Exception;
	
	public List<Customer> getAllCustomer() throws Exception;
	
	public void removeCustomer(int customerId) throws Exception;
	
	public void editCustomer(Customer customer) throws Exception;

	public List<Customer> searchCustomerByName(String customerName) throws Exception;
	
}
