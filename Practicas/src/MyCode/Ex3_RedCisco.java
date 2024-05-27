package MyCode;

import ADT.AdjacencyMapGraph;
import ADT.Edge;
import ADT.Entry;
import ADT.Map;
import ADT.Vertex;

public class Ex3_RedCisco extends AdjacencyMapGraph<String,Integer>{
	public Ex3_RedCisco() {
		super(false);
	}
	public Vertex<String> addEquipo(String nombre) {
		return insertVertex(nombre);
	}
	public Edge<Integer> addConexion(Vertex<String>u,Vertex<String>v,Integer e){
		return insertEdge(u,v,e);
	}
//	public void caminoMasCorto(Vertex<String> origen) {
//		Map<Vertex<String>,Integer> rutas_mas_cortas=shortestPathLengths(this,origen);
//		Map<Vertex<String>,Edge<Integer>> ruta=spTree(this,origen,rutas_mas_cortas);
//		for (Entry<Vertex<String>,Edge<Integer>>j : ruta.entrySet()) {
//			System.out.printf("De "+j.getKey().getElement()+" a "+opposite(j.getKey(), j.getValue()).getElement()+"("+j.getValue().getElement()+" gb)");
//			System.out.println();
//		}
//		System.out.println();
//	}
	public void caminoMasCorto(Vertex<String> origen) {
		Map<Vertex<String>,Integer> rutas_mas_cortas=shortestPathLengths(this,origen);
		Map<Vertex<String>,Edge<Integer>> ruta=spTree(this,origen,rutas_mas_cortas);
		for (Entry<Vertex<String>,Edge<Integer>>j : ruta.entrySet()) {
			System.out.printf("De "+j.getKey().getElement()+" a "+opposite(j.getKey(), j.getValue()).getElement()+"("+j.getValue().getElement()+" gb)");
			System.out.println();
		}
		System.out.println();
	}
}
