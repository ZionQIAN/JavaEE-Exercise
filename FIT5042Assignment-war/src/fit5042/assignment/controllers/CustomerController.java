

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
		
		private int appUserId;
		
		private String dispalyAppUserId;
		
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


		public int getAppUserId() {
			return appUserId;
		}


		public void setAppUserId(int appUserId) {
			this.appUserId = appUserId;
		}

		
		public String getDispalyAppUserId() {
			return dispalyAppUserId;
		}


		public void setDispalyAppUserId(String dispalyAppUserId) {
			this.dispalyAppUserId = dispalyAppUserId;
		}

		
		public fit5042.assignment.repositoty.entities.Customer getCustomer() {
			return customer;
		}


		public void setCustomer(fit5042.assignment.repositoty.entities.Customer customer) {
			this.customer = customer;
		}


		public void setCustomerContacts(ArrayList<CustomerContact> customerContacts) {
			this.customerContacts = customerContacts;
		}

		
		public ArrayList<CustomerContact> getCustomerContacts() {
			return customerContacts;
		}


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
			
			customer = getCustomerInfo();
			
			customerContacts = getCustomerContactsInfo();
			
			setDispalyId();
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
		
		public fit5042.assignment.repositoty.entities.Customer getCustomerInfo()
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
		
		public ArrayList<fit5042.assignment.repositoty.entities.CustomerContact> getCustomerContactsInfo()
		{
			
				customerContacts.clear();
				
				for (CustomerContact customerContact : customer.getCustomerContacts()) 
				{
					customerContacts.add(customerContact);
				}
			
			
			return customerContacts;
		}
		
		public void setDispalyId() 
		{
			if (customer.getAppUser() != null) 
			{
				dispalyAppUserId = String.valueOf(customer.getAppUser().getId());
			}
			else 
			{
				dispalyAppUserId = "no user assign";
			}
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