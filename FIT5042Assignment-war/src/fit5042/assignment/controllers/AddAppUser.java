package fit5042.assignment.controllers;

import java.io.Serializable;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.mbeans.AppUserManagedBean;
import fit5042.assignment.repositoty.entities.AppUser;

@Named("addAppUser")
@RequestScoped
public class AddAppUser implements Serializable{
	
	@ManagedProperty(value = "#{appUserManagedBean}")
	AppUserManagedBean appUserManagedBean;
	
	private boolean showForm = true;
	
	private AppUser appUser;
	
	AusApplication application;
	
	private LocalAppUser localAppUser;
	
	
	public boolean isShowForm() 
	{
		return showForm;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
	
	
	
	public LocalAppUser getLocalAppUser() {
		return localAppUser;
	}

	public void setLocalAppUser(LocalAppUser localAppUser) {
		this.localAppUser = localAppUser;
	}

	public AddAppUser() 
	{
		appUser = new AppUser();
		
		localAppUser = new LocalAppUser();
		
		
		 ELContext context
         = FacesContext.getCurrentInstance().getELContext();

		 application = (AusApplication) FacesContext.getCurrentInstance()
				 .getApplication()
				 .getELResolver()
				 .getValue(context, null, "ausApplication");
 
		 ELContext elContext
         = FacesContext.getCurrentInstance().getELContext();
		 
		 appUserManagedBean = (AppUserManagedBean)FacesContext.getCurrentInstance()
				 .getApplication()
				 .getELResolver()
				 .getValue(elContext, null, "appUserManagedBean");
		 

	}
	
	public void addAppUser(LocalAppUser localAppUser) 
	{
		try {

			
			appUserManagedBean.addAppUserinfo(localAppUser);
			
			application.searchAllAppUser();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AppUser has been added succesfully"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		showForm = true;
	}
}
