package MyCode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ADT.AdjacencyMapGraph;
import ADT.Edge;
import ADT.Entry;
import ADT.Graph;
import ADT.LinkedPositionalList;
import ADT.LinkedQueue;
import ADT.Map;
import ADT.PositionalList;
import ADT.Vertex;

public class CP12_Hospital extends AdjacencyMapGraph<CP12_SalaHospital,Integer> {
	
	public CP12_Hospital() { //grafo no dirigido
		super(false);
	}
	public Vertex<CP12_SalaHospital> addSala(CP12_SalaHospital sala){
		return insertVertex(sala);
	}
	public Edge<Integer> addPasillo(Vertex<CP12_SalaHospital>u,Vertex<CP12_SalaHospital>v,Integer e){
		return insertEdge(u, v,e);
	}
	//literal b
	public void rutaMasRapida(Vertex<CP12_SalaHospital> origen) {
			System.out.println("Pasillos que deberías tomar para llegar a todas las salas en el menor tiempo posible partiendo desde: "+origen.getElement().getNombre());
			System.out.println();
			Map<Vertex<CP12_SalaHospital>,Integer> rutas_mas_cortas=shortestPathLengths(this,origen);
			Map<Vertex<CP12_SalaHospital>,Edge<Integer>> ruta=spTree(this,origen,rutas_mas_cortas);
			for (Entry<Vertex<CP12_SalaHospital>,Edge<Integer>>j : ruta.entrySet()) {
				System.out.printf("De "+j.getKey().getElement().getNombre()+" a "+opposite(j.getKey(), j.getValue()).getElement().getNombre()+"("+j.getValue().getElement()+" min)");
				System.out.println();
			}
			System.out.println();
	}
	//literal d
	public void rutaDeRegreso(Vertex<CP12_SalaHospital> origen) {
		System.out.println("--Camino alternativo de regreso--");
		List<Vertex<CP12_SalaHospital>> temp=findCycle(this,origen);
		for (int i=0; i< temp.size();i++) {
			System.out.println("Vértice: "+temp.get(i).getElement().getNombre());
		}
	}
	//literal e
	public void rutaDFS() {
		System.out.println("--Ruta DFS--");
		Map<Vertex<CP12_SalaHospital>,Edge<Integer>> dfs=DFSComplete(this);
		for (Entry<Vertex<CP12_SalaHospital>,Edge<Integer>> i: dfs.entrySet()) {
			System.out.println("Sala: "+i.getKey().getElement().getNombre()+" Sala: "+opposite(i.getKey(),i.getValue()).getElement().getNombre()+"(Tiempo: "+i.getValue().getElement()+")");
		}
	}
	public void rutaBFS() {
		System.out.println("--Ruta BFS--");
		Map<Vertex<CP12_SalaHospital>,Edge<Integer>> bfs=BFSComplete(this);
		for (Entry<Vertex<CP12_SalaHospital>,Edge<Integer>> i: bfs.entrySet()) {
			System.out.println("Sala: "+i.getKey().getElement().getNombre()+" Sala: "+opposite(i.getKey(),i.getValue()).getElement().getNombre()+"(Tiempo: "+i.getValue().getElement()+")");
		}
	}
	
//	public void rutasMasRapidas() {
//		for (Vertex<CP12_SalaHospital> i : vertices()) {
//			Map<Vertex<CP12_SalaHospital>,Integer> rutas_mas_cortas=shortestPathLengths(this,i);
//			System.out.print("Ruta más rápida desde: "+i.getElement().getNombre());
//			for (Entry<Vertex<CP12_SalaHospital>,Integer>j : rutas_mas_cortas.entrySet()) {
//				if(i.getElement().getNombre()!=j.getKey().getElement().getNombre()) {
//					System.out.println(" hasta: "+j.getKey().getElement().getNombre());
//					LinkedQueue<Vertex<CP12_SalaHospital>> ruta=visitarVertices(this,i,j.getKey(),new LinkedQueue<>(),j.getValue(),0); //suma al principio 0
//					imprimirRuta(ruta);
//				}
//			}
//			System.out.println();
//		}
//	}
//	public LinkedQueue<Vertex<CP12_SalaHospital>> visitarVertices(Graph<CP12_SalaHospital,Integer> g,Vertex<CP12_SalaHospital>origen,Vertex<CP12_SalaHospital>destino,LinkedQueue<Vertex<CP12_SalaHospital>> known,Integer shortestPathLength,Integer suma) { //suma=0 al inicio
//		for (Edge<Integer> e : g.outgoingEdges(origen)) {
//			 Vertex<CP12_SalaHospital> v=g.opposite(origen, e);
//			 known.enqueue(v);
//			 suma=suma+e.getElement();
//			 if(v==destino && suma==shortestPathLength) { //encontramos el path
//				 return known; //vertices en orden
//			 }
//			 else{ 
//				 return visitarVertices(g,v,destino,known,shortestPathLength,suma); //destino y shortestPathLenght son constantes
//			 }
//		 }
//		return null; //no se encontró nada
//	}

//	public void imprimirRuta(LinkedQueue<Vertex<CP12_SalaHospital>> ruta) {
//		for (int i=0;i<ruta.size();i++) {
//			System.out.println("Ir a la sala de: "+ruta.dequeue().getElement().getNombre());
//		}
//	}
	
}
