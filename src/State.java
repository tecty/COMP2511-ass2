import java.util.ArrayList;

/**
 * 
 */

/**
 * Data model to store the information of each possible
 * shipment order. Including the visit order, unfinished
 * shipment of current state. How much has spent to get to 
 * this state. The strategy to get the heuristic cost.
 * The graph this state is on.
 * @author tecty
 *
 */
public class State implements Comparable<State>, Cloneable{
	private ArrayList<Vertex> visited ;
	private ArrayList<Shipment> unfinishShipment;
	private int currentCost;
	private final Strategy strategy;
	private final Graph graph;
	
	/**
	 * Initial this state by given all information it need.
	 * @param ufs Current unfinished shipment.
	 * @param g The graph this state is perform.
	 * @param strategy Strategy to search the graph.
	 * @param visited Visit order of this state.
	 * @param initial_cost the The cost that get to this state.
	 */
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
	
	/**
	 * Initial this state by provide some essential information at start locatioin.
	 * @param ufs All required shipment.
	 * @param g The graph need to search on.
	 * @param strategy The strategy of this search.
	 * @param initial_history The visit history only have start location.
	 */
	public State(ArrayList<Shipment> ufs,Graph g,  Strategy strategy , ArrayList<Vertex> initial_history) {
		// calling the big constructor to initial the fresh object
		this(ufs,g,strategy,initial_history,0);
	}



	/**
	 * Return the vertex visited history.
	 * @return the visited ArrayList of history vertex in order.
	 */
	public ArrayList<Vertex> getVisited() {
		return visited;
	}

	/**
	 * The final vertex of this state.
	 * @return Current vertex of this state.
	 */
	public Vertex getCurrentVertex() {
		// get the current vertex this ship is on
		return visited.get(visited.size()-1);
	}
	

	/**
	 * All the unfinished shipment of current cost.
	 * @return the unfinishShipment ArrayList of this state.
	 */
	public ArrayList<Shipment> getUnfinishShipment() {
		return unfinishShipment;
	}

	/**
	 * Try to finish this shipment in this state. 
	 * @param ship The shipment need to be finish.
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
	 * The current cost of reaching this state.
	 * @return the currentCost Cost of reach this state.
	 */
	public int getCurrentCost() {
		return currentCost;
	}

	/**
	 * Add up the current cost.
	 * @param currentCost Current cost of getting this state. 
	 */
	public void addCurrentCost(int currentCost) {
		this.currentCost += currentCost;
	}

	/**
	 * The strategy perform this search.
	 * @return the strategy Strategy that perform this search.
	 */
	public Strategy getStrategy() {
		return strategy;
	}

	/**
	 * Get the graph this state is on.
	 * @return the graph Graph of this state is on. 
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
