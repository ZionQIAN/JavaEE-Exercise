package fit5042.assignment.repositoty.entities;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Embeddable
@Access(AccessType.PROPERTY)
public class Industry implements Serializable{
	
	
	private String industryName;
	
	public Industry() {}
	
	public Industry(String industryName) {
		
		this.industryName = industryName;
	}

	@Column(name = "industry_name")
	public String getIndustryName() {
		return industryName;
	}

	public void setIndustryName(String industryName) {
		this.industryName = industryName;
	}

	
	
	

}
