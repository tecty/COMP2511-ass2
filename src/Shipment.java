
public class Shipment {
	private final Vertex from;
	private final Vertex to;
	private final int cost;
	public Shipment(Vertex from, Vertex to, int cost) {
		this.from = from;
		this.to   = to;
		this.cost = cost;
	}
	/**
	 * @return the from vertex
	 */
	public Vertex getFrom() {
		return from;
	}
	/**
	 * @return the to vertex
	 */
	public Vertex getTo() {
		return to;
	}
	/**
	 * @return the cost vertex
	 */
	public int getCost() {
		return cost;
	}
	
	
	
}
