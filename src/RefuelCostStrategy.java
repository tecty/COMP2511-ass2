import java.util.ArrayList;


/**
 * 
 */

/**
 * @author tecty
 *
 */
@SuppressWarnings("hiding")
public class RefuelCostStrategy implements Strategy  {

	public int h(ArrayList<Shipment> unfishedShipment) {
		// initial the total cost to 0
		int totalcost = 0;
		
		for(int i = 0; i < unfishedShipment.size(); i++) {
			// add up all the remain cost
			totalcost += ((Vertex) unfishedShipment.get(i).getFrom()).getRefuelCost();
			
		}
		return totalcost;
	}

}
