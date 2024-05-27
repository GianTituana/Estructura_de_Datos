package MyCode;

import java.util.Random;
import ADT.DoublyLinkedList;
import ADT.Node;

public class CP4_Hospital {
	String nombre;
	String direccion;
	int num_pacientes; //pacientes diarios
	int count_remove=0;
	
	DoublyLinkedList<CP4_Paciente>pacientes=new DoublyLinkedList<>() ;
	DoublyLinkedList<CP4_Paciente>atendidos=new DoublyLinkedList<>() ;	
	
	public CP4_Hospital() {
		
	}
	public CP4_Hospital(String n,String d,int p) {
		nombre=n;
		direccion=d;
		num_pacientes=p;
	}
	public void addPaciente(CP4_Paciente p) { 
		if(p.getEdad()<10) {
			pacientes.addLast(p); //atender en el orden de llegada
		} 
		if(p.getEdad()>60) {
			pacientes.addLast(p);
		}
	}
	public void atenderPacientes() { 
		Random rand= new Random();
		Node<CP4_Paciente>nodo=pacientes.getHeader().getNext();
		System.out.printf("\n--Atendiendo pacientes--");
		for (int i = 0; i < pacientes.size()-count_remove; i++) {
			if(comprobarAtencion(nodo.getElement().getHistoria_clinica())) System.out.println("\n"+nodo.getElement().getNombre()+" ya fue atendido");
			else {
				if(nodo.getElement().getEdad()<10) {
					System.out.printf("\n\nAplicando vacuna antipolio...");
					System.out.printf("\nNombre: "+nodo.getElement().getNombre());
					System.out.printf("\n#Historia clínica: "+nodo.getElement().getHistoria_clinica());
					System.out.printf("\nEdad: "+nodo.getElement().getEdad());
					System.out.printf("\nSexo: "+nodo.getElement().getSexo());				
				}
				else {
					System.out.printf("\n\nControl de hipertensión arterial...");
					System.out.printf("\nNombre: "+nodo.getElement().getNombre());
					System.out.printf("\n#Historia clínica: "+nodo.getElement().getHistoria_clinica());
					System.out.printf("\nEdad: "+nodo.getElement().getEdad());
					System.out.printf("\nSexo: "+nodo.getElement().getSexo());				
					System.out.printf("\nSístole: "+rand.nextInt(100, 130));				
					System.out.printf("\nDiástole: "+rand.nextInt(70, 90));				
				}	
				atendidos.addLast(nodo.getElement());
			}
			nodo=nodo.getNext();
		}
	}
	public void eliminarPaciente(int p) { //eliminar de pacientes y de atendidos 
		Node<CP4_Paciente>nodo=pacientes.getHeader().getNext();
		for (int i = 0; i < pacientes.size()-count_remove; i++) {
			if(p==nodo.getElement().getHistoria_clinica()) {
				Node<CP4_Paciente> predecessor = nodo.getPrev();
				Node<CP4_Paciente> successor = nodo.getNext();
				predecessor.setNext(successor);
				successor.setPrev(predecessor);
				break;
			}
			nodo=nodo.getNext();
		}
		nodo=atendidos.getHeader().getNext();
		for (int i = 0; i < atendidos.size()-count_remove; i++) {
			if(p==nodo.getElement().getHistoria_clinica()) {
				Node<CP4_Paciente> predecessor = nodo.getPrev();
				Node<CP4_Paciente> successor = nodo.getNext();
				predecessor.setNext(successor);
				successor.setPrev(predecessor);
				break;
			}
			nodo=nodo.getNext();
		}
		count_remove++; //cantidad de veces removido
	}
	public void showAtendidos() {  
		Node<CP4_Paciente>nodo=atendidos.getHeader().getNext();
		System.out.printf("\n\n--Pacientes atendidos--\n\n");
		for (int i = 0; i < atendidos.size()-count_remove; i++) {
			System.out.println("Paciente "+(i+1));
			System.out.println("Nombre: "+nodo.getElement().getNombre());
			System.out.println("#Historia clínica: "+nodo.getElement().getHistoria_clinica());
			if(nodo.getElement().getEdad()<10) System.out.println("Tipo de atención: Vacuna antipolio");
			else System.out.println("Control de hipertensión arterial");
			System.out.println();
			nodo=nodo.getNext();
		}
	}
	private boolean comprobarAtencion(int num) {// para saber si ya ha sido atendido
		Node<CP4_Paciente>nodo=atendidos.getHeader().getNext();
		for (int i = 0; i < atendidos.size()-count_remove; i++) {
			if(num==nodo.getElement().getHistoria_clinica()) {
				return true;
			}
			nodo=nodo.getNext();
		}
		return false;
	}
	public void size() {
		System.out.println("pacientes.size"+pacientes.size());
	}
}
