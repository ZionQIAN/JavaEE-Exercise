package fit5042.assignment.mbeans;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import fit5042.assignment.repositoty.AppUserRepository;
import fit5042.assignment.repositoty.entities.AppUser;
import fit5042.assignment.repositoty.entities.Customer;

@ManagedBean(name = "appUserManagedBean")
@SessionScoped
public class AppUserManagedBean implements Serializable{

	
	@EJB
	AppUserRepository appUserRepository;
	
	public AppUserManagedBean() 
	{
		
	}
	
	@PostConstruct
	public void init() 
	{
		
	}
	public List<AppUser> getAllAppUser()
	{
		try {
			List<AppUser> appUsers = appUserRepository.getAllAppUser();
            return appUsers;
        } catch (Exception ex) {
            Logger.getLogger(CustomerManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
	}
	
	
	
}
