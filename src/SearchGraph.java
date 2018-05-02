import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 
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
	public void addRequireShipment(Shipment ship) {
		this.requireShipment.add(ship);
	}
	public void addRequireShipment(String v1, String v2) {
		Vertex from = graph.getVertexByName(v1); 
		Vertex to = graph.getVertexByName(v2);
		
		this.requireShipment.add(
				new Shipment(
						from, to , graph.getEdgeCost(from, to)
				)
		);
	}
	
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
	
	public int getCounter() {
		return counter;
	}
	
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
