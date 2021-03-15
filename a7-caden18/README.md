# A7Starter

Implement Dijkstra's algorithm for single-source shortest path to all vertices by providing the code for the static function Dijkstra.SSSP. 

This method should return a Map with an entry for each vertex of the provided graph associated with a list of directed edges that represents the path of weighted directed edges from the specified source vertex. Only vertices that *have* a path from the source vertex should be included in the map. The graph provided may or may not be strongly connected and so there may be some vertices that do NOT have a path from the source vertex. The source vertex itself should be associated with an empty list indicating a 0-length path. 

The code provided is the same as the base code used in the Lec 22 examples with the following updates:

* The DirectedEdge interface now includes a getWeight() method.
* The DirectedEdgeImpl class that implements DirectedEdge now provides two constructors: 
    * one that accepts an integer weight, 
    * and one that defaults to a weight of 1.

You should not need to change any of these:

* DirectedEdge and DirectedEdgeImpl
* DirectedGraph and DirectedGraphImpl

If you would like to add additional functionality or state to any of these interfaces / classes, that is allowed as long as the existing constructors and methods are not modified. You may also create additional new interfaces / classes as you see fit.

You WILL have to change the design and implementation of these:

* Vertex and LabeledVertex

The versions of Vertex and LabeledVertex provided are appropriate for the unweighted SSSP algorithm from the lecture example but are not appropriate for Dijkstra's weighted SSSP algorithm.

However you change these, be sure to leave the declaration of the LabeledVertex constructor the same. Namely:

```
public LabeledVertex(String label)
```

Main contains an example program that replicates the example in the Lecture 22 slides. If your algorithm is operating correctly, you should get the following output:

```
Path to F:
A->D (1)
D->G (4)
G->F (1)
Path weight: 6
```

