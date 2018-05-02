import java.util.ArrayList;

public class StatePrinter {
	public void printState(State s) {
		System.out.println("cost = "+s.getCurrentCost());
		
		ArrayList<Vertex> history = s.getVisited();
		for (int i = 1; i < history.size(); i++) {
			System.out.println("Ship "+history.get(i-1)+" to "+ history.get(i));
		}
		
	}
}
