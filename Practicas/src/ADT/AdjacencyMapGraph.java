package ADT;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 * Developed for use with the book:
 *
 *    Data Structures and Algorithms in Java, Sixth Edition
 *    Michael T. Goodrich, Roberto Tamassia, and Michael H. Goldwasser
 *    John Wiley & Sons, 2014
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * An implementation for a graph structure using an adjacency map for each vertex.
 *
 * Every vertex stores an element of type V.
 * Every edge stores an element of type E.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class AdjacencyMapGraph<V,E> implements Graph<V,E> {
  private boolean isDirected;
  private PositionalList<Vertex<V>> vertices = new LinkedPositionalList<>();
  private PositionalList<Edge<E>> edges = new LinkedPositionalList<>();

  /**
   * Constructs an empty graph.
   * The parameter determines whether this is an undirected or directed graph.
   */
  public AdjacencyMapGraph(boolean directed) { isDirected = directed; }

  /** Returns the number of vertices of the graph */
  public int numVertices() { return vertices.size(); }

  /** Returns the vertices of the graph as an iterable collection */
  public Iterable<Vertex<V>> vertices() { return vertices; }

  /** Returns the number of edges of the graph */
  public int numEdges() { return edges.size(); }

  /** Returns the edges of the graph as an iterable collection */
  public Iterable<Edge<E>> edges() { return edges; }

  /**
   * Returns the number of edges for which vertex v is the origin.
   * Note that for an undirected graph, this is the same result
   * returned by inDegree(v).
   * @throws IllegalArgumentException if v is not a valid vertex
   */
  public int outDegree(Vertex<V> v) throws IllegalArgumentException {
    InnerVertex<V> vert = validate(v);
    return vert.getOutgoing().size();
  }

  /**
   * Returns an iterable collection of edges for which vertex v is the origin.
   * Note that for an undirected graph, this is the same result
   * returned by incomingEdges(v).
   * @throws IllegalArgumentException if v is not a valid vertex
   */
  public Iterable<Edge<E>> outgoingEdges(Vertex<V> v) throws IllegalArgumentException {
    InnerVertex<V> vert = validate(v);
    return vert.getOutgoing().values();   // edges are the values in the adjacency map
  }

  /**
   * Returns the number of edges for which vertex v is the destination.
   * Note that for an undirected graph, this is the same result
   * returned by outDegree(v).
   * @throws IllegalArgumentException if v is not a valid vertex
   */
  public int inDegree(Vertex<V> v) throws IllegalArgumentException {
    InnerVertex<V> vert = validate(v);
    return vert.getIncoming().size();
  }

  /**
   * Returns an iterable collection of edges for which vertex v is the destination.
   * Note that for an undirected graph, this is the same result
   * returned by outgoingEdges(v).
   * @throws IllegalArgumentException if v is not a valid vertex
   */
  public Iterable<Edge<E>> incomingEdges(Vertex<V> v) throws IllegalArgumentException {
    InnerVertex<V> vert = validate(v);
    return vert.getIncoming().values();   // edges are the values in the adjacency map
  }

  /** Returns the edge from u to v, or null if they are not adjacent. */
  public Edge<E> getEdge(Vertex<V> u, Vertex<V> v) throws IllegalArgumentException {
    InnerVertex<V> origin = validate(u);
    return origin.getOutgoing().get(v);    // will be null if no edge from u to v
  }

  /**
   * Returns the vertices of edge e as an array of length two.
   * If the graph is directed, the first vertex is the origin, and
   * the second is the destination.  If the graph is undirected, the
   * order is arbitrary.
   */
  public Vertex<V>[] endVertices(Edge<E> e) throws IllegalArgumentException {
    InnerEdge<E> edge = validate(e);
    return edge.getEndpoints();
  }

  /** Returns the vertex that is opposite vertex v on edge e. */
  public Vertex<V> opposite(Vertex<V> v, Edge<E> e)
                                               throws IllegalArgumentException {
    InnerEdge<E> edge = validate(e);
    Vertex<V>[] endpoints = edge.getEndpoints();
    if (endpoints[0] == v)
      return endpoints[1];
    else if (endpoints[1] == v)
      return endpoints[0];
    else
      throw new IllegalArgumentException("v is not incident to this edge");
  }

  /** Inserts and returns a new vertex with the given element. */
  public Vertex<V> insertVertex(V element) {
    InnerVertex<V> v = new InnerVertex<>(element, isDirected);
    v.setPosition(vertices.addLast(v));
    return v;
  }

  /**
   * Inserts and returns a new edge between vertices u and v, storing given element.
   *
   * @throws IllegalArgumentException if u or v are invalid vertices, or if an edge already exists between u and v.
   */
  public Edge<E> insertEdge(Vertex<V> u, Vertex<V> v, E element)
                                               throws IllegalArgumentException {
    if (getEdge(u,v) == null) {
      InnerEdge<E> e = new InnerEdge<>(u, v, element);
      e.setPosition(edges.addLast(e));
      InnerVertex<V> origin = validate(u);
      InnerVertex<V> dest = validate(v);
      origin.getOutgoing().put(v, e);
      dest.getIncoming().put(u, e);
      return e;
    } else
      throw new IllegalArgumentException("Edge from u to v exists");
  }

  /** Removes a vertex and all its incident edges from the graph. */
  public void removeVertex(Vertex<V> v) throws IllegalArgumentException {
    InnerVertex<V> vert = validate(v);
    // remove all incident edges from the graph
    for (Edge<E> e : vert.getOutgoing().values())
      removeEdge(e);
    for (Edge<E> e : vert.getIncoming().values())
      removeEdge(e);
    // remove this vertex from the list of vertices
    vertices.remove(vert.getPosition());
    vert.setPosition(null);             // invalidates the vertex
  }

  @SuppressWarnings({"unchecked"})
  /** Removes an edge from the graph. */
  public void removeEdge(Edge<E> e) throws IllegalArgumentException {
    InnerEdge<E> edge = validate(e);
    // remove this edge from vertices' adjacencies
    InnerVertex<V>[] verts = (InnerVertex<V>[]) edge.getEndpoints();
    verts[0].getOutgoing().remove(verts[1]);
    verts[1].getIncoming().remove(verts[0]);
    // remove this edge from the list of edges
    edges.remove(edge.getPosition());
    edge.setPosition(null);             // invalidates the edge
  }

  @SuppressWarnings({"unchecked"})
  private InnerVertex<V> validate(Vertex<V> v) {
    if (!(v instanceof InnerVertex)) throw new IllegalArgumentException("Invalid vertex");
    InnerVertex<V> vert = (InnerVertex<V>) v;     // safe cast
    if (!vert.validate(this)) throw new IllegalArgumentException("Invalid vertex");
    return vert;
  }

  @SuppressWarnings({"unchecked"})
  private InnerEdge<E> validate(Edge<E> e) {
    if (!(e instanceof InnerEdge)) throw new IllegalArgumentException("Invalid edge");
    InnerEdge<E> edge = (InnerEdge<E>) e;     // safe cast
    if (!edge.validate(this)) throw new IllegalArgumentException("Invalid edge");
    return edge;
  }

  //---------------- nested Vertex class ----------------
  /** A vertex of an adjacency map graph representation. */
  private class InnerVertex<V> implements Vertex<V> {
    private V element;
    private Position<Vertex<V>> pos;
    private Map<Vertex<V>, Edge<E>> outgoing, incoming;

    /** Constructs a new InnerVertex instance storing the given element. */
    public InnerVertex(V elem, boolean graphIsDirected) {
      element = elem;
      outgoing = new ProbeHashMap<>();
      if (graphIsDirected)
        incoming = new ProbeHashMap<>();
      else
        incoming = outgoing;    // if undirected, alias outgoing map
    }

    /** Validates that this vertex instance belongs to the given graph. */
    public boolean validate(Graph<V,E> graph) {
      return (AdjacencyMapGraph.this == graph && pos != null);
    }

    /** Returns the element associated with the vertex. */
    public V getElement() { return element; }

    /** Stores the position of this vertex within the graph's vertex list. */
    public void setPosition(Position<Vertex<V>> p) { pos = p; }

    /** Returns the position of this vertex within the graph's vertex list. */
    public Position<Vertex<V>> getPosition() { return pos; }

    /** Returns reference to the underlying map of outgoing edges. */
    public Map<Vertex<V>, Edge<E>> getOutgoing() { return outgoing; }

    /** Returns reference to the underlying map of incoming edges. */
    public Map<Vertex<V>, Edge<E>> getIncoming() { return incoming; }
  } //------------ end of InnerVertex class ------------

  //---------------- nested InnerEdge class ----------------
  /** An edge between two vertices. */
  private class InnerEdge<E> implements Edge<E> {
    private E element;
    private Position<Edge<E>> pos;
    private Vertex<V>[] endpoints;

    @SuppressWarnings({"unchecked"})
    /** Constructs InnerEdge instance from u to v, storing the given element. */
    public InnerEdge(Vertex<V> u, Vertex<V> v, E elem) {
      element = elem;
      endpoints = (Vertex<V>[]) new Vertex[]{u,v};  // array of length 2
    }

    /** Returns the element associated with the edge. */
    public E getElement() { return element; }

    /** Returns reference to the endpoint array. */
    public Vertex<V>[] getEndpoints() { return endpoints; }

    /** Validates that this edge instance belongs to the given graph. */
    public boolean validate(Graph<V,E> graph) {
      return AdjacencyMapGraph.this == graph && pos != null;
    }

    /** Stores the position of this edge within the graph's vertex list. */
    public void setPosition(Position<Edge<E>> p) { pos = p; }

    /** Returns the position of this edge within the graph's vertex list. */
    public Position<Edge<E>> getPosition() { return pos; }
  //------------ end of InnerEdge class ------------
   /** Performs depth-first search of Graph g starting at Vertex u. **/
 }
  public static <V,E> void DFS(Graph<V,E> g, Vertex<V> u,Set<Vertex<V>> known, Map<Vertex<V>,Edge<E>> forest) {
	  known.add(u);
	  // u has been discovered
	  for (Edge<E> e : g.outgoingEdges(u)) { // for every outgoing edge from u
	  Vertex<V> v = g.opposite(u, e);
	  if (!known.contains(v)) {
	  forest.put(v, e);
	  DFS(g, v, known, forest);
  		}
  	}
  }
  /* Returns an ordered list of edges comprising the directed path from u to v. */
 public static <V,E> PositionalList<Edge<E>> constructPath(Graph<V,E> g, Vertex<V> u, Vertex<V> v,
  Map<Vertex<V>,Edge<E>> forest) { 
  PositionalList<Edge<E>> path = new LinkedPositionalList<>();
  if (forest.get(v) != null) {
  Vertex<V> walk = v;
  while (walk != u) {
	  Edge<E> edge = forest.get(walk);
	  path.addFirst(edge);
	  walk = g.opposite(walk, edge);
  	}
  }
  return path;
}
 
 /*Performs breadth-first search of Graph g starting at Vertex u. */
 public static <V,E> void BFS(Graph<V,E> g, Vertex<V> s,Set<Vertex<V>> known, Map<Vertex<V>,Edge<E>> forest) {
	 PositionalList<Vertex<V>> level = new LinkedPositionalList<>();
	 known.add(s);
	 level.addLast(s);
	 while (!level.isEmpty()) {
	 // first level includes only s
	 PositionalList<Vertex<V>> nextLevel = new LinkedPositionalList<>();
	 for (Vertex<V> u: level)
	 for (Edge<E> e : g.outgoingEdges(u)) {
	 Vertex<V> v = g.opposite(u, e);
	 if (!known.contains(v)) {
	 known.add(v);
	 forest.put(v, e);
	 nextLevel.addLast(v);
	 }
	 }
	 level = nextLevel;
	 }
 }
 /*Performs DFS for the entire graph and returns the DFS forest as a map. */
 public static <V,E> Map<Vertex<V>,Edge<E>> DFSComplete(Graph<V,E> g) {
	 Set<Vertex<V>> known = new HashSet<>();
	 Map<Vertex<V>,Edge<E>> forest = new ProbeHashMap<>();
	 for (Vertex<V> u : g.vertices())
	 if (!known.contains(u))
	 DFS(g, u, known, forest);
	 return forest;
}
 public static <V, E> Map<Vertex<V>, Edge<E>> BFSComplete(Graph<V, E> g) {
     Map<Vertex<V>, Edge<E>> forest = new ProbeHashMap<>();
     Set<Vertex<V>> known = new HashSet<>();
     for (Vertex<V> u : g.vertices())
         if (!known.contains(u))
             BFS(g, u, known, forest);
     return forest;
 }
  /*Converts graph g into its transitive closure. */
public static <V,E> void transitiveClosure(Graph<V,E> g) {
 for (Vertex<V> k : g.vertices())
	 for (Vertex<V> i : g.vertices())
	 // verify that edge (i,k) exists in the partial closure
		 if (i != k && g.getEdge(i,k) != null)
			 for (Vertex<V> j : g.vertices())
			 // verify that edge (k,j) exists in the partial closure
				 if (i != j && j != k && g.getEdge(k,j) != null)
				 // if (i,j) not yet included, add it to the closure
					 if (g.getEdge(i,j) == null)
					 g.insertEdge(i, j, null);
}
/*Returns a list of verticies of directed acyclic graph g in topological order. */
public static <V,E> PositionalList<Vertex<V>> topologicalSort(Graph<V,E> g) {
	// list of vertices placed in topological order
	PositionalList<Vertex<V>> topo = new LinkedPositionalList<>();
	// container of vertices that have no remaining constraints
	Stack<Vertex<V>> ready = new LinkedStack<>();
	// map keeping track of remaining in-degree for each vertex
	Map<Vertex<V>, Integer> inCount = new ProbeHashMap<>();
	for (Vertex<V> u : g.vertices()) {
		inCount.put(u, g.inDegree(u));
		if (inCount.get(u) == 0)
		ready.push(u);
	}
	while (!ready.isEmpty()) {
		Vertex<V> u = ready.pop();
		topo.addLast(u);
		// initialize with actual in-degree
		// if u has no incoming edges,
		// it is free of constraints
		for (Edge<E> e : g.outgoingEdges(u)) { // consider all outgoing neighbors of u}
			Vertex<V> v = g.opposite(u, e);
			inCount.put(v,inCount.get(v)-1);
			if (inCount.get(v) == 0)
				ready.push(v);
		}
	}
return topo;
}
  
  /**
   * Returns a string representation of the graph.
   * This is used only for debugging; do not rely on the string representation.
   */
  public String toString() {
    StringBuilder sb = new StringBuilder();
//     sb.append("Edges:");
//     for (Edge<E> e : edges) {
//       Vertex<V>[] verts = endVertices(e);
//       sb.append(String.format(" (%s->%s, %s)", verts[0].getElement(), verts[1].getElement(), e.getElement()));
//     }
//     sb.append("\n");
    for (Vertex<V> v : vertices) {
      sb.append("Vertex " + v.getElement() + "\n");
      if (isDirected)
        sb.append(" [outgoing]");
      sb.append(" " + outDegree(v) + " adjacencies:");
      for (Edge<E> e: outgoingEdges(v))
        sb.append(String.format(" (%s, %s)", opposite(v,e).getElement(), e.getElement()));
      sb.append("\n");
      if (isDirected) {
        sb.append(" [incoming]");
        sb.append(" " + inDegree(v) + " adjacencies:");
        for (Edge<E> e: incomingEdges(v))
          sb.append(String.format(" (%s, %s)", opposite(v,e).getElement(), e.getElement()));
        sb.append("\n");
      }
    }
    return sb.toString();
  }
  public static<V>Map<Vertex<V>, Integer>
   shortestPathLengths(Graph<V,Integer>g,Vertex<V>src){
   //d.get(v) isupperboundondistancefromsrctov
   Map<Vertex<V>, Integer>d=new ProbeHashMap<>();
   //mapreachablevtoitsdvalue
   Map<Vertex<V>, Integer>cloud=new ProbeHashMap<>();
   //pqwillhaveverticesaselements,withd.get(v)askey
   AdaptablePriorityQueue<Integer,Vertex<V>>pq;
   pq=new HeapAdaptablePriorityQueue<>();
   //mapsfromvertextoitspqlocator
   Map<Vertex<V>,Entry<Integer,Vertex<V>>>pqTokens;
   pqTokens=new ProbeHashMap<>();
   //foreachvertexvofthegraph,addanentrytothepriorityqueue,with
   //thesourcehavingdistance0andallothershavinginfinitedistance
   for(Vertex<V>v:g.vertices()){
   if(v==src)
   d.put(v,0);
   else
   d.put(v, Integer.MAX_VALUE);
   pqTokens.put(v,pq.insert(d.get(v),v)); //saveentryfor futureupdates
   }
   //nowbeginaddingreachableverticestothecloud
   while(!pq.isEmpty()){
   Entry<Integer,Vertex<V>>entry=pq.removeMin();
   int key=entry.getKey();
   Vertex<V>u=entry.getValue();
   cloud.put(u,key); //this isactualdistancetou
   pqTokens.remove(u); //uisnolonger inpq
   for(Edge<Integer>e:g.outgoingEdges(u)){
   Vertex<V>v=g.opposite(u,e);
   if(cloud.get(v)==null){
   //performrelaxationsteponedge(u,v)
   int wgt=e.getElement();
   if(d.get(u)+wgt<d.get(v)){ //betterpathtov?
   d.put(v,d.get(u)+wgt); //updatethedistance
   pq.replaceKey(pqTokens.get(v),d.get(v)); //updatethepqentry
   }
   }
   }
   }
   return cloud; //thisonlyincludesreachablevertices
   }
  /*
  ∗ Reconstructs a shortest-path tree rooted at vertex s, given distance map d.
  ∗ The tree is represented as a map from each reachable vertex v (other than s)
  ∗ to the edge e = (u,v) that is used to reach v from its parent u in the tree.
  */
  public static <V> Map<Vertex<V>,Edge<Integer>>
	  spTree(Graph<V,Integer> g, Vertex<V> s, Map<Vertex<V>,Integer> d) {
	  Map<Vertex<V>,Edge<Integer>> tree = new ProbeHashMap<>();
	  for (Vertex<V> v : d.keySet())
	  if (v != s)
	  for (Edge<Integer> e : g.incomingEdges(v)) { // consider INCOMING edges
	  Vertex<V> u = g.opposite(v, e);
	  int wgt = e.getElement();
	  if (d.get(v) == d.get(u) + wgt)
	  tree.put(v, e);
	  }
	  return tree;
  }
  
  public static <V, E> List<Vertex<V>> findCycle(Graph<V, E> g, Vertex<V> origin) {
	    List<Vertex<V>> cycle = new ArrayList<>();
	    Set<Vertex<V>> visited = new HashSet<>();
	    dfsFindCycle(g, origin, origin, visited, cycle);
	    if (cycle.size() > 1) {
	        return cycle;
	    } else {
	        return null; // No se encontro ningun ciclo
	    }
	}

	private static <V, E> void dfsFindCycle(Graph<V, E> g, Vertex<V> u, Vertex<V> origin,
	                                         Set<Vertex<V>> visited, List<Vertex<V>> cycle) {
	    visited.add(u);
	    for (Edge<E> e : g.outgoingEdges(u)) {
	        Vertex<V> v = g.opposite(u, e);
	        if (v.equals(origin)) {
	            cycle.add(origin);
	            cycle.add(u);
	            return;
	        }
	        if (!visited.contains(v)) {
	            dfsFindCycle(g, v, origin, visited, cycle);
	            if (!cycle.isEmpty() && cycle.get(0).equals(origin)) {
	                cycle.add(u);
	                return;
	            }
	        }
	    }
	}
	public static <V, E> Map<Vertex<V>, Edge<E>> DFSComplete2(Graph<V, E> g, Vertex<V> startVertex) {
	    Map<Vertex<V>, Edge<E>> forest = new ProbeHashMap<>();
	    Set<Vertex<V>> known = new HashSet<>();
	    DFS(g, startVertex, known, forest); // Iniciar DFS desde el vértice de inicio
	    return forest;
	}
	public static <V, E> Map<Vertex<V>, Edge<E>> BFSComplete2(Graph<V, E> g, Vertex<V> startVertex) {
	    Map<Vertex<V>, Edge<E>> forest = new ProbeHashMap<>();
	    Set<Vertex<V>> known = new HashSet<>();
	    BFS(g, startVertex, known, forest); // Iniciar DFS desde el vértice de inicio
	    return forest;
	}
  
}