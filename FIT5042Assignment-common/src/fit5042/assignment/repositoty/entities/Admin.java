package fit5042.assignment.repositoty.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({@NamedQuery(name = Admin.GET_ALL_QUERY_NAME, query = "SELECT a FROM Admin a order by a.adminId desc")})
public class Admin implements Serializable{
	public static final String GET_ALL_QUERY_NAME = "Admin.getAll";
	
	private int adminId;
	private String adminName;
	
	public Admin() {}
	
	
	public Admin(String adminName) {
		
		this.adminName = adminName;
	}


	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "admin_id")
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminNameString=" + adminName + "]";
	}
	
	

}
