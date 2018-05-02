import java.util.ArrayList;

public class ZeroStrategy implements Strategy {

	@Override
	public int h(ArrayList<Shipment> ufs, Graph g,Vertex pos) {
		// not matter what, return 0
		return 0;
	}

}
