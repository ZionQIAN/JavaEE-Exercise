package fit5042.assignment.repositoty.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity(name = "Administrator")
@DiscriminatorValue(value = "A")
//@PrimaryKeyJoinColumn(name = "id")
@NamedQueries({ @NamedQuery(name = Administrator.GET_ALL_QUERY_NAME, query = "SELECT a FROM Administrator a")})
public class Administrator extends AppUser implements Serializable{

	public static final String GET_ALL_QUERY_NAME = "Administrator.getAll";


    public Administrator() {
    }


	public Administrator(int id, String username, String password, Date dob, Set<Customer> customerMangement,
			String userLevel) {
		super(id, username, password, dob, customerMangement, userLevel);
		
	}


	
}