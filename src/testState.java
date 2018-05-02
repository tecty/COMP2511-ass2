import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.PriorityQueue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A simple test to test the functionality of state
 * @author tecty
 *
 */
class testState {
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
		
		// set up the shipment from 2 to 3
		ufs.add(new Shipment(v2, v3, graph.getEdgeCost(v2, v3)));		
	}
	@Test
	void testCreateState() {
		// set up the initial history 
		ArrayList<Vertex> init = new ArrayList<Vertex>();
		init.add(v1);
		// simple test
		State s = new State( ufs,graph ,new ZeroStrategy(), init);

		assertEquals(v1, s.getCurrentVertex());
		assertEquals(0, s.getCurrentCost());

		// because perform a deep copy, the address would be different
		assertEquals(1, s.getUnfinishShipment().size());
	}
	
	@Test
	void testFinishShipment() {
		// set up the initial history and a state 
		ArrayList<Vertex> init = new ArrayList<Vertex>();
		init.add(v1);
		State s = new State( ufs,graph ,new ZeroStrategy(), init);
	
		try {
			// the clone of the current state
			State scp = s.clone();
			// finish the only one shipment
			scp.finishShipment(ufs.get(0));
			// by calculation, the result should be 1+2 +10 +20 =33
			assertEquals(33, scp.getCurrentCost());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test
	void testFinishShipment2() {
		// set up the initial history and a state 
		ArrayList<Vertex> init = new ArrayList<Vertex>();
		init.add(v2);
		State s = new State( ufs,graph ,new ZeroStrategy(), init);
	
		try {
			// the clone of the current state
			State scp = s.clone();
			// finish the only one shipment
			scp.finishShipment(ufs.get(0));
			// by calculation, the result should be 2  +20 =22
			assertEquals(22, scp.getCurrentCost());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test
	void testFinishShipment3() {
		// set up the initial history and a state 
		ArrayList<Vertex> init = new ArrayList<Vertex>();
		init.add(v3);
		State s = new State( ufs,graph ,new ZeroStrategy(), init);
	
		try {
			// the clone of the current state
			State scp = s.clone();
			// finish the only one shipment
			scp.finishShipment(ufs.get(0));
			// by calculation, the result should be 3+20+2+20=45
			assertEquals(45, scp.getCurrentCost());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test
	void testFinishShipment4() {
		// set up the initial history and a state 
		ArrayList<Vertex> init = new ArrayList<Vertex>();
		init.add(v4);
		State s = new State( ufs,graph ,new ZeroStrategy(), init);
	
		try {
			// the clone of the current state
			State scp = s.clone();
			// finish the only one shipment
			scp.finishShipment(ufs.get(0));
			// by calculation, the result should be 40+4+2+20 = 66
			assertEquals(66, scp.getCurrentCost());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	@Test
	void testPq() {
		// set up the initial history and a state 
		ArrayList<Vertex> init = new ArrayList<Vertex>();
		init.add(v4);
		State s = new State( ufs,graph ,new ZeroStrategy(), init);
	
		PriorityQueue<State> pq = new PriorityQueue<>();
		pq.add(s);
		
		
		try {
			// the clone of the current state
			State scp = s.clone();
			// finish the only one shipment
			scp.finishShipment(ufs.get(0));
			
			pq.add(scp);
			
			// i should pop the s then the scp 
			// since it would have less current cost
			assertEquals(s, pq.poll());
			assertEquals(scp, pq.poll());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
