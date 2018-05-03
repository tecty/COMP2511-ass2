
public class Vertex {
	private final String name;
	private final int refuelCost;
	/**
	 * 
	 * @param name
	 * @param cost
	 */
	public Vertex(String name, int cost) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.refuelCost = cost;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @return the refuel_cost
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
