import java.util.ArrayList;

/**
 * Strategy that calculate the heuristic cost. 
 * @author tecty
 *
 */
public interface Strategy {
	/**
	 * All the information may needed calculate the heuristic cost.
	 * @param ufs Currently unfinished shipment.
	 * @param g The graph that is visiting.
	 * @param pos Current position of the ship.
	 * @return The heuristic cost.
	 */
	int h(ArrayList<Shipment> ufs, Graph g,Vertex pos);
}
