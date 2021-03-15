package a7;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Dijkstra {

	public static Map<Vertex, List<DirectedEdge>> SSSP(DirectedGraph g, Vertex src) {
	

		src.setPathFromSource(src, 0);
		Vertex _current_vertex_ = src;
		Comparator<Vertex> _comparator_ = new DistComparator();
		PriorityQueue<Vertex> _priority_queue_ = new PriorityQueue<Vertex>(_comparator_);
		_priority_queue_.add(src);

		while (_priority_queue_.size() != 0) {
			_current_vertex_.setKnown();
			Vertex[] _adjacent_vertices_ = g.getAdjacent(_current_vertex_);
			for (int i = 0; i < _adjacent_vertices_.length; i++) {
				if (!_adjacent_vertices_[i].isKnown()) {
					if (!_adjacent_vertices_[i].hasPathFromSource()) {
						_adjacent_vertices_[i].setPathFromSource(_current_vertex_, g.findEdge(_current_vertex_, _adjacent_vertices_[i]).getWeight());
						_priority_queue_.add(_adjacent_vertices_[i]);
					}
					if (_adjacent_vertices_[i].getDistanceFromSource() > g.findEdge(_current_vertex_, _adjacent_vertices_[i]).getWeight() + _current_vertex_.getDistanceFromSource()) {
						if (_adjacent_vertices_[i].getDistanceFromSource() == Integer.MAX_VALUE) {
							_adjacent_vertices_[i].zeroPathFromSource();
						}
						_adjacent_vertices_[i].setPathFromSource(_current_vertex_, g.findEdge(_current_vertex_, _adjacent_vertices_[i]).getWeight());
						_priority_queue_.add(_adjacent_vertices_[i]);
					}
				}
			}
			while (_priority_queue_.contains(_current_vertex_)) {
				_priority_queue_.remove(_current_vertex_);
			}
			if (_priority_queue_.size() != 0) {
				_current_vertex_ = _priority_queue_.peek();
			}
		}
		Map<Vertex, List<DirectedEdge>> _map_ = new HashMap<Vertex, List<DirectedEdge>>();
		Vertex[] _vertices_ = (Vertex[]) g.getVertices().toArray(new Vertex[g.getVertices().size()]);
		
		for (int i = 0; i < _vertices_.length; i++) {
			if (_vertices_[i].hasPathFromSource()) {
				List<DirectedEdge> _edge_list_ = new ArrayList<DirectedEdge>();
				Vertex _temp_ = _vertices_[i];
				while (_temp_.getPathFromSource() != null) {
					Vertex _previous_ = _temp_.getPathFromSource();
					_edge_list_.add(g.findEdge(_previous_, _temp_));
					_temp_ = _previous_;
				}
				Collections.reverse(_edge_list_);
				_map_.put(_vertices_[i], _edge_list_);
			}
		}
		return _map_;
	}
}
