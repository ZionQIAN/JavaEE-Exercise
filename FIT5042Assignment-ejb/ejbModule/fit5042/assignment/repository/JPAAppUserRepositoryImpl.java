package fit5042.assignment.repository;

import java.util.List;
import java.util.Set;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fit5042.assignment.repositoty.AppUserRepository;
import fit5042.assignment.repositoty.entities.AppUser;
import fit5042.assignment.repositoty.entities.Staff;



@Stateless
public class JPAAppUserRepositoryImpl implements AppUserRepository{
	
	@PersistenceContext(unitName = "FIT5042Assignment-ejb")
    private EntityManager entityManager;

	@Override
	public List<AppUser> getAllAppUser() throws Exception {
		return entityManager.createNamedQuery(AppUser.GET_ALL_QUERY_NAME).getResultList();
	}
	

	@Override
	public void addAppUser(AppUser appUser) throws Exception {
		List<AppUser> appUsers = entityManager.createNamedQuery(AppUser.GET_ALL_QUERY_NAME).getResultList();
		appUser.setId(appUsers.get(0).getId() + 1);
        entityManager.persist(appUser);
        entityManager.flush();
		
	}

	@Override
	public void removeAppUser(int Id) throws Exception {
		AppUser appUser = this.searchAppUserById(Id);
        if (appUser != null) {
            entityManager.remove(Id);
        }
		
	}

	@Override
	public void editAppUser(AppUser appUser) throws Exception {
		try {
            entityManager.merge(appUser);
        } catch (Exception ex) {

        }	
	}

	@Override
	public AppUser searchAppUserById(int appUserId) throws Exception {
		AppUser appUser = entityManager.find(AppUser.class, appUserId);
        return appUser;
	}



}
