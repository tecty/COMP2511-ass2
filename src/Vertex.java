
public class Vertex {
	private final String name;
	private final int refuelCost;
	
	
	public Vertex(String name,int refuelCost) {
		// set the vertex's information.
		this.name = name;
		this.refuelCost = refuelCost;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the refuelCost
	 */
	public int getRefuelCost() {
		return refuelCost;
	}
}
