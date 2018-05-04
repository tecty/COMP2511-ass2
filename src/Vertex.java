/**
 * Data model store the basic information about a vertex.
 * @author tecty
 *
 */
public class Vertex {
	private final String name;
	private final int refuelCost;
	/**
	 * Initial the vertex by given a name and the refuel cost.
	 * @param name Name of this vertex.
	 * @param cost Cost of refuel on this location.
	 */
	public Vertex(String name, int cost) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.refuelCost = cost;
	}
	/**
	 * Get the name of this location.
	 * @return the name Name of this vertex.
	 */
	public String getName() {
		return name;
	}
	/**
	 * Get the refuel cost of this location.
	 * @return the refuel_cost Refuel cost of this location.
	 */
	public int getRefuelCost() {
		return refuelCost;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == this) {
			return true;
		}
		else {
			Vertex v = (Vertex) obj ; 
			if (v.getName().equals(this.getName()) && 
				v.getRefuelCost() == this.getRefuelCost()) {
				return true;
			}
		}
		return false;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}
	
}
