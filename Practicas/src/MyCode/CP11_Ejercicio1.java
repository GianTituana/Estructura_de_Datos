package MyCode;

import ADT.AdjacencyMapGraph;
import ADT.Vertex;
import ADT.Digraph;
import ADT.Edge;

public class CP11_Ejercicio1 extends Digraph<String,String>{
	public CP11_Ejercicio1() {
		super();
	}
	public void isDAG() {
		if(topologicalSort(this)!=null && topologicalSort(this).size()==numVertices()) {
			System.out.println("G es un DAG"); //para ser un DAG debe tener la misma cantidad de vértices
		}
		else {
			System.out.println("G no es un DAG");
		}
	}
	public void topologicalOrder() {
		for (Vertex<String> i: topologicalSort(this)) {
			System.out.println("Vértice: "+i.getElement());
		}
	}
	public void transitiveClosure() {
		transitiveClosure(this);
		for (Vertex<String> i: vertices()) {
			System.out.println("Vértice: "+i.getElement());
			for (Edge<String> j: outgoingEdges(i)) {
				if(j.getElement()==null) {
				System.out.println("Vértice destino: "+opposite(i, j).getElement());
				}
			}
			for (Edge<String> k: incomingEdges(i)) {
				if(k.getElement()==null) {
				System.out.println("Vértice origen: "+opposite(i, k).getElement());
				}
			}
			System.out.println();
		}
	}
	public void printVertices() {
		for (Vertex<String> i: vertices()) {
			System.out.println("Vértice: "+i.getElement());
			for (Edge<String> j: outgoingEdges(i)) {
				if(j.getElement()==null) {
				System.out.println("Vértice destino: "+opposite(i, j).getElement());
				}
			}
			for (Edge<String> k: incomingEdges(i)) {
				if(k.getElement()==null) {
				System.out.println("Vértice origen: "+opposite(i, k).getElement());
				}
			}
			System.out.println();
		}
	}
}
