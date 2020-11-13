package fit5042.assignment.controllers;

import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import fit5042.assignment.mbeans.AppUserManagedBean;
import fit5042.assignment.mbeans.StaffManagedBean;
import fit5042.assignment.repositoty.entities.AppUser;
import fit5042.assignment.repositoty.entities.Staff;

@Named("addStaff")
@RequestScoped
public class AddStaff {
	@ManagedProperty(value = "#{staffManagedBean}")
	StaffManagedBean staffManagedBean;
	
	private boolean showForm = true;
	
	private Staff staff;
	
	AusApplication application;
	
	private LocalStaff localStaff;
	
	public boolean isShowForm() 
	{
		return showForm;
	}

	public Staff getStaff() {
		return staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public LocalStaff getLocalStaff() {
		return localStaff;
	}

	public void setLocalStaff(LocalStaff localStaff) {
		this.localStaff = localStaff;
	}
	
	public AddStaff() 
	{
		staff = new Staff();
		
		localStaff = new LocalStaff();
		
		
		 ELContext context
         = FacesContext.getCurrentInstance().getELContext();

		 application = (AusApplication) FacesContext.getCurrentInstance()
				 .getApplication()
				 .getELResolver()
				 .getValue(context, null, "ausApplication");
 
		 ELContext elContext
         = FacesContext.getCurrentInstance().getELContext();
		 
		 staffManagedBean = (StaffManagedBean)FacesContext.getCurrentInstance()
				 .getApplication()
				 .getELResolver()
				 .getValue(elContext, null, "staffManagedBean");
		 

	}
	
	public void addStaff(LocalStaff LocalStaff) 
	{
		try {
			staffManagedBean.addStaffInfo(LocalStaff);
			
			application.searchAllAppUser();
			
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Staff has been added succesfully"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		showForm = true;
	}
}
