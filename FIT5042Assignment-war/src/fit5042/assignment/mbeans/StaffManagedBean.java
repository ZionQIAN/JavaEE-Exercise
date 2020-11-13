package fit5042.assignment.mbeans;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import fit5042.assignment.controllers.LocalAppUser;
import fit5042.assignment.controllers.LocalStaff;
import fit5042.assignment.repositoty.StaffRepository;
import fit5042.assignment.repositoty.entities.AppUser;
import fit5042.assignment.repositoty.entities.Staff;
import fit5042.assignment.controllers.PasswordSHA256;

@ManagedBean(name = "staffManagedBean")
@SessionScoped
public class StaffManagedBean implements Serializable{

	
	@EJB
	StaffRepository staffRepository;
	
	PasswordSHA256 passwordSHA256;
	
	public StaffManagedBean() 
	{
		passwordSHA256 = new PasswordSHA256();
	}
	
	@PostConstruct
	public void init() 
	{
		
	}
	
	public void addStaffInfo(LocalStaff localStaff) 
	{
		
		String password = localStaff.getPassword();
		
		password = passwordSHA256.generatePassword(password);
		
		localStaff.setPassword(password);
		
		Staff staff = convertLocalStaffToEntity(localStaff);
		
		try {
			staffRepository.addStaff(staff);
		} catch (Exception ex) {
            Logger.getLogger(StaffManagedBean.class.getName()).log(Level.SEVERE, null, ex);
        }
	}
	
	private Staff convertLocalStaffToEntity(LocalStaff localStaff) 
	{
		Staff staff = new Staff();
		
		
		staff.setUsername(localStaff.getUserName());
		staff.setDob(localStaff.getDob());
		staff.setPassword(localStaff.getPassword());
		staff.setUserLevel(localStaff.getUserLevel());
		
		return staff;
	}
	
	
	
	
}
