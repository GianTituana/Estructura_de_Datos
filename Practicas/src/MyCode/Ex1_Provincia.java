package MyCode;

import ADT.DoublyLinkedList;
import ADT.Node;

public class Ex1_Provincia {
	String nombre;
	DoublyLinkedList<Ex1_Farmacia>farmacias=new DoublyLinkedList<>();
	public Ex1_Provincia(String nombre) {
		this.nombre=nombre;
	}
	public void addFarmacia(Ex1_Farmacia f) {
		farmacias.addLast(f);
	}
	public void maxVentas(String nombre) { //Big(O) es O(n) porque tengo tres bucles for consecutivos así que solo tomo el big(O) del mayor
		Node<Ex1_Farmacia>nodo=farmacias.getHeader().getNext();
		DoublyLinkedList<Ex1_Farmacia>temp=new DoublyLinkedList<>(); //farmacias con ese medicamento
		int max=0;
		//encuentro las farmacias
		for (int i = 0; i < farmacias.size(); i++) {
			if(nodo.getElement().hasMedicamento(nombre)) {
				temp.addLast(nodo.getElement());
			}
			nodo=nodo.getNext();
		}
		//primero encuentro el maximo
		nodo=temp.getHeader().getNext();
		for (int i = 0; i < temp.size(); i++) {
			if(nodo.getElement().ventasMedicamento(nombre)>max) max=nodo.getElement().ventasMedicamento(nombre);
			nodo=nodo.getNext();
		}
		nodo=temp.getHeader().getNext();
		System.out.println("--Farmacia(s) con más unidades vendidas--");
		for (int i = 0; i < temp.size(); i++) {
				if(nodo.getElement().ventasMedicamento(nombre)==max) {
					System.out.println("Farmacia: "+nodo.getElement().getNombre());
			}
			nodo=nodo.getNext();
		}
	}
	public void ventasMedicamento(String nombre) { //Big(O) es O(n)porque solo tengo dos bucles for consecutivos
		Node<Ex1_Farmacia>nodo=farmacias.getHeader().getNext();
		DoublyLinkedList<Ex1_Farmacia>temp=new DoublyLinkedList<>(); //farmacias con ese medicamento
		int unidades=0;
		//encuentro las farmacias
		for (int i = 0; i < farmacias.size(); i++) {
			if(nodo.getElement().hasMedicamento(nombre)) {
				temp.addLast(nodo.getElement());
			}
			nodo=nodo.getNext();
		}
		nodo=temp.getHeader().getNext();
		for (int i = 0; i < temp.size(); i++) {
			unidades=unidades+nodo.getElement().ventasMedicamento(nombre);
			nodo=nodo.getNext();
		}
		System.out.println("Unidades de "+nombre+" vendidas en el año: "+unidades);
	}
	public void eliminarFarmacias(String nombre) { //bigO de O(n)
		Node<Ex1_Farmacia>nodo=farmacias.getHeader().getNext();
		DoublyLinkedList<Ex1_Farmacia>temp=new DoublyLinkedList<>(); //farmacias
		//encuentro las farmacias
				for (int i = 0; i < farmacias.size(); i++) {
					if(!nodo.getElement().hasMedicamento(nombre)) {
						temp.addLast(nodo.getElement());
					}
					nodo=nodo.getNext();
				}
		farmacias=temp; //así se cual es mi tamaño
	}
	public void insertarFarmacia(Ex1_Farmacia f) { //Big(O) es O(n) porque solo hay un bucle for
		DoublyLinkedList<Ex1_Farmacia>temp=new DoublyLinkedList<>();
		Node<Ex1_Farmacia>nodo=farmacias.getHeader().getNext();
		int posicion=(int)farmacias.size()/2;
		for (int i = 0; i < farmacias.size(); i++) {
			temp.addLast(nodo.getElement());
			if(i==posicion) temp.addLast(f);
			nodo=nodo.getNext();
		}
		farmacias=temp;
	}
	public void mostrarFarmacias() {
		System.out.println("---Farmacias en la Provincia---");
		Node<Ex1_Farmacia>nodo=farmacias.getHeader().getNext();
		for (int i = 0; i < farmacias.size(); i++) {
			System.out.println("Farmacia: "+nodo.getElement().getNombre());
			nodo=nodo.getNext();
		}
	}
		
	}
