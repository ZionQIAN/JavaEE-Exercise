package fit5042.assignment.mbeans;

import java.io.Serializable;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import fit5042.assignment.controllers.LocalAppUser;
import fit5042.assignment.repositoty.AppUserRepository;
import fit5042.assignment.repositoty.entities.AppUser;
import fit5042.assignment.controllers.PasswordSHA256;


@ManagedBean(name = "appUserManagedBean")
@SessionScoped
public class AppUserManagedBean implements Serializable{

	
	@EJB
	AppUserRepository appUserRepository;
	
	private PasswordSHA256 passwordSHA256;
	
	public AppUserManagedBean() 
	{
		
	}
	
	@PostConstruct
	public void init() 
	{
		passwordSHA256 = new PasswordSHA256();
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
	
	public void addAppUser(AppUser appUser) 
	{
		try {
			appUserRepository.addAppUser(appUser);
		} catch (Exception ex) {
            Logger.getLogger(AppUserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void removeAppUser(int appUserId) 
	{
		try {
			appUserRepository.removeAppUser(appUserId);
		} catch (Exception ex) {
            Logger.getLogger(AppUserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void editAppUser(AppUser appUser) 
	{
		try {
			
			//tansfer password with SHA256
			
			String password = appUser.getPassword();
			
			password = passwordSHA256.generatePassword(password);
			
			appUser.setPassword(password);

			appUserRepository.editAppUser(appUser);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("This AppUser has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(AppUserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	public void addAppUserinfo(LocalAppUser localAppUser) 
	{
		//tansfer password with SHA256
		
		String password = localAppUser.getPassword();
		
		password = passwordSHA256.generatePassword(password);
		
		localAppUser.setPassword(password);
		
		AppUser appUser = convertLocalAppUserToEntity(localAppUser);
		
		try {
			appUserRepository.addAppUser(appUser);
		} catch (Exception ex) {
            Logger.getLogger(AppUserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	private AppUser convertLocalAppUserToEntity(LocalAppUser localAppUser) 
	{
		AppUser appUser = new AppUser();
		
		
		appUser.setUsername(localAppUser.getUserName());
		appUser.setDob(localAppUser.getDob());
		appUser.setPassword(localAppUser.getPassword());
		appUser.setUserLevel(localAppUser.getUserLevel());
		
		return appUser;
	}
	
	public void changeAppUserPassword(AppUser appUser) 
	{
		try {
			
			//tansfer password with SHA256
			
			String password = appUser.getPassword();
			
			password = passwordSHA256.generatePassword(password);
			
			appUser.setPassword(password);

			appUserRepository.editAppUser(appUser);

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("This Password has been updated succesfully"));
        } catch (Exception ex) {
            Logger.getLogger(AppUserManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
}
