import java.util.ArrayList;
/**
 * Calculate the huristic cost by adding up the 
 * remaining cost of all the shipment.
 * @author tecty
 *
 */
public class RemainShipStrategy implements Strategy {

	@Override
	public int h(ArrayList<Shipment> ufs, Graph g, Vertex pos) {
		int cost= 0;
		for(int i =0; i < ufs.size();i++) {
			cost += ufs.get(i).getCost();
		}
		
		return cost;
	}

}
