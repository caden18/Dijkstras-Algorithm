package a7;

import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class DirectedGraphImpl implements DirectedGraph {

	private Map<Vertex, List<DirectedEdge>> _adj_lists;
	
	public DirectedGraphImpl() {
		_adj_lists = new HashMap<Vertex, List<DirectedEdge>>();
	}

	@Override
	public void addVertex(Vertex v) {
		if (hasVertex(v)) {
			// Already in the graph.
			return;
		}
		
		_adj_lists.put(v, new ArrayList<DirectedEdge>());
	}

	@Override
	public void removeVertex(Vertex v) {
		
		_adj_lists.remove(v);
		
		for (Vertex other : _adj_lists.keySet()) {
			removeEdge(other, v);
		}
	}

	@Override
	public boolean hasVertex(Vertex v) {
		return _adj_lists.containsKey(v);
	}
	
	@Override
	public Vertex[] getAdjacent(Vertex v) {
		
		List<DirectedEdge> outbound_edges = _adj_lists.get(v);
		Vertex[] adjacent = new Vertex[outbound_edges.size()];
		for (int i=0; i<outbound_edges.size(); i++) {
			adjacent[i] = outbound_edges.get(i).getDestination();
		}
		return adjacent;
	}


	@Override
	public void addEdge(Vertex from, Vertex to, int weight) {
		
		if (!hasVertex(from) || !hasVertex(to)) {
			throw new IllegalArgumentException("Either from or to is not in graph");
		}
		
		if (hasEdge(from, to)) {
			return;
		}
		
		_adj_lists.get(from).add(new DirectedEdgeImpl(from, to, weight));
	}

	@Override
	public void removeEdge(Vertex from, Vertex to) {
		DirectedEdge edge = findEdge(from, to);
		
		if (edge != null) {
			_adj_lists.get(from).remove(edge);
		}
	}

	@Override
	public boolean hasEdge(Vertex from, Vertex to) {
		return findEdge(from, to) != null;
	}

	@Override
	public DirectedEdge findEdge(Vertex from, Vertex to) {
		if (!hasVertex(from) || !hasVertex(to)) {
			return null;
		}

		List<DirectedEdge> edge_list = _adj_lists.get(from);
		
		for(DirectedEdge e : edge_list) {
			if (e.getDestination() == to) {
				return e;
			}
		}
		return null;
	}
	
	
	@Override
	public Set<Vertex> getVertices() {
		return _adj_lists.keySet();
	}

	@Override
	public Set<DirectedEdge> getEdges() {
		
		Set<DirectedEdge> result = new HashSet<DirectedEdge>();
		for (List<DirectedEdge> edge_list : _adj_lists.values()) {
			for (DirectedEdge e : edge_list) {
				result.add(e);
			}
		}
		return result;
	}

}
