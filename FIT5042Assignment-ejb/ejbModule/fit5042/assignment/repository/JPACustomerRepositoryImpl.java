package fit5042.assignment.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fit5042.assignment.repositoty.CustomerRepository;
import fit5042.assignment.repositoty.entities.Customer;

@Stateless
public class JPACustomerRepositoryImpl implements CustomerRepository{

	@PersistenceContext(unitName = "FIT5042Assignment-ejb")
	private EntityManager entityManager;
	
	@Override
	public void addCustomer(Customer customer) throws Exception
	{
		List<Customer> customers = entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList();
		customer.setCustomerId(customers.get(0).getCustomerId() + 1);
		entityManager.persist(customer);
		entityManager.flush();
	}
	
	@Override
	public Customer searchCustomerById(int id) throws Exception
	{
		Customer customer = entityManager.find(Customer.class, id);
		return customer;
	}
	
	@Override
	public List<Customer> getAllCustomer() throws Exception
	{
		return entityManager.createNamedQuery(Customer.GET_ALL_QUERY_NAME).getResultList();
		
	}
	
	@Override
	public void removeCustomer(int customerId) throws Exception
	{
		Customer customer = searchCustomerById(customerId);
		
		if (customer != null) 
		{
			entityManager.remove(customer);
		}
		
	}
	
	@Override
	public void editCustomer(Customer customer) throws Exception
	{
		try {
			entityManager.merge(customer);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}