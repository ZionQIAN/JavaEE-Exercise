package fit5042.assignment.repositoty.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries(
		{@NamedQuery(name = CustomerContact.GET_ALL_QUERY_NAME, query = "SELECT cc FROM CustomerContact cc order by cc.customerContactId desc")})

public class CustomerContact implements Serializable{
	
	public static final String GET_ALL_QUERY_NAME = "CustomerContact.getAll";
	
	private int customerContactId;
	private String name;
	private String gender;
	private int age;
	private int workPhone;
	private String position; 
	
	private Customer customer;
	
	public CustomerContact() 
	{}

	public CustomerContact(int customerContactId, String name, String gender, int age, int workPhone, String position,
			Customer customer) {
		this.customerContactId = customerContactId;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.workPhone = workPhone;
		this.position = position;
		this.customer = customer;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "customerContact_id")
	public int getCustomerContactId() {
		return customerContactId;
	}

	public void setCustomerContactId(int customerContactId) {
		this.customerContactId = customerContactId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getWorkPhone() {
		return workPhone;
	}

	public void setWorkPhone(int workPhone) {
		this.workPhone = workPhone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@ManyToOne
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "CustomerContact [customerContactId=" + customerContactId + ", name=" + name + ", gender=" + gender
				+ ", age=" + age + ", workPhone=" + workPhone + ", position=" + position + ", customer=" + customer
				+ "]";
	}
	
	
	
	
	
	
}
