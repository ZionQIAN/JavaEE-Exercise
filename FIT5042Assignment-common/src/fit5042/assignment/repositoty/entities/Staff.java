package fit5042.assignment.repositoty.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity(name = "Staff")
@DiscriminatorValue(value = "S")
@NamedQueries({
	@NamedQuery(name = Staff.GET_ALL_QUERY_NAME, query = "SELECT s FROM Staff s") })
public class Staff extends AppUser implements Serializable{

	public static final String GET_ALL_QUERY_NAME = "Staff.getAll";
	
	public Staff() {
		
	}

	public Staff(int id, String username, String password, Date dob, Set<Customer> customerMangement,
			String userLevel) {
		super(id, username, password, dob, customerMangement, userLevel);
	
	}
	

	
	
	

    
}
