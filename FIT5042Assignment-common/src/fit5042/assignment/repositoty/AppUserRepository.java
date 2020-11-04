package fit5042.assignment.repositoty;

import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

import fit5042.assignment.repositoty.entities.AppUser;


@Remote
public interface AppUserRepository {
	public List<AppUser> getAllAppUser() throws Exception;
	
    public void addAppUser(AppUser appUser) throws Exception;
    
    public void removeAppUser(int id) throws Exception;
    
    public void editAppUser(AppUser appUser) throws Exception;
    
    public AppUser searchAppUserById(int id) throws Exception;
    
	
}
