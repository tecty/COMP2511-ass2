import java.util.ArrayList;

/**
 * Print the state by a style. 
 * @author tecty
 *
 */
public class StatePrinter {
	/**
	 * Print the state by requirement.
	 * @param s State need to be printed.
	 */
	public void printState(State s) {
		System.out.println("cost = "+s.getCurrentCost());
		
		ArrayList<Vertex> history = s.getVisited();
		for (int i = 1; i < history.size(); i++) {
			System.out.println("Ship "+history.get(i-1)+" to "+ history.get(i));
		}
		
	}
}
