import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSearchGraph {

	private Graph graph;
	private ArrayList<Shipment> ufs;
	
	private Vertex v1;
	private Vertex v2;
	private Vertex v3;
	private Vertex v4;
	
	@BeforeEach
	private void SetUp() {
		this.graph = new Graph();
		this.ufs = new ArrayList<Shipment>();
		
		// set up the vertices
		v1 = new Vertex("hello1", 1);
		v2 = new Vertex("hello2", 2);
		v3 = new Vertex("hello3", 3);
		v4 = new Vertex("hello4", 4);
		
		// add the vertex to graph
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		
		// set up the edges's cost 
		graph.addEdges(v1, v2, 10);
		graph.addEdges(v2, v3, 20);
		graph.addEdges(v3, v4, 30);
		graph.addEdges(v2, v4, 40);
		graph.addEdges(v1, v3, 50);
		
		// set up the shipment from 2 to 3
		ufs.add(new Shipment(v2, v3, graph.getEdgeCost(v2, v3)));
		ufs.add(new Shipment(v3, v2, graph.getEdgeCost(v3, v2)));
	}
	
	@Test
	void testSearch() {
		SearchGraph sg = new SearchGraph(graph, new ZeroStrategy(), v1);
		
		sg.addRequireShipment(new Shipment(v2, v3, graph.getEdgeCost(v2, v3)));
		sg.addRequireShipment(new Shipment(v3, v2, graph.getEdgeCost(v3, v2)));
		// the optimal path should be be v1-v2-v3 -v2
		State s = sg.doSearch(); 
		
		ArrayList<Vertex> history = s.getVisited();
		assertEquals(4, history.size());
		assertEquals(v1, history.get(0));
		assertEquals(v2, history.get(1));
		assertEquals(v3, history.get(2));
		assertEquals(v2, history.get(3));
	}
	@Test
	void testSearchByRemainShipStrategy() {
		SearchGraph sg = new SearchGraph(graph, new ZeroStrategy(), v1);
		
		sg.addRequireShipment(new Shipment(v2, v3, graph.getEdgeCost(v2, v3)));
		sg.addRequireShipment(new Shipment(v3, v2, graph.getEdgeCost(v3, v2)));
		// the optimal path should be be v1-v2-v3 -v2
		State s = sg.doSearch(); 
		
		ArrayList<Vertex> history = s.getVisited();
		assertEquals(4, history.size());
		assertEquals(v1, history.get(0));
		assertEquals(v2, history.get(1));
		assertEquals(v3, history.get(2));
		assertEquals(v2, history.get(3));
	}
	
}
