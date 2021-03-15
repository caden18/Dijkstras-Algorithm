package a7;

import java.util.List;
import java.util.Set;

public interface DirectedGraph {

	void addVertex(Vertex v);
	void removeVertex(Vertex v);
	boolean hasVertex(Vertex v);
	Vertex[] getAdjacent(Vertex v);

	void addEdge(Vertex from, Vertex to, int weight);
	void removeEdge(Vertex from, Vertex to);
	boolean hasEdge(Vertex from, Vertex to);
	DirectedEdge findEdge(Vertex from, Vertex to);
	
	Set<Vertex> getVertices();
	Set<DirectedEdge> getEdges();
}
