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

@Named("removeAppUser")
@RequestScoped
public class RemoveAppUser implements Serializable{

	@ManagedProperty(value = "#{appUserManagedBean}")
	AppUserManagedBean appUserManagedBean;
	
	private boolean showForm = true;
	
	AusApplication application;
	
	private AppUser appUser;
	
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

	public RemoveAppUser() 
	{
		ELContext context
        = FacesContext.getCurrentInstance().getELContext();

		application = (AusApplication) FacesContext.getCurrentInstance()
        .getApplication()
        .getELResolver()
        .getValue(context, null, "ausApplication");

		application.updateAppUser();

		
		ELContext elContext = FacesContext.getCurrentInstance().getELContext();
		appUserManagedBean = (AppUserManagedBean) FacesContext.getCurrentInstance().getApplication()
        .getELResolver().getValue(elContext, null, "appUserManagedBean");
	}
	
	public void removeAppUser(int appUserId) 
	{
		try {
			appUserManagedBean.removeAppUser(appUserId);
			
			application.searchAllAppUser();;
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("AppUser has been deleted succesfully"));
		} catch (Exception e) {
			
		}
		
		showForm = true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
