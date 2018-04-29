import java.util.ArrayList;

/***
 * 
 * @author tecty
 *
 * @param <E>
 */

public class RemainCostStrategy implements Strategy {

	public int h(ArrayList<Shipment> unfishedShipment) {
		// initial the total cost to 0
		int totalcost = 0;
		
		for(int i = 0; i < unfishedShipment.size(); i++) {
			// add up all the remain cost
			totalcost += unfishedShipment.get(i).getCost();
			
		}
		return totalcost;
	}


}
