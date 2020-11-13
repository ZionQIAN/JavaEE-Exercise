package fit5042.assignment.controllers;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import fit5042.assignment.repositoty.entities.AppUser;

@Named(value = "appUserController")
@RequestScoped
public class AppUserController implements Serializable{

	private int appUserId;
	
	private AppUser appUser = new AppUser();

	public int getAppUserId() {
		return appUserId;
	}

	public void setAppUserId(int appUserId) {
		this.appUserId = appUserId;
	}
	
	public AppUserController() 
	{
		
	}
	
	@PostConstruct
	public void init() 
	{
		appUserId = Integer.valueOf(FacesContext.getCurrentInstance()
				.getExternalContext()
				.getRequestParameterMap()
				.get("appUserID"));

		
		appUser = getAppUserInfo();
	}
	
	public AppUser getAppUserInfo() 
	{
		//if(appUser == null) 
		//{
			ELContext context = FacesContext.getCurrentInstance().getELContext();
			
			AusApplication application = (AusApplication) FacesContext.getCurrentInstance()
					.getApplication()
					.getELResolver()
					.getValue(context, null, "ausApplication");
			
			application.searchAllCustomers();
			application.searchAllCustomerContact();
			application.searchAllAppUser();
			
			return application.getAppUsers().get(appUserId);
		//}
		
		//return appUser;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
	
	
	
}
