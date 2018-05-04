import java.util.ArrayList;

/**
 * 
 */

/**
 * A implementation of graph. Store the vertices of this graph, and 
 * the edges cost between these vertices.
 * @author tecty
 *
 */
public class Graph {
	private ArrayList<Vertex> vertecies;
	private int[][] edges;
	/**
	 * create a new graph, initial the 
	 * data structure of this object.
	 */
	public Graph() {
		// initial both array
		vertecies = new ArrayList<>();
		edges = null;
	}
	/**
	 * Add a vertex into this graph
	 * @param v The vertex add to this graph.
	 */
	public void addVertex(Vertex v) {
		if(!vertecies.contains(v)) {
			// only add the element not in the current list
			vertecies.add(v);
		}
	};
	
	/**
	 * Add a brand new vertex by specify its name and refuelCost.
	 * All the added vertex has different name
	 * @param str The name of this vertex.
	 * @param refuelCost The refuel cost of this city.
	 */
	public void addVertex(String str, int refuelCost) {
		// call the original add vertex to do the job
		this.addVertex(new Vertex(str, refuelCost));
	}
	
	/**
	 * Return the vertex of specified name.
	 * All the vertex has different name.
	 * @param name The name of the vertex.
	 * @return The Vertex have same name.
	 */
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
	 * Add a edge between two vertex, and specify its cost on it.
	 * Assume once adding edge, the graph would not have more edges.
	 * @param v1 A vertex.
	 * @param v2 Another vertex.
	 * @param cost The cost of transfer between this edge.
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
	
	/**
	 * Add a edge by specify two vertex's name in this graph. Add on 
	 * a cost on it.
	 * @param v1 A vertex's name.
	 * @param v2 Another vertex's name.
	 * @param cost The cost of this edge.
	 */
	public void addEdgeByName(String v1, String v2, int cost) {
		// A helper function for main
		this.addEdges(getVertexByName(v1), getVertexByName(v2), cost);
	}
	
	/**
	 * Get the cost between two edges.
	 * Assume this graph is a complete graph.
	 * @param from
	 * @param to
	 * @return
	 */
	public int getEdgeCost(Vertex from, Vertex to) {
		// return the cost by searching the array.
		// also add up the refuel cost at the start point
		return edges[vertecies.indexOf(from)][vertecies.indexOf(to)] 
				+ from.getRefuelCost();
	}

}
