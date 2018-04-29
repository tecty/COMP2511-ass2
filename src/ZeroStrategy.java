import java.util.ArrayList;

/***
 * 
 * @author tecty
 *
 * @param <E>
 */
public class ZeroStrategy implements Strategy {

	@Override
	public int h(ArrayList<Shipment> unfishedShipment) {
		return 0;
	}
	
}
