import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * The class handle the algorithm about searching graph.
 * Use bfs+A* search to do the serach.
 * @author tecty
 *
 */
public class SearchGraph {
	private PriorityQueue<State> pq;
	final private Graph graph;
	Strategy strategy;
	private ArrayList<Shipment> requireShipment;
	final private ArrayList<Vertex> initial;
	// a counter for test the performance 
	private int counter = 0;
	/**
	 * Initial this class by given a well constructed graph,
	 * a strategy use in search, the starting point.
	 * @param g The complete graph need to be search in.
	 * @param strategy Strategy use in search graph.
	 * @param start Start location in the graph.
	 */
	public SearchGraph(Graph g, Strategy strategy,
			Vertex start) {
		graph = g;
		this.strategy = strategy;
		// create the initial state
		this.initial = new ArrayList<>();
		this.initial.add(start);
		// assign the require shipment
		this.requireShipment = new ArrayList<>();
		
		// initial the priority queue for the pending list
		pq = new PriorityQueue<>();
	}
	/**
	 * Add all the required shipment that need to be plan.
	 * @param ship A shipment need to be finish.
	 */
	public void addRequireShipment(Shipment ship) {
		this.requireShipment.add(ship);
	}
	/**
	 * Add a require shipment by specify two vertex's name.
	 * @param fromName From vertex's name.
	 * @param toName To vertex's name.
	 */
	public void addRequireShipment(String fromName, String toName) {
		Vertex from = graph.getVertexByName(fromName); 
		Vertex to = graph.getVertexByName(toName);
		
		this.requireShipment.add(
				new Shipment(
						from, to , graph.getEdgeCost(from, to)
				)
		);
	}
	
	/**
	 * Reset the strategy if needed. Also reset all the progress of the 
	 * search, since the fundamental strategy is changed.
	 * @param st The need strategy to perform a search.
	 */
	public void setStrategy(Strategy st) {
		// refresh the strategy
		this.strategy = st;
		while(!pq.isEmpty()) {
			// pop out all the unused state
			pq.poll();
		}
		// reset the counter
		this.counter = 0;
	}
	
	/**
	 * Performance counter about this search.
	 * @return How many state has visited.
	 */
	public int getCounter() {
		return counter;
	}
	
	/**
	 * Do the search by the settings and graph.
	 * @return A finish state that has minimum cost.
	 */
	public State doSearch() {

		// add the initial state into the priority queue
		pq.add(new State(this.requireShipment, 
				this.graph, this.strategy, this.initial));
		while(!pq.isEmpty()) {
			counter ++;
			// pop out all the unused state
			State s  = pq.poll();
			ArrayList<Shipment> ufs = s.getUnfinishShipment();
			if (ufs.size() == 0) {
				// finish search :
				// the least cost state is in the queue is finished 
				
				return s;
			}
			// else:
			// expand and search
			for(int i = 0; i < ufs.size(); i++) {
				// expand all the possible search
				State scp;
				try {
					scp = s.clone();
					// search for every possible next shipment
					scp.finishShipment(ufs.get(i));
					
					// add this new state into priority queue.
					pq.add(scp);
				} catch (CloneNotSupportedException e) {
					// assume it would not get wrong
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	
}
