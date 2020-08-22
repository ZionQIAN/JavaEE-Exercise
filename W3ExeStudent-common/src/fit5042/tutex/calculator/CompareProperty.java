package fit5042.tutex.calculator;

import javax.ejb.Remote;

import fit5042.tutex.repository.entities.Property;
/**
 * 
 * The interface defines the common behaviors across all compare property activities.
 * 
 * @author qianziang
 *
 */

@Remote
public interface CompareProperty {
	
	void addProperty(Property property);
	
	void removeProperty(Property property);
	
	int bestPerRoom();

}
