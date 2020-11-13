package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.repositoty.entities.AppUser;

@Named("searchAppUser")
@RequestScoped
public class SearchAppUser {

	private boolean showForm = true;
	
	AusApplication application;
	
	private AppUser appUser;
	
	public boolean isShowForm() 
	{
		return showForm;
	}

	public AusApplication getApplication() {
		return application;
	}

	public void setApplication(AusApplication application) {
		this.application = application;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
	
	public SearchAppUser() 
	{
		ELContext context
        = FacesContext.getCurrentInstance().getELContext();

		application = (AusApplication) FacesContext.getCurrentInstance()
        .getApplication()
        .getELResolver()
        .getValue(context, null, "ausApplication");

		application.updateAppUser();
	}
	
	public void searchAllAppUser() 
	{
		try {
			application.searchAllAppUser();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		showForm = true;
	}
	
	
}
