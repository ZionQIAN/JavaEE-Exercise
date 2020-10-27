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
@NamedQueries({@NamedQuery(name = Staff.GET_ALL_QUERY_NAME, query = "SELECT s FROM Staff s order by s.staffId desc")})
public class Staff implements Serializable{
	public static final String GET_ALL_QUERY_NAME = "Staff.getAll";
	
	private int staffId;
	private String staffName;
	
	public Staff() {}
	
	public Staff(String staffName) {
		this.staffName = staffName;
	}
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "staff_id")
	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Override
	public String toString() {
		return "Staff [staffId=" + staffId + ", staffNameString=" + staffName + "]";
	}
	
	

}
