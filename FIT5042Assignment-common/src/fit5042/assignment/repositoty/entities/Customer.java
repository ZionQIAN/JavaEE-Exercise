package fit5042.assignment.repositoty.entities;

import java.io.Serializable;
import java.util.Set;
import java.util.HashSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "CUSTOMER")
@NamedQueries({
    @NamedQuery(name = Customer.GET_ALL_QUERY_NAME, query = "SELECT c FROM Customer c order by c.customerId desc")})
public class Customer implements Serializable{
	
	
	public static final String GET_ALL_QUERY_NAME = "Customer.getAll";
	
	private int customerId;
	private String customerName;
	private Industry industry;
	private String CEO;
	private int numberOfemployees;
	private String website;
	private int officePhone;
	private String address;
	
	private Set<CustomerContact> customerContacts;

	public Customer() {
		
	}
	
	public Customer(int customerId, Industry industry, String CEO, int numberOfemployees, String customerName,
			String website, int officePhone, String address) {
		
		this.customerId = customerId;
		this.industry = industry;
		this.CEO = CEO;
		this.numberOfemployees = numberOfemployees;
		this.customerName = customerName;
		this.website = website;
		this.officePhone = officePhone;
		this.address = address;
		this.customerContacts = new HashSet<>();
		
	}

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "customer_id")
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Embedded
	@Column(name = "industry")
	public Industry getIndustry() {
		return industry;
	}

	public void setIndustry(Industry industry) {
		this.industry = industry;
	}

	public String getCEO() {
		return CEO;
	}

	public void setCEO(String CEO) {
		this.CEO = CEO;
	}

	public int getNumberOfemployees() {
		return numberOfemployees;
	}

	public void setNumberOfemployees(int numberOfemployees) {
		this.numberOfemployees = numberOfemployees;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public int getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(int officePhone) {
		this.officePhone = officePhone;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public Set<CustomerContact> getCustomerContacts() {
		return customerContacts;
	}

	public void setCustomerContacts(Set<CustomerContact> customerContacts) {
		this.customerContacts = customerContacts;
	}
	
	@Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.customerId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Customer other = (Customer) obj;
        if (this.customerId != other.customerId) {
            return false;
        }
        return true;
    }

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", industry=" + industry + ", CEO=" + CEO + ", numberOfemployees="
				+ numberOfemployees + ", customerName=" + customerName + ", website=" + website + ", officePhone="
				+ officePhone + ", address=" + address + "]";
	}
	
	
}
