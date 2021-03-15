package a7;

import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		/* Test program that calculates paths on graph from lecture slides */
		
		// Create a graph from lecture slides.
		Vertex a = new LabeledVertex("A");
		Vertex b = new LabeledVertex("B");
		Vertex c = new LabeledVertex("C");
		Vertex d = new LabeledVertex("D");
		Vertex e = new LabeledVertex("E");
		Vertex f = new LabeledVertex("F");
		Vertex g = new LabeledVertex("G");

		DirectedGraph dg = new DirectedGraphImpl();
		dg.addVertex(a);
		dg.addVertex(b);
		dg.addVertex(c);
		dg.addVertex(d);
		dg.addVertex(e);
		dg.addVertex(f);
		dg.addVertex(g);
		
		dg.addEdge(a,b,2);
		dg.addEdge(a,d,1);
		dg.addEdge(b,d,3);
		dg.addEdge(b,e,1);
		dg.addEdge(c,a,4);
		dg.addEdge(c,f,5);
		dg.addEdge(d,c,2);
		dg.addEdge(d,e,3);
		dg.addEdge(d,f,8);
		dg.addEdge(d,g,4);
		dg.addEdge(e,g,6);
		dg.addEdge(g,f,1);

		Map<Vertex, List<DirectedEdge>> dijkstra_result = Dijkstra.SSSP(dg, a);
		
		List<DirectedEdge> path_to_f = dijkstra_result.get(f);
		
		System.out.println("Path to F:");
		int path_weight = 0;
		for (DirectedEdge hop : path_to_f) {
			System.out.println(hop.getSource() + "->" + hop.getDestination() + " (" + hop.getWeight() + ")");
			path_weight += hop.getWeight();
		}
		System.out.println("Path weight: " + path_weight);
		
		/* The output of the above should be: 
		 * 
		 * Path to F:
		 * A->D (1)
         * D->G (4)
         * G->F (1)
         * Path weight: 6
		 */
	}

}
