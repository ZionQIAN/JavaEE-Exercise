

package fit5042.assignment.controllers;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;

import fit5042.assignment.repositoty.entities.CustomerContact;

@Named(value = "customerController")
@RequestScoped
public class CustomerController {
		private int customerId;
		
		private fit5042.assignment.repositoty.entities.Customer customer;
		
		private ArrayList<CustomerContact> customerContacts = new ArrayList<CustomerContact>();
		
		//private int searchByInt;
		
		//private int searchedCustomerContactId;
		
		public int getCustomerId() {
			return customerId;
		}


		public void setCustomerId(int customerId) {
			this.customerId = customerId;
		}
		

		//public int getSearchedCustomerContactId() {
		//	return searchedCustomerContactId;
		//}


		//public void setSearchedCustomerContactId(int searchedCustomerContactId) {
		//	this.searchedCustomerContactId = searchedCustomerContactId;
		//}


		public CustomerController() 
		{
			
		}
		
		//public int getSearchByInt() {
		//	return searchByInt;
		//}

		//public void setSearchByInt(int searchByInt) {
		//	this.searchByInt = searchByInt;
		//}
		
		
		@PostConstruct
		public void init() 
		{
			customerId = Integer.valueOf(FacesContext.getCurrentInstance()
					.getExternalContext()
					.getRequestParameterMap()
					.get("customerID"));
			
			customer = getCustomer();
			
			customerContacts = getCustomerContacts();
			
//			String tempString = FacesContext.getCurrentInstance()
//					.getExternalContext()
//					.getRequestParameterMap()
//					.get("searchCustomerContactID");
//			
//			if(tempString != null) 
//			{
//				searchedCustomerContactId = Integer.valueOf(tempString);
//				searchCustomerContacts();
//			}else 
//			{
//				searchedCustomerContactId = 0;
//			}
			
			//filterCustomerContacts();
			
		}
		
		//public CustomerController() 
		//{
		//	customerId = Integer.valueOf(FacesContext.getCurrentInstance()
		//			.getExternalContext()
		//			.getRequestParameterMap()
		//			.get("customerID"));
		//	
		//	customer = getCustomer();
		//	
		//	customerContacts = getCustomerContacts();
		//	
		//}
		
		public fit5042.assignment.repositoty.entities.Customer getCustomer()
		{
			if(customer == null) 
			{
				ELContext context = FacesContext.getCurrentInstance().getELContext();
				
				AusApplication application = (AusApplication) FacesContext.getCurrentInstance()
						.getApplication()
						.getELResolver()
						.getValue(context, null, "ausApplication");
				
				application.searchAllCustomers();
				application.searchAllCustomerContact();
				
				return application.getCustomers().get(customerId);
			}
			
			return customer;
		}
		
		public ArrayList<fit5042.assignment.repositoty.entities.CustomerContact> getCustomerContacts()
		{
			
				customerContacts.clear();
				
				for (CustomerContact customerContact : customer.getCustomerContacts()) 
				{
					customerContacts.add(customerContact);
				}
			
			
			return customerContacts;
		}
		
		
//		public void filterCustomerContacts()
//		{
//			ArrayList<CustomerContact> tempArrayList = new ArrayList<CustomerContact>();
//			
//			ELContext context = FacesContext.getCurrentInstance().getELContext();
//			
//			AusApplication application = (AusApplication) FacesContext.getCurrentInstance()
//					.getApplication()
//					.getELResolver()
//					.getValue(context, null, "ausApplication");
//			
//			for(CustomerContact cc : application.getCustomerContacts()) 
//			{
//				for(CustomerContact cc2 : customerContacts) 
//				{
//					if(cc.getCustomerContactId() == cc2.getCustomerContactId()) 
//					{
//						tempArrayList.add(cc);
//					}
//				}
//			}
//			
//			customerContacts = tempArrayList;
//				
//		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
}