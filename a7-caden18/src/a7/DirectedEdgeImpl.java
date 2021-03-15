package a7;

public class DirectedEdgeImpl implements DirectedEdge {

	private Vertex _source;
	private Vertex _destination;
	private int _weight;

	public DirectedEdgeImpl(Vertex source, Vertex destination, int weight) {
		_source = source;
		_destination = destination;
		_weight = weight;
	}
	
	public DirectedEdgeImpl(Vertex source, Vertex destination) {
		this(source, destination, 1);
	}

	@Override
	public Vertex getSource() {
		return _source;
	}

	@Override
	public Vertex getDestination() {
		return _destination;
	}

	@Override
	public int getWeight() {
		return _weight;
	}
	
}
