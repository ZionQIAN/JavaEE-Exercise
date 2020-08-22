package fit5042.tutex.calculator;

import java.util.HashSet;
import java.util.Set;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.ejb.Stateless;



import fit5042.tutex.repository.entities.Property;;

/**
 * 
 * @author qianziang
 *
 */

@Stateful
public class ComparePropertySessionBean implements CompareProperty{
	
	private Set<Property> set;
	
	public ComparePropertySessionBean() 
	{
		set = new HashSet<Property>();
	}
		
	@Override
	public void addProperty(Property property) 
	{
		set.add(property);
	}
	
	@Override
	public void removeProperty(Property property) 
	{
		for (Property p : set) {
			if (p.getConactPersonId() == property.getConactPersonId()) {
				set.remove(property);
				break;
			}
		}
	}
	
	@Override
	public int bestPerRoom() 
	{
		double tem = 0.00;
		int bestPerRoom = 0;
		
		for (Property property : set) {
			
			if(tem  < property.getPrice()/property.getNumberOfBedrooms()) 
			{
				tem = property.getPrice()/property.getNumberOfBedrooms();
				bestPerRoom = property.getPropertyId();
			}
			
		}
		return bestPerRoom;
	}

}
