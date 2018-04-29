
public class Shipment<E> {
	private final E from;
	private final E to;
	private final int cost;
	public Shipment(E from, E to, int cost) {
		this.from = from;
		this.to   = to;
		this.cost = cost;
	}
	/**
	 * @return the from vertex
	 */
	public E getFrom() {
		return from;
	}
	/**
	 * @return the to vertex
	 */
	public E getTo() {
		return to;
	}
	/**
	 * @return the cost vertex
	 */
	public int getCost() {
		return cost;
	}
	
	
	
}
