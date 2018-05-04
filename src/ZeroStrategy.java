import java.util.ArrayList;

/**
 * No need to care anything, always return 0 in any given case.
 * @author tecty
 *
 */
public class ZeroStrategy implements Strategy {

	@Override
	public int h(ArrayList<Shipment> ufs, Graph g,Vertex pos) {
		// not matter what, return 0
		return 0;
	}

}
