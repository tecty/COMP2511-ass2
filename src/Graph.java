import java.util.ArrayList;

/**
 * 
 */

/**
 * @author tecty
 *
 */
public class Graph {
	private ArrayList<Vertex> vertecies;
	private int[][] edges;
	/**
	 * 
	 */
	public Graph() {
		// initial both array
		vertecies = new ArrayList<>();
		edges = null;
	}
	/**
	 * 
	 * @param v
	 */
	public void addVertex(Vertex v) {
		if(!vertecies.contains(v)) {
			// only add the element not in the current list
			vertecies.add(v);
		}
	};
	public void addVertex(String str, int refuel_cost) {
		// call the original add vertex to do the job
		this.addVertex(new Vertex(str, refuel_cost));
	}
	
	public Vertex getVertexByName(String name) {
		for(int i =0; i < vertecies.size(); i++) {
			if(name.equals(vertecies.get(i).getName())) {
				// name is equal, return this vertex
				return vertecies.get(i);
			}
		}
		// unable to find
		return null;
	}
	
	/**
	 * 
	 * @param v1
	 * @param v2
	 * @param cost
	 */
	public void addEdges(Vertex v1, Vertex v2, int cost) {
		if (this.edges == null) {
			// the edges list is not initialized
			// initial the list
			edges = new int[vertecies.size()][vertecies.size()];
		}
		
		// add the cost by the index to setup the edges;
		edges[vertecies.indexOf(v1)][vertecies.indexOf(v2)] = cost;
		edges[vertecies.indexOf(v2)][vertecies.indexOf(v1)] = cost;
	}
	
	public void addEdgeByName(String v1, String v2, int cost) {
		// A helper function for main
		this.addEdges(getVertexByName(v1), getVertexByName(v2), cost);
	}
	
	public int getEdgeCost(Vertex from, Vertex to) {
		// return the cost by searching the array.
		// also add up the refuel cost at the start point
		return edges[vertecies.indexOf(from)][vertecies.indexOf(to)] 
				+ from.getRefuelCost();
	}

}
