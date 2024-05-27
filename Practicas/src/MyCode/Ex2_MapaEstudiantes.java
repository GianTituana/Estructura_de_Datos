package MyCode;

import ADT.AbstractSortedMap;
import ADT.Entrada;
import ADT.Entry;
import ADT.LinkedBinaryTree;
import ADT.Map;
import ADT.Position;
import ADT.TreeMap;
import ADT.MapEntry;
import ADT.Node;
import ADT.DoublyLinkedList;

public class Ex2_MapaEstudiantes {
	private DoublyLinkedList<MapEntry<Integer,Ex2_Estudiante>> mapa=new DoublyLinkedList<>();
	
	public Ex2_MapaEstudiantes() {
	}
	public void putEstudiante(Ex2_Estudiante est) {
		mapa.addLast(new MapEntry(est.getCodigo(),est)); //insercion O(1)
	}
	public Ex2_Estudiante getEstudiante(int it, int codigo) { //it me sirve para que salir del bucle si no existe el código, al usar
		//el metodo debería comenzar con it=0
		MapEntry<Integer,Ex2_Estudiante> temp=mapa.removeFirst();
		mapa.addLast(temp); //volver a ingresarlo, no perderlo y no alterar el tamaño de la lista
		if(it==mapa.size())return null; //estudiante no encontrado
		if(temp.getKey().equals(codigo)) {
			return temp.getValue();
		}
		else return getEstudiante(it+1,codigo);
	}
	public Ex2_Estudiante getMaxCodigo(int it,int mayor) { //en este caso mayor va a ser cero cuando use el metodo
		//asimismo iteracion permite saber si ya se recorrio todo el array deberia inicializarse con 0
		MapEntry<Integer,Ex2_Estudiante> temp=mapa.removeFirst();
		mapa.addLast(temp); 
		if(it==mapa.size())return getEstudiante(0,mayor); //mayor será el codigo maximo y busco ese estudiante
		else {
			if(temp.getKey().intValue()>mayor) return getMaxCodigo(it+1,temp.getKey().intValue());
			else return getMaxCodigo(it+1,mayor);
		}
	}
}
