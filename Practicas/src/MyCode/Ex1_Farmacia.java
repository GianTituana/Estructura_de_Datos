package MyCode;

import ADT.DoublyLinkedList;
import ADT.Node;

public class Ex1_Farmacia {
	String nombre;
	DoublyLinkedList<Ex1_Medicamento>medicinas=new DoublyLinkedList<Ex1_Medicamento>();
	Ex1_Medicamento medicina;
	double ventas;
	int unidades_vendidas;
	public Ex1_Farmacia(String nombre,Ex1_Medicamento medicina,int unidades_vendidas,double ventas) {
		this.nombre=nombre;
		this.medicina=medicina;
		this.ventas=ventas; //ventas anuales
		this.unidades_vendidas=unidades_vendidas;
	}
	public Ex1_Farmacia(String nombre,DoublyLinkedList<Ex1_Medicamento>medicinas,int unidades_vendidas,double ventas) {
		this.nombre=nombre;
		this.medicinas=medicinas;
		this.ventas=ventas; //ventas anuales
		this.unidades_vendidas=unidades_vendidas;
	}
	public String getNombre() {
		return nombre;
	}
	public Ex1_Medicamento getMedicina() {
		return medicina;
	}
	public double getVentas() {
		return ventas;
	}
	public int getUnidades_vendidas() {
		return unidades_vendidas;
	}
	public void addMedicamento(Ex1_Medicamento m) {
		medicinas.addLast(m);
	}
	public void setMedicinas(DoublyLinkedList<Ex1_Medicamento> medicinas) {
		this.medicinas = medicinas;
	}
	public boolean hasMedicamento(String nombre) {
		Node<Ex1_Medicamento>nodo=medicinas.getHeader().getNext();
		for (int i = 0; i < medicinas.size(); i++) {
			if(nodo.getElement().getNombre().equals(nombre)) {
				return true;
			}
			nodo=nodo.getNext();
		}
		return false;
	}
	public int ventasMedicamento(String nombre) {
		Node<Ex1_Medicamento>nodo=medicinas.getHeader().getNext();
		for (int i = 0; i < medicinas.size(); i++) {
			if(nodo.getElement().getNombre().equals(nombre)) {
				return nodo.getElement().getStock();
			}
			nodo=nodo.getNext();
		}
		return 0;
	}
}
