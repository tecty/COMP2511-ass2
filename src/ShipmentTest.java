

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShipmentTest {

	@Test
	void testShipmentCreate() {
		Vertex v1 = new Vertex("hello",10);
		Vertex v2 = new Vertex("hello2",10);
		
		Shipment ship = new Shipment(v1,v2,20);
		
		assertEquals(v1, ship.getFrom() );
		assertEquals(v2, ship.getTo() );
		assertEquals(20, ship.getCost());
	}
	
	@Test
	void testEquals() {
		Vertex v1 = new Vertex("hello",10);
		Vertex v2 = new Vertex("hello2",10);
		
		Shipment ship = new Shipment(v1,v2,20);
		Shipment ship2 = new Shipment(v1,v2,20);
		
		assertEquals(true, ship.equals(ship2));
		assertEquals(true, ship.equals(ship));
	}

}
