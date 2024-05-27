package MyCode;

import ADT.DoublyLinkedList;
import ADT.Node;

public class EI3_ListaHogar{
	DoublyLinkedList<EI3_Articulo>articulos=new DoublyLinkedList<>();
	int existentes=0;
	int faltantes=0;
	public EI3_ListaHogar() {
		// TODO Auto-generated constructor stub
	}
	public EI3_ListaHogar(DoublyLinkedList<EI3_Articulo>p) {
		articulos=p;
	}
	public void setArticulos(DoublyLinkedList<EI3_Articulo> articulos) {
		this.articulos = articulos;
	}
	public void addArticulo(EI3_Articulo item) {
		if(item.exist()) {
			articulos.addLast(item);
			existentes++;
		}
		else {
			articulos.addFirst(item); //si no existe tiene prioridad
			faltantes++;
		}
	}
	public void showArticulosFaltantes() {
		Node<EI3_Articulo>nodo=articulos.getHeader().getNext();
		for (int i = 0; i < faltantes; i++) {
			System.out.printf("\nNombre: "+nodo.getElement().getNombre()+"\nPrecio: %.2f",nodo.getElement().getPrecio());				
			nodo=nodo.getNext();
		}
	}
	public void showArticulosExistentes() {
		Node<EI3_Articulo>nodo=articulos.getTrailer().getPrev();
		for (int i = 0; i < existentes; i++) {
			System.out.printf("\nNombre: "+nodo.getElement().getNombre()+"\nPrecio: %.2f",nodo.getElement().getPrecio());				
			nodo=nodo.getPrev();
		}
	}
	public void showArticulos() {
		Node<EI3_Articulo>nodo=articulos.getHeader().getNext();
		for (int i = 0; i < articulos.size(); i++) {
			System.out.printf("\nNombre: "+nodo.getElement().getNombre()+"\nPrecio: %.2f",nodo.getElement().getPrecio());				
			nodo=nodo.getNext();
		}
	}
	public void removeArticulosExistentes() {
		EI3_Articulo removido=new EI3_Articulo("", 0, false);
		for (int i = 0; i < existentes; i++) {
			removido=articulos.removeLast();
			System.out.printf("\nRemoviendo...Nombre: "+removido.getNombre()+"\nPrecio: %.2f",removido.getPrecio());				
		}
	}
	public void removeArticulosFaltantes() {
		EI3_Articulo removido=new EI3_Articulo("", 0, false);
		for (int i = 0; i < faltantes; i++) {
			removido=articulos.removeFirst();
			System.out.printf("\nRemoviendo...Nombre: "+removido.getNombre()+"\nPrecio: %.2f",removido.getPrecio());				
		}
	}
}
