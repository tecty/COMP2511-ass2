/**
 * 
 */

/**
 * @author tecty
 *
 */
public class Shipment {
	
	private final Vertex from;
	private final Vertex to;
	private final int cost;
	public Shipment(Vertex from, Vertex to, int cost) {
		// TODO Auto-generated constructor stub
		this.from = from;
		this.to =to;
		this.cost = cost;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (obj == this) {
			// address is same must be same shipment
			return true;
		}
		else {
			Shipment ship = (Shipment) obj;
			if (ship.getFrom().equals(this.getFrom()) &&
				ship.getTo().equals(this.getTo()) &&
				ship.getCost()== this.getCost()) {
				return true;
			}
		}
		return false;
	}
	/**
	 * @return the from
	 */
	public Vertex getFrom() {
		return from;
	}
	/**
	 * @return the to
	 */
	public Vertex getTo() {
		return to;
	}
	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}
	
	
}
