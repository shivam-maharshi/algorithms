package ds;

import java.util.List;

/**
 * Standard representation of a Node. Should remove adjNodes from it.
 * 
 * @author shivam.maharshi
 */
public class Node {
	
	private int id;
	private int level;
	private State state;
	private List<Node> adjNodes;

	public Node(int id) {
		this(id, null);
	}

	public Node(int id, List<Node> nodes) {
		this.id = id;
		this.adjNodes = nodes;
		this.level = 0;
		this.state = State.UNVISITED;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public List<Node> getAdjNodes() {
		return adjNodes;
	}

	public void setAdjNodes(List<Node> adjNodes) {
		this.adjNodes = adjNodes;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
