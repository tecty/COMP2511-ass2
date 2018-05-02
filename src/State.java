import java.util.ArrayList;

/**
 * 
 */

/**
 * @author tecty
 *
 */
public class State implements Comparable<State>, Cloneable{
	private ArrayList<Vertex> visited ;
	private ArrayList<Shipment> unfinishShipment;
	private int currentCost;
	private final Strategy strategy;
	private final Graph graph;
	
	public State(ArrayList<Shipment> ufs,Graph g,  Strategy strategy, 
			ArrayList<Vertex> visited, int initial_cost) {
		
		this.visited = new ArrayList<>();
		this.unfinishShipment = new ArrayList<>();
		// assign the ufs by deep copy
		for (int i = 0; i < ufs.size(); i++) {
			this.unfinishShipment.add(ufs.get(i));
		}
		
		// assign the visited array by deep copy
		for(int i = 0; i < visited.size(); i ++) {
			this.visited.add(visited.get(i));
		}
		
		// set the record of this graph
		this.graph = g;
		
		// reset the current cost to the initial_cost 
		this.currentCost = initial_cost;
		
		// sign the strategy to the getting in one
		this.strategy = strategy;
	}
	
	public State(ArrayList<Shipment> ufs,Graph g,  Strategy strategy , ArrayList<Vertex> initial_history) {
		// calling the big constructor to initial the fresh object
		this(ufs,g,strategy,initial_history,0);
	}



	/**
	 * @return the visited
	 */
	public ArrayList<Vertex> getVisited() {
		return visited;
	}

	public Vertex getCurrentVertex() {
		// get the current vertex this ship is on
		return visited.get(visited.size()-1);
	}
	

	/**
	 * @return the unfinishShipment
	 */
	public ArrayList<Shipment> getUnfinishShipment() {
		return unfinishShipment;
	}

	/**
	 * 
	 * @param ship
	 */
	public void finishShipment(Shipment ship) {
		if (!ship.getFrom().equals(this.getCurrentVertex())) {
			// current vertex is not on the shipment's start location
			// try to reach the location
			this.addCurrentCost(
				this.graph.getEdgeCost(
					this.getCurrentVertex(), ship.getFrom()
				)
			);

			// get to the start location of this shipment
			this.visited.add(ship.getFrom());
		}
		// pop this shipment from not finish list
		this.unfinishShipment.remove(ship);
		// add up the transfer cost of finish this shipment
		this.addCurrentCost(ship.getCost());
		// get to the end of this shipment
		this.visited.add(ship.getTo());
	}
	
	
	/**
	 * @return the currentCost
	 */
	public int getCurrentCost() {
		return currentCost;
	}

	/**
	 * @param currentCost 
	 * add up the current cost
	 */
	public void addCurrentCost(int currentCost) {
		this.currentCost += currentCost;
	}

	/**
	 * @return the strategy
	 */
	public Strategy getStrategy() {
		return strategy;
	}

	/**
	 * @return the graph
	 */
	public Graph getGraph() {
		return graph;
	}

	@Override
	public int compareTo(State o) {
		// compare by the current cost + heuristic function cost
		return (this.getCurrentCost() + strategy.h(unfinishShipment, graph,getCurrentVertex()))
				- (o.getCurrentCost() + strategy.h (o.getUnfinishShipment(), o.getGraph(),o.getCurrentVertex()));
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected State clone() throws CloneNotSupportedException {
		// perform a deep copy to the essential values
		// by create a new object by all of this state's 
		// information
		State cp = new State(this.getUnfinishShipment(),this.graph, this.strategy,
				this.visited, this.currentCost);
		
		// return this new object
		return cp;
	}
	
}
