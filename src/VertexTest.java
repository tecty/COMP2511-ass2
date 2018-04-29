import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VertexTest {

	@Test
	void testVertex() {
		Vertex v1 = new Vertex("hello",10);
		assertEquals("hello", v1.getName());
		assertEquals(10, v1.getRefuelCost());
	}

}
