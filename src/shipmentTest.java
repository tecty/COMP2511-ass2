import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class shipmentTest {

	@Test
	void testCreateShipment	() {
		Vertex v1 = new Vertex("hello",10);
		Vertex v2 = new Vertex("hello2",10);
		Shipment ship = new Shipment(v1, v2, 15);
		
		assertEquals(15, ship.getCost());
		assertEquals("hello", ship.getFrom().getName());
		assertEquals("hello2", ship.getTo().getName());
	}

}
