import java.util.ArrayList;

/**
 * 
 * @author tecty
 *
 */
public class State<E> implements Comparable<State<E>>, Cloneable{
	private int cost;
	private ArrayList<E> visited;
	private ArrayList<Shipment<E>>unfinishShipment;
	/**
	 * 
	 */
	public State(E initial, ArrayList<Shipment<E>> unfinishShipment) {
		// create a arraylist for visited vertex.
		this.visited =new ArrayList<E>();
		visited.add(initial);
		cost = 0;
		
		// add in the unfinished shipment
		this.unfinishShipment = unfinishShipment;
	}
	
	
	/**
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}

	/**
	 * @param cost the cost to set
	 */
	private void addCost(int cost) {
		// the cost only can go up 
		this.cost += cost;
	}


	/**
	 * @return the visited
	 */
	public ArrayList<E> getVisited() {
		return visited;
	}


	/**
	 * @param add a vertex into the visited 
	 */
	public void addVisited(E visited_vertex,int edgeCost) {	
		this.visited.add(visited_vertex);
		this.addCost(edgeCost);
	}
	
	
	public E getLastVertex() {
		// return the last vertex that store 
		return this.visited.get(this.visited.size()-1);
	}


	/**
	 * @return the unfinishShipment
	 */
	public ArrayList<Shipment<E>> getUnfinishShipment() {
		return unfinishShipment;
	}


//	/**
//	 * @param unfinishShipment the unfinishShipment to set
//	 */
//	public void setUnfinishShipment(ArrayList<Shipment<E>> unfinishShipment) {
//		this.unfinishShipment = unfinishShipment;
//	}


	@Override
	public int compareTo(State<E> another) {
		// TODO Auto-generated method stub
		return this.cost - another.getCost();
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected State<E> clone() throws CloneNotSupportedException {
		// do the deep copy while use clone
		// copy this state's state and unfinished 
		State<E> copy = new State<E>(this.visited.get(0),this.unfinishShipment);
		if (this.getVisited().size()>1) {
			// only the state have 2 or more node, they need to copy the visited state
			copy.addVisited(this.visited.get(1), this.getCost());
			if(this.getVisited().size()>2) {
				// copy the reset visited list
				// by adding no cost
				for (int i = 2; i < this.visited.size(); i++) {
					copy.addVisited(this.visited.get(i), 0);
				}
			}
			
		}
		
		// return the final copy one 
		return copy;
	}
	
	
}
