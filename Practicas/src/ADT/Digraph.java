package ADT;

public class Digraph<V,E> extends AdjacencyMapGraph<V,E> {

	public Digraph() {
		super(true);
	}
	
	// Converts graph g into its transitive closure
	public static <V,E> void transitiveClosure(Graph <V,E> g) {
		for (Vertex<V> k : g.vertices())
			for(Vertex<V> i : g.vertices())
				// verify that edge (i,k) exists in the partial closure
				if(i != k && g.getEdge(i, k) != null)
					for(Vertex<V> j : g.vertices())
						// verify that edge (k,j) exists in the partial closure
						if(i != j && j != k && g.getEdge(k, j) != null)
						// if (i,j) not yet included, add it to the closure
							if(g.getEdge(i, j) == null)
								g.insertEdge(i, j, null);
	}
			
	// Returns a list of verticies of directed acyclic graph g in topological order.
	public static <V,E> PositionalList<Vertex<V>> topologicalSort(Graph<V,E> g) {
		// list of vertices placed in topological order
		PositionalList<Vertex<V>> topo = new LinkedPositionalList<>( );
		// container of vertices that have no remaining constraints
		Stack<Vertex<V>> ready = new LinkedStack<>( );
		// map keeping track of remaining in-degree for each vertex
		Map<Vertex<V>, Integer> inCount = new ProbeHashMap<>( );
		
		for (Vertex<V> u : g.vertices( )) {
			inCount.put(u, g.inDegree(u)); // initialize with actual in-degree
			if (inCount.get(u) == 0) // if u has no incoming edges,
				ready.push(u); // it is free of constraints
		}
		
		while (!ready.isEmpty( )) {
			Vertex<V> u = ready.pop( );
			topo.addLast(u);
			for (Edge<E> e : g.outgoingEdges(u)) { // consider all outgoing neighbors of u
				Vertex<V> v = g.opposite(u, e);
				inCount.put(v, inCount.get(v) - 1); // v has one less constraint without u
				if (inCount.get(v) == 0)
					ready.push(v);
			}
		}
		return topo;
	}
}
