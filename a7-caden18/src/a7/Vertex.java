package a7;

public interface Vertex {

	Vertex getPathFromSource();
	default void clearPathToSource() {
		setPathFromSource(null, 0);
	}
	boolean hasPathFromSource();
	
	int getDistanceFromSource();
	void setPathFromSource(Vertex v, int weight);
	void setKnown();
	boolean isKnown();
	void zeroPathFromSource();
}
