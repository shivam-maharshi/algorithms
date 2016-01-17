package data.structures;

/**
 * Standard representation of an Edge.
 * 
 * @author shivam.maharshi
 */
public class Edge {
	int wieght;
	int src;
	int des;

	public Edge(int src, int des, int wieght) {
		this.src = src;
		this.des = des;
		this.wieght = wieght;
	}

	@Override
	public String toString() {
		return "Edge [wieght=" + wieght + ", src=" + src + ", des=" + des + "]";
	}

	public int getWieght() {
		return wieght;
	}

	public void setWieght(int wieght) {
		this.wieght = wieght;
	}

	public int getSrc() {
		return src;
	}

	public void setSrc(int src) {
		this.src = src;
	}

	public int getDes() {
		return des;
	}

	public void setDes(int des) {
		this.des = des;
	}

}
