package MyCode;

import ADT.LinkedQueue;
import ADT.LinkedStack;
import ADT.Node;

import java.util.Random;

public class CP3_CadenaHilton{
	LinkedQueue<CP3_Solicitud>vip=new LinkedQueue<>(); //fifo
	LinkedQueue<CP3_Solicitud>ordinarios=new LinkedQueue<>(); //se almacenara de todos los hoteles
	public CP3_CadenaHilton() {
		
	}
	public void addSolicitud(CP3_Solicitud s) {
		if(!s.getTipoCliente()) vip.enqueue(s);
		else ordinarios.enqueue(s);
	}
	public void getInfo(int codigo) {
		boolean found=false;
		Node<CP3_Solicitud>solicitud=vip.getHead();
		for(int i=0;i<vip.size();i++) {
			if(solicitud.getElement().getCodigo()==codigo) {
				System.out.println("Codigo: "+solicitud.getElement().getCodigo());
				System.out.println("Cliente: "+solicitud.getElement().getNombre());
				System.out.println("Hotel: "+solicitud.getElement().getHotel());
				System.out.println("Tiempo estancia(días): "+solicitud.getElement().getEstancia());
				if(solicitud.getElement().getTipoCliente())System.out.println("Tipo cliente: Ordinario");
				else System.out.println("Tipo cliente: VIP");
				found=true;
				break;
			}
			solicitud=solicitud.getNext();
		}
		if(!found) {
			solicitud=ordinarios.getHead();			
			for(int i=0;i<ordinarios.size();i++) {
				if(solicitud.getElement().getCodigo()==codigo) {
					System.out.println("Codigo: "+solicitud.getElement().getCodigo());
					System.out.println("Cliente: "+solicitud.getElement().getNombre());
					System.out.println("Hotel: "+solicitud.getElement().getHotel());
					System.out.println("Tiempo estancia(días): "+solicitud.getElement().getEstancia());
					if(solicitud.getElement().getTipoCliente())System.out.println("Tipo cliente: Ordinario");
					else System.out.println("Tipo cliente: VIP");
					found=true;
					break;
				}
				solicitud=solicitud.getNext();
			}
		}
	}
	public LinkedQueue<CP3_Reservacion> getReservaciones(String hotel) { //aquí se hacen las asignaciones
		Random rand=new Random();
		Node<CP3_Solicitud>solicitud=vip.getHead();
		LinkedQueue<CP3_Reservacion>lista=new LinkedQueue<>();
		for(int i=0;i<vip.size();i++) {
			if(solicitud.getElement().getHotel().equals(hotel))
			lista.enqueue(new CP3_Reservacion(solicitud.getElement(),rand.nextInt(1,201)));
			solicitud=solicitud.getNext();
		}
		solicitud=ordinarios.getHead();
		for(int i=0;i<ordinarios.size();i++) {
			if(solicitud.getElement().getHotel().equals(hotel))
			lista.enqueue(new CP3_Reservacion(solicitud.getElement(),rand.nextInt(1,201)));
			solicitud=solicitud.getNext();
		}
		return lista;
	}
}
