import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.PriorityQueue;

import org.junit.jupiter.api.Test;

class StateTest {

	@Test
	void testCreateState() {
		Vertex v1 = new Vertex("hello",10);
		ArrayList<Shipment> ship = new ArrayList<Shipment>();
		State<Vertex> s1 = new State<Vertex>(v1, ship);
		assertEquals(0, s1.getCost());;
	}
	
	@Test 
	void testAddVisited() {
		Vertex v1 = new Vertex("hello",10);
		Vertex v2 = new Vertex("hello",15);
		ArrayList<Shipment> ship = new ArrayList<Shipment>();
		State<Vertex> s1 = new State<Vertex>(v1,ship);

		// try to visit another place 
		s1.addVisited(v2, s1.getLastVertex().getRefuelCost() + 20);
		
		// add up the sum cost now must be 30
		assertEquals(30, s1.getCost());;
		
	}

	@Test 
	void testPriority() {
		// whether the priority queue always pop the least cost state?

		// some vertex is needed 
		Vertex v1 = new Vertex("hello",10);
		Vertex v2 = new Vertex("hello",15);
		ArrayList<Shipment> ship = new ArrayList<Shipment>();
		State<Vertex> s1 = new State<Vertex>(v1,ship);
		State<Vertex> s2 = new State<Vertex>(v1,ship);

		// try to visit another place only for s2
		s2.addVisited(v2, s1.getLastVertex().getRefuelCost() + 20);
		
		PriorityQueue<State<Vertex>> pq = new PriorityQueue<State<Vertex>>();
		
		// add both state into priority queue
		pq.add(s1);
		pq.add(s2);
		
		// now i should pop up the s1, then s2
		assertEquals(s1, pq.poll());
		assertEquals(s2, pq.poll());
	}
	
	@Test 
	void testClone() {
		// some vertex is needed 
		ArrayList<Shipment> ship = new ArrayList<Shipment>();
		Vertex v1 = new Vertex("hello",10);
		Vertex v2 = new Vertex("hello2",15);
		Vertex v3 = new Vertex("hello3",15);

		State<Vertex> s1 = new State<Vertex>(v1,ship);
		
		try {
			// should get v1 as its' initial 
			assertEquals(v1, s1.clone().getLastVertex());
			
			// add v2 and should get v2
			s1.addVisited(v2, 10);
			assertEquals(v2, s1.clone().getLastVertex());
			assertEquals(10, s1.clone().getCost());
			assertEquals(ship, s1.clone().getUnfinishShipment());
			
			// add v3 and should get v3
			s1.addVisited(v3, 10);
			assertEquals(v3, s1.clone().getLastVertex());
			assertEquals(20, s1.clone().getCost());
			assertEquals(ship, s1.clone().getUnfinishShipment());
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
