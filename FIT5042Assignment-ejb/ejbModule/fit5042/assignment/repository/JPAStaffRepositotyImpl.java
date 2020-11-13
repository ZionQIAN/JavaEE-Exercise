package fit5042.assignment.repository;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fit5042.assignment.repositoty.AppUserRepository;
import fit5042.assignment.repositoty.StaffRepository;
import fit5042.assignment.repositoty.entities.AppUser;
import fit5042.assignment.repositoty.entities.Staff;

@Stateless
public class JPAStaffRepositotyImpl implements StaffRepository{

	@PersistenceContext(unitName = "FIT5042Assignment-ejb")
    private EntityManager entityManager;

	@Override
	public List<Staff> getAllStaff() throws Exception {
		return entityManager.createNamedQuery(AppUser.GET_ALL_QUERY_NAME).getResultList();
	}
	

	@Override
	public void addStaff(Staff staff) throws Exception {
		List<AppUser> appUsers = entityManager.createNamedQuery(AppUser.GET_ALL_QUERY_NAME).getResultList();
		staff.setId(appUsers.get(0).getId() + 1);
        entityManager.persist(staff);
        entityManager.flush();
		
	}

	@Override
	public void removeStaff(int id) throws Exception {
		Staff staff = this.searchStaffById(id);
        if (staff != null) {
            entityManager.remove(staff);
        }
		
	}

	@Override
	public void editStaff(Staff staff) throws Exception {
		try {
            entityManager.merge(staff);
        } catch (Exception ex) {

        }	
	}

	@Override
	public Staff searchStaffById(int id) throws Exception {
		Staff staff = entityManager.find(Staff.class, id);
        return staff;
	}



}
