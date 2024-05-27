package MyCode;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import ADT.AdjacencyMapGraph;
import ADT.Edge;
import ADT.Entry;
import ADT.Graph;
import ADT.Map;
import ADT.Vertex;
import ADT.PositionalList;
import ADT.ProbeHashMap;

public class CP10_Grafo1 extends AdjacencyMapGraph<String, Integer> {
	public CP10_Grafo1() {
		super(false); //no dirigido
	}
	public static void camino(AdjacencyMapGraph<String,Integer>g,Vertex<String>origen,Vertex<String>destino) {
		Map<Vertex<String>,Edge<Integer>> bfs=AdjacencyMapGraph.BFSComplete(g);
	}
	public void printDFS() {
		System.out.println("--DFS--");
		Map<Vertex<String>,Edge<Integer>> dfs=DFSComplete(this);
		for (Entry<Vertex<String>,Edge<Integer>> i: dfs.entrySet()) {
			System.out.println("Vertice: "+i.getKey().getElement()+" Edge: "+i.getValue().getElement()+" Vértice: " +opposite(i.getKey(),i.getValue()).getElement());
		}
	}
	public void printBFS() {
		Map<Vertex<String>,Edge<Integer>> bfs=BFSComplete(this);
		System.out.println("--BFS--");
//		for (Vertex<String> i: vertices()) {
//			System.out.println("Vertices: "+i.getElement()+" Edge: "+bfs.get(i).getElement()+" Vertice: "+opposite(i,bfs.get(i)).getElement());
//		}
		for (Entry<Vertex<String>,Edge<Integer>> i: bfs.entrySet()) {
			System.out.println("Vertice: "+i.getKey().getElement()+" Edge: "+i.getValue().getElement()+" Vértice: " +opposite(i.getKey(),i.getValue()).getElement());
		}
	}
	public void printCaminoMasCorto(Vertex<String>origen,Vertex<String>destino) {
		System.out.println("--Camino mas corto--");
		Map<Vertex<String>,Edge<Integer>> bfs=BFSComplete2(this,origen); //bfs comenzando en ese vértice
		for (Edge<Integer> i : constructPath(this, origen, destino, bfs)) {
			Vertex<String>[] vertices=endVertices(i);
			System.out.println("Vértice: "+vertices[0].getElement()+" --- "+"Vértice: "+vertices[1].getElement());
		}
	}
//	public static Map<Vertex<String>, Edge<Integer>> BFSComplete2(Graph<String, Integer> g, Vertex<String> startVertex) {
//	    Map<Vertex<String>, Edge<Integer>> forest = new ProbeHashMap<>();
//	    Set<Vertex<String>> known = new HashSet<>();
//	    BFS(g, startVertex, known, forest); // Iniciar BFS desde el vértice de inicio
//	    return forest;
//	}

}
