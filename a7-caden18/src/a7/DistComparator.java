package a7;

import java.util.Comparator;

public class DistComparator implements Comparator <Vertex> {
	
	public int compare(Vertex a, Vertex b) {
		if (a.getDistanceFromSource() < b.getDistanceFromSource()) {
			return -1;
		}
		if (a.getDistanceFromSource() > b.getDistanceFromSource()) {
			return 1;
		}
		return 0;
	}

}
