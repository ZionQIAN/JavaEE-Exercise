package fit5042.assignment.repositoty;

import java.util.List;

import javax.ejb.Remote;


import fit5042.assignment.repositoty.entities.Staff;

@Remote
public interface StaffRepository {

public List<Staff> getAllStaff() throws Exception;
	
    public void addStaff(Staff staff) throws Exception;
    
    public void removeStaff(int id) throws Exception;
    
    public void editStaff(Staff staff) throws Exception;
    
    public Staff searchStaffById(int id) throws Exception;
	
}
