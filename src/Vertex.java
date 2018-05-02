
public class Vertex {
	private final String name;
	private final int refuel_cost;
	/**
	 * 
	 * @param name
	 * @param cost
	 */
	public Vertex(String name, int cost) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.refuel_cost = cost;
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
	public int getRefuel_cost() {
		return refuel_cost;
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
				v.getRefuel_cost() == this.getRefuel_cost()) {
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
