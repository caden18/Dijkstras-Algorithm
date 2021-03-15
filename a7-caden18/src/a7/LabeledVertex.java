package a7;

public class LabeledVertex implements Vertex {

	private String _label;
	private Vertex _path_from_source;
	private int _distance_from_source;
	private boolean _is_known_;
	
	public LabeledVertex(String label) {
		if (label == null) {
			throw new IllegalArgumentException();
		}
		
		_label = label;		
		_path_from_source = null;
		_distance_from_source = Integer.MAX_VALUE;
		_is_known_ = false;
	}
	
	@Override
	public String toString() {
		return _label;
	}
	
	public String getLabel() {
		return _label;
	}

	@Override
	public Vertex getPathFromSource() {
		if (_path_from_source == null) {
			throw new RuntimeException("No path from source");
		}
		
		if (_path_from_source == this) {
			// Null result used to indicate we are at the source.
			return null;
		}
		
		return _path_from_source;
	}

	@Override
	public void setPathFromSource(Vertex v, int weight) {
		_path_from_source = v;
		if (v != null) {
			if (v == this) {
				_distance_from_source = 0;
			} else {
				_distance_from_source = v.getDistanceFromSource() + weight;
			}
		} 			
	}
	
	public void zeroPathFromSource() {
		_distance_from_source = 0;
		return;
	}

	@Override
	public int getDistanceFromSource() {
		if (_path_from_source == null) {
			throw new RuntimeException("No path from source");
		}
		return _distance_from_source;
	}

	@Override
	public boolean hasPathFromSource() {
		return _path_from_source != null;
	}
	
	public void setKnown() {
		_is_known_ = true;
		return;
	}
	
	public boolean isKnown() {
		return _is_known_;
	}


}
