package MyCode;

import ADT.Digraph;
import ADT.Edge;
import ADT.Vertex;

public class CP11_Malla extends Digraph<String,String>{
	public CP11_Malla() {
		super();
	}
	public Vertex<String> addCurso(String g) {
		return insertVertex(g);
	}
	public Edge<String> addPrerrequisito(Vertex<String> materia,Vertex<String>prerrequisito){
		return insertEdge(prerrequisito,materia,prerrequisito.getElement()+"-->"+materia.getElement()); //1 constante para todos los edges
	}
	public void tomarCursos() {
		System.out.println("Cursos ordenados de acuerdo a los prerrequisitos");
		for (Vertex<String> i: topologicalSort(this)) {
			System.out.println("Curso: "+i.getElement());
		}
	}
}
