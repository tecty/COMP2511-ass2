/**
 * 
 */

/**
 * Data model to store each shipment.
 * @author tecty
 *
 */
public class Shipment {
	
	private final Vertex from;
	private final Vertex to;
	private final int cost;
	/**
	 * Create a new shipment by specify its from-, to vertex and this
	 * shipment's total cost.
	 * @param from Shipment start location.
	 * @param to Shipment end location.
	 * @param cost The total cost of finish this shipment.
	 */
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
	 * Return the start location of this shipment.
	 * @return the from The start location's object.
	 */
	public Vertex getFrom() {
		return from;
	}
	/**
	 * Return the end location of this shipment.
	 * @return the to End location of this shipment.
	 */
	public Vertex getTo() {
		return to;
	}
	/**
	 * Get the total cost of finish this shipment.
	 * @return the cost Total cost of finish this shipment.
	 */
	public int getCost() {
		return cost;
	}
	
	
}
