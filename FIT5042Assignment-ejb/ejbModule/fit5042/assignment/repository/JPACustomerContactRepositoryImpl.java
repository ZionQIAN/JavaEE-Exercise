package fit5042.assignment.repository;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fit5042.assignment.repositoty.CustomerContactRepository;
import fit5042.assignment.repositoty.entities.Customer;
import fit5042.assignment.repositoty.entities.CustomerContact;

@Stateless
public class JPACustomerContactRepositoryImpl implements CustomerContactRepository{

	@PersistenceContext(unitName = "FIT5042Assignment-ejb")
	private EntityManager entityManager;
	
	@Override
	public void addCustomerContact(CustomerContact customerContact) throws Exception
	{
		
		List<CustomerContact> customerContacts = entityManager.createNamedQuery(CustomerContact.GET_ALL_QUERY_NAME).getResultList();
		//customerContact.setCustomerContactId(customerContacts.get(0).getCustomerContactId() + 1);
		Customer customer = customerContact.getCustomer();
		customer.getCustomerContacts().add(customerContact);
		entityManager.merge(customer);
		entityManager.persist(customerContact);
		entityManager.flush();
		
	}
	
	@Override
	public CustomerContact searchCustomerContactById(int id) throws Exception
	{
		CustomerContact customerContact = entityManager.find(CustomerContact.class, id);
		return customerContact;
	}
	
	@Override
	public List<CustomerContact> getAllCustomerContact() throws Exception
	{
		return entityManager.createNamedQuery(CustomerContact.GET_ALL_QUERY_NAME).getResultList();
	}
	
	@Override
	public void removeCustomerContact(int customerContactId) throws Exception
	{
		CustomerContact customerContact = searchCustomerContactById(customerContactId);
		if (customerContact != null) 
		{
			entityManager.remove(customerContact);
		}
	}
	
	@Override
	public void editCustomerContact(CustomerContact customerContact) throws Exception
	{
		try {
			entityManager.merge(customerContact);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Set<CustomerContact> searchCustomerContactByCustomer(Customer customer) throws Exception
	{
		Customer selectedCustomer = entityManager.find(Customer.class, customer.getCustomerId());
		entityManager.refresh(selectedCustomer);
		
		return selectedCustomer.getCustomerContacts();
	}
}