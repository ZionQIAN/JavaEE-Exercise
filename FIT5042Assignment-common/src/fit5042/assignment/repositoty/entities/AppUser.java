package fit5042.assignment.repositoty.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

@Entity(name = "AppUser")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "USERTYPE",discriminatorType = DiscriminatorType.STRING, length = 1)
@NamedQueries({
    @NamedQuery(name = AppUser.GET_ALL_QUERY_NAME, query = "select u from AppUser u order by u.id desc")})
public class AppUser implements Serializable{
	public static final String GET_ALL_QUERY_NAME = "AppUser.getAll";
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String username;
    private String password;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dob;
	private Set<Customer> customerMangement;
	private String userLevel;

    public AppUser() {
    }


	public AppUser(int id, String username, String password, Date dob, Set<Customer> customerMangement,
			String userLevel) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.dob = dob;
		this.customerMangement = customerMangement;
		this.userLevel = userLevel;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}
	

	public String getUserLevel() {
		return userLevel;
	}



	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}



	@OneToMany (mappedBy = "AppUser",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	public Set<Customer> getCustomerMangement() {
		return customerMangement;
	}


	public void setCustomerMangement(Set<Customer> customerMangement) {
		this.customerMangement = customerMangement;
	}



	@Override
	public String toString() {
		return "AppUser [id=" + id + ", username=" + username + ", password=" + password + ", customerMangement="
				+ customerMangement + "]";
	}

    
}
