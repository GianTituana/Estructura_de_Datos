//Gian Tituana,325991
import ADT.Edge;
import MyCode.CP10_Grafo1;
import MyCode.CP11_Ejercicio1;
import MyCode.CP11_Malla;
import MyCode.CP12_Hospital;
import MyCode.CP12_SalaHospital;
import MyCode.EI6_Calle;
import MyCode.EI6_Interseccion;
import MyCode.EI7_Puerto;
import ADT.LinkedQueue;
import ADT.AdjacencyListGraph;
import ADT.AdjacencyMapGraph;
import MyCode.CP8_Ejercicio1;
import MyCode.CP8_Persona;
import MyCode.CP8_Registro;
import MyCode.CP8_SistemaRegistro;
import MyCode.CP6_TreeParentesis;
import MyCode.CP7_BinaryExpressionTree;
import MyCode.CP5_Funciones;
import MyCode.CP6_BinaryExpressionTree;
import MyCode.CP7_Polinomio;
import MyCode.CP8_Cliente;
import ADT.LinkedStack;
import ADT.LinkedTree;
import ADT.Map;
import ADT.Node;
import ADT.Position;
import ADT.PositionalList;
import ADT.DoublyLinkedList;
import ADT.Entrada;
import ADT.Entry;
import ADT.LinkedBinaryTree;
import ADT.SinglyLinkedList;
import ADT.SplayTreeMap;
import ADT.UnsortedTableMap;
import ADT.Vertex;
import MyCode.CP2_TEstud;
import MyCode.CP2_TGrupo;
import MyCode.CP3_Funciones;
import MyCode.EI1_Persona;
import MyCode.EI2_WebPage;
import MyCode.EI3_ListaHogar;
import MyCode.EI3_Articulo;
import MyCode.CP3_Reservacion;
import MyCode.CP3_Solicitud;
import MyCode.Ex1_Farmacia;
import MyCode.CP4_Hospital;
import MyCode.Ex1_Medicamento;
import MyCode.Ex1_Provincia;
import MyCode.CP4_Paciente;
import MyCode.CP3_CadenaHilton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;		
import ADT.BinarySearchTree;
import ADT.DoubleHashMap;
import ADT.ChainHashMap;
import ADT.Digraph;
import ADT.Double2HashMap;
import ADT.ProbeHashMap;
import MyCode.Ex2_MapaEstudiantes;
import MyCode.Ex2_Estudiante;
import MyCode.Ex2_Usfq;
import MyCode.Ex3_RedCisco;
import MyCode.S1_Articulo;
import MyCode.S1_Tienda;

public class Main {
	public static void main(String[]args) {
		//EI1
//			Scanner scan=new Scanner(System.in);
//			//departamentos de la empresa, simplificado para dos casos
//			SinglyLinkedList<EI1_Persona>produccion=new SinglyLinkedList();	
//			SinglyLinkedList<EI1_Persona>ventas=new SinglyLinkedList();	
//			ArrayList<EI1_Persona>copiaproduccion=new ArrayList<>();	
//			ArrayList<EI1_Persona>copiaventas=new ArrayList<>();	
//			String nombre;
//			Long id;
//			boolean menu=true;
//			int opcion,opcion2;
//			System.out.println("---Bienvenido a coorporación La Favorita---");
//			while(menu) {
//				System.out.printf("--Menu de opciones--\n"+"1. Agregar trabajador"
//						+ "\n2. Buscar trabajador\n3. Salir\n");
//				opcion=scan.nextInt();
//				switch(opcion) {
//					case 1:
//						System.out.println("Nombre: ");
//						scan.nextLine();
//						nombre=scan.nextLine();
//						System.out.println("Id:");
//						id=scan.nextLong();
//						System.out.printf("Departamento 1.Ventas\t2.Produccion\n");
//						opcion2=scan.nextInt();
//						switch(opcion2) {
//						case 1:
//							ventas.addFirst(new EI1_Persona(nombre,id));
//							break;
//						case 2:
//							produccion.addFirst(new EI1_Persona(nombre,id));
//							break;
//						}
//						break;
//					case 2:
//						System.out.println("Id:");
//						id=scan.nextLong();
//						while(true){
//							if(!produccion.isEmpty()) {
//								if(produccion.first().getId().equals(id)) {
//									System.out.printf("---Datos del trabajador---\nNombre: "+produccion.first().getNombre()
//											+"\nId: "+id+"\nDepartamento: Produccion\n");
//									break;
//								}
//							}
//							if(!ventas.isEmpty()) {
//								if(ventas.first().getId().equals(id)) {
//									System.out.printf("---Datos del trabajador---\nNombre: "+ventas.first().getNombre()
//											+"\nId: "+id+"\nDepartamento: Ventas\n");
//									break;
//								}
//							}
//							copiaproduccion.add(produccion.first());
//							copiaventas.add(ventas.first());
//							produccion.removeFirst();
//							ventas.removeFirst();
//						}
//						//vuelvo a colocar los valores removidos en las listas iniciales
//						for(int i=0;i<copiaproduccion.size();i++) {
//							produccion.addLast(copiaproduccion.get(i));
//						}
//						for(int i=0;i<copiaventas.size();i++) {
//							ventas.addLast(copiaventas.get(i));
//						}
//						copiaproduccion.clear();
//						copiaventas.clear();
//						break;
//					case 3:
//						menu=false;
//						System.out.println("Adios...");
//						break;
//				}
//			}
		//EI2
		//LinkedStack and LinkedQueue Web Browser example
//		String nombre,url;
//		int opcion=0;
//		boolean menu=true;
//		Scanner scan=new Scanner(System.in);
//		LinkedStack<EI2_WebPage>visitadas=new LinkedStack<>();
//		LinkedQueue<EI2_WebPage>historial=new LinkedQueue<>();
//		while(menu) {
//			System.out.printf("--Web Browser--\n1.Ir a pagina web\n2.Regresar\n3.Mostrar y borrar historial\n4.Salir\n");
//			opcion=scan.nextInt();
//			switch(opcion) {
//			case 1:
//				System.out.println("Nombre de la página:");
//				scan.nextLine();
//				nombre=scan.nextLine();
//				System.out.println("Url de la página: ");
//				url=scan.nextLine();
//				visitadas.push(new EI2_WebPage(nombre,url));
//				historial.enqueue(new EI2_WebPage(nombre,url));
//				System.out.println("Llevandole a la pagina solicitada..."); //futura implementación
//				break;
//			case 2:
//				if(visitadas.size()>1) {
//					visitadas.pop();
//					System.out.println("Nombre de la página: "+visitadas.top().getNombre());
//					System.out.println("Url de la página: "+visitadas.top().getUrl());
//				}
//				else System.out.println("Ya no puede ir hacia atrás");
//				break;
//			case 3:
//				int size=historial.size();
//				if(historial.isEmpty()==true) {
//					System.out.println("No hay nada en el historial");
//				}
//				for(int i=0;i<size;i++) {
//					System.out.println("tamaño:"+historial.size());
//					System.out.println("Nombre de la página: "+historial.first().getNombre());
//					System.out.println("Url de la página: "+historial.first().getUrl());
//					historial.dequeue();
//				}
//				break;
//			case 4:
//				System.out.println("Adios");
//				menu=false;
//				break;
//			}
//		}
//		scan.close();
		//CP_2
//		double notas1[]={10.0,10.5,10.4,10.4,10,10};
//		double notas2[]={9.0,9.5,9.9,9.4,9,7};
//		double notas3[]={8.0,5.5,7.4,6.4,7,7};
//		CP2_TEstud estud1=new CP2_TEstud("Gian",18,notas1);
//		CP2_TEstud estud2=new CP2_TEstud("Mateo",20,notas2);
//		CP2_TEstud estud3=new CP2_TEstud("Jose",21,notas3);
//		CP2_TGrupo grupo=new CP2_TGrupo();
//		grupo.addEstudiante(estud1);
//		grupo.addEstudiante(estud2);
//		grupo.addEstudiante(estud3);
//		System.out.println("Mejor promedio: "+grupo.mejorEstudiante());
		
		//CP_3
		//Ejercicio 2
//		LinkedStack<Integer>S=new LinkedStack<>();
//		LinkedStack<Integer>T=new LinkedStack<>();
//		S.push(23);
//		S.push(71);
//		S.push(65);
//		S.push(34);
//		T.push(21);
//		T.push(67);
//		T.push(45);
//		T.push(18);
//		CP3_Funciones.transfer(S,T);
//		int Tsize=T.size(); //no se modifica su valor
//		for(int i=0;i<Tsize;i++) {
//			System.out.print(T.pop()+" ");
//		}
		
		//Ejercicio 3
//		almacenar los operandos en dos colas distintas para darles prioridad, y también organizar los 
//		operandos en otra pila para, trabajo con cadenas y 
//		combinar con linked stack, el operador de mayor prioridad asignarlo de último
		
		//Ejercicio 4
//		CP3_CadenaHilton servidor=new CP3_CadenaHilton();
//		servidor.addSolicitud(new CP3_Solicitud("Gian",3424,"Hilton Quito",false,12)); //false=0 es VIP
//		servidor.addSolicitud(new CP3_Solicitud("Jose",754,"Hilton Ambato",false,5));
//		servidor.addSolicitud(new CP3_Solicitud("Mate",564,"Hilton Quito",true,2));
//		servidor.addSolicitud(new CP3_Solicitud("Melisa",394,"Hilton Quito",false,8));
//		servidor.addSolicitud(new CP3_Solicitud("Carla",124,"Hilton Guayaquil",true,7));
//		servidor.addSolicitud(new CP3_Solicitud("Juan",484,"Hilton Quito",true,3));
//		servidor.getInfo(484);
//		servidor.getInfo(124);
//		servidor.getInfo(564);
//		System.out.println();
//		System.out.println("--Lista de Reservaciones--");
//		LinkedQueue<CP3_Reservacion>reservaciones=servidor.getReservaciones("Hilton Quito");
//		Node<CP3_Reservacion>temp=reservaciones.getHead();
//		for(int i=0;i<reservaciones.size();i++) {
//			System.out.println("Codigo: "+temp.getElement().getCodigo());
//			System.out.println("Cliente: "+temp.getElement().getNombreCliente());
//			System.out.println("Hotel: "+temp.getElement().getSolicitud().getHotel());
//			System.out.println("# Habitación: "+temp.getElement().getHabitacion());
//			System.out.println();
//			temp=temp.getNext();
//		}
		
		//Juguemos en el bosque
//		Scanner scan=new Scanner(System.in);
//		boolean cont=true;
//		boolean found;
//		boolean ready;
//		System.out.println("juguemos en el bosque");
//		while (cont==true) {
//			found=false;
//			while (found==false) {
//				ready=false;
//				while(ready==false) {
//					System.out.println("el lobo está, enter true o false");
//					ready=scan.nextBoolean();
//				}
//				System.out.println("escondete");
//				System.out.println("lobo atrapaste a alguien, true or false");
//				found=scan.nextBoolean();
//			}
//			
//			System.out.println("atrapdo a a alguien");
//			System.out.println("seguir jugando, true or false");			
//			cont=scan.nextBoolean();
//		}

		//E13
//		EI3_Articulo item1=new EI3_Articulo("jabón lavaplatos", 2.5, false);
//		EI3_Articulo item2=new EI3_Articulo("esponja", 0.5, true);
//		EI3_Articulo item3=new EI3_Articulo("cepillo de dientes", 0.75, true);
//		EI3_Articulo item4=new EI3_Articulo("jabón", 1.5, false);
//		EI3_Articulo item5=new EI3_Articulo("shampoo", 2.5, false);
//		EI3_Articulo item6=new EI3_Articulo("algodón", 1.0, true);
//		EI3_Articulo item7=new EI3_Articulo("coca cola", 1.25, true);
//		EI3_ListaHogar lista=new EI3_ListaHogar();
//		lista.addArticulo(item1);
//		lista.addArticulo(item2);
//		lista.addArticulo(item3);
//		lista.addArticulo(item4);
//		lista.addArticulo(item5);
//		lista.addArticulo(item6);
//		lista.addArticulo(item7);
//		System.out.printf("Mostrando todos los artículos...\n");
//		lista.showArticulos();
//		System.out.printf("\n\nMostrando articulos que se han terminado...\n");
//		lista.showArticulosFaltantes();;
//		System.out.printf("\n\nMostrando articulos que NO se han terminado...\n");
//		lista.showArticulosExistentes();
//		System.out.printf("\n\nRemoviendo articulos que se han terminado...\n");
//		lista.removeArticulosFaltantes();
//		System.out.printf("\n\nRemoviendo articulos que NO se han terminado...\n");
//		lista.removeArticulosExistentes();
//		System.out.printf("\n\nMostrando todos los artículos...\n");
//		lista.showArticulos();
		
		//CP4
//		CP4_Hospital h1=new CP4_Hospital("Carlos Andrade Marín","Miraflores",12);
//		h1.addPaciente(new CP4_Paciente("Gian", 2342, 21, 'm'));
//		h1.addPaciente(new CP4_Paciente("Jose", 4342, 9, 'm'));
//		h1.addPaciente(new CP4_Paciente("maria", 2642, 63, 'f'));
//		h1.addPaciente(new CP4_Paciente("esteban", 2242, 8, 'm'));
//		h1.addPaciente(new CP4_Paciente("grecia", 2442, 65, 'f'));
//		h1.atenderPacientes();
//		h1.showAtendidos();
//		h1.atenderPacientes();
//		h1.eliminarPaciente(2442);
//		h1.showAtendidos();
//		h1.atenderPacientes();
		
		//Examen 1
		
//		Ex1_Provincia p1=new Ex1_Provincia("Pichincha"); //manejo todo desde la provincia
//		p1.addFarmacia(new Ex1_Farmacia("Sana Sana", new Ex1_Medicamento("enalapril", "jarabe", 200), 1500,2500));
//		p1.addFarmacia(new Ex1_Farmacia("Pharmacys", new Ex1_Medicamento("enalapril", "jarabe", 120), 5000,8000));
//		p1.addFarmacia(new Ex1_Farmacia("Fybeca", new Ex1_Medicamento("enalapril", "jarabe", 120), 1000,3431));
//		p1.addFarmacia(new Ex1_Farmacia("Fybeca", new Ex1_Medicamento("loratadina", "tableta", 200), 10000,3500));
//		//literal b
//		p1.maxVentas("Abrilar"); //Big(O) es O(n) porque tengo dos bucles for consecutivos así que solo tomo el big(O) del mayor
//		//literal c
//		p1.ventasMedicamento("Abrilar"); //Big(O) es O(n)porque solo tengo un bucle for
//		//literal d
//		p1.eliminarFarmacias("Abrilar"); 
//		p1.maxVentas("Abrilar");
//		//literal e
//		p1.addFarmacia(new Ex1_Farmacia("Sana Sana", new Ex1_Medicamento("Abrilar", "jarabe", 200), 1500,2500));
//		p1.addFarmacia(new Ex1_Farmacia("Pharmacys", new Ex1_Medicamento("Abrilar", "jarabe", 120), 5000,8000));
//		p1.addFarmacia(new Ex1_Farmacia("Fybeca", new Ex1_Medicamento("Abrilar", "jarabe", 120), 1000,3431));
//		p1.addFarmacia(new Ex1_Farmacia("Fybeca", new Ex1_Medicamento("Abrilar", "jarabe", 120), 1000,3431));
//		p1.insertarFarmacia(new Ex1_Farmacia("Medicity", new Ex1_Medicamento("Tusollvine", "jarabe", 100), 12000,1000));//Big(O) es O(n) porque solo hay un bucle for
//		p1.mostrarFarmacias();
	
		//Ejercicio 1
//		System.out.println("armonico: "+CP5_Funciones.armonico(2));
//		System.out.println("armonico: "+CP5_Funciones.armonico(3));
//		System.out.println("armonico: "+CP5_Funciones.armonico(4));
//		String p1="ava";
//		char[] arreglo=p1.toCharArray();
//		System.out.println("size: "+p1.length());
//		System.out.println("size: "+arreglo.length);
//		for (char c : arreglo) {
//			System.out.println(c);
//		}
//		System.out.println("posición 3:"+arreglo[2]);
//		System.out.println("a string:"+arreglo.toString());
		//Ejercicio 3
//		System.out.println("¿palíndromo?: "+CP5_Funciones.esPalindromo("Ágil ligar, frágil liga"));
//		System.out.println("¿palíndromo?: "+CP5_Funciones.esPalindromo("Salomé, me molas"));
//		String p="mar";
//		if(p.length()==0 || p.length()==1) System.out.println("111");
//		else 
//			if(p.charAt(0)=='n') 
//				if(p.length()==3)
//					if(p.charAt(1)=='a')
//					System.out.println("hola");
//		System.out.println("substring: "+p.substring(1, 1)+"length: "+p.substring(1, 1).length());
		//Ejercicio 2 torres de hanoi
//		int N = 3; 
//				
//		// A, B and C are names of rods 
//		CP5_Funciones.towerOfHanoi(N, 'A', 'B', 'C'); 
		
		//Estudio independiente 4
//		LinkedTree<String> arbol_1=new LinkedTree<>();
//		Position<String> M=arbol_1.addRoot("M");
//		Position<String> A=arbol_1.addChild(M,"A");
//		Position<String> R=arbol_1.addChild(A,"R");
//		Position<String> T=arbol_1.addChild(R,"T");
//		Position<String> I=arbol_1.addChild(R,"I");
//		Position<String> N=arbol_1.addChild(M,"N");
//		System.out.println("--Linked Tree con preorder--");
//		for (Position<String> iterator : arbol_1.preorder()) {
//			System.out.print(iterator.getElement()+" ");
//		}
//		System.out.println();
//		System.out.println("--Linked Tree con postorder--");
//		LinkedTree<String> arbol_2=new LinkedTree<>();
//		Position<String> semana_1=arbol_2.addRoot("---Semana_1---");
//		Position<String> lunes=arbol_2.addChild(semana_1,"--lunes--");
//		Position<String> L1=arbol_2.addChild(lunes,"celular");
//		Position<String> L2=arbol_2.addChild(lunes,"televisor");
//		Position<String> martes=arbol_2.addChild(semana_1,"--martes--");
//		Position<String> M1=arbol_2.addChild(martes,"tablet");
//		Position<String> miercoles=arbol_2.addChild(semana_1,"--miercoles--");
//		Position<String> I1=arbol_2.addChild(miercoles,"audifonos");
//		Position<String> I2=arbol_2.addChild(miercoles,"televisor");
//		Position<String> jueves=arbol_2.addChild(semana_1,"--jueves--");
//		Position<String> J1=arbol_2.addChild(jueves,"cargador");
//		Position<String> J2=arbol_2.addChild(jueves,"mica protectora");
//		Position<String> J3=arbol_2.addChild(jueves,"tablet");
//		Position<String> viernes=arbol_2.addChild(semana_1,"--viernes--");
//		Position<String> V1=arbol_2.addChild(viernes,"laptop");
//		for (Position<String> i : arbol_2.postorder()) {
//			System.out.println(i.getElement());
//		}
//		
//		LinkedBinaryTree<String> arbol_3=new LinkedBinaryTree<>();
//		Position<String> pfuerte=arbol_3.addRoot("--Plato fuerte--");
//		Position<String> seg1=arbol_3.addLeft(pfuerte, "Segunda opcion de entrada:");
//		Position<String> seg2=arbol_3.addRight(pfuerte, "Segunda opcion de plato fuerte:");
//		Position<String> cev=arbol_3.addLeft(seg1, "Ceviche");
//		Position<String> chorizo=arbol_3.addRight(seg1, "Chorizo");
//		Position<String> entrada=arbol_3.addLeft(cev, "--Entrada--");
//		Position<String> ajillo=arbol_3.addLeft(seg2, "Camarones al ajillo");
//		Position<String> fritada=arbol_3.addRight(seg2, "Fritada");
//		System.out.println();
//		System.out.println("--Linked Binary Tree con inorder--");
//		for (Position<String> i : arbol_3.inorder()) {
//			System.out.println(i.getElement());
//		}
	//Clase práctica 6
		//ejercicio 1
//		LinkedBinaryTree<Character> ej=new LinkedBinaryTree<>();
//		Position<Character> root=ej.addRoot('/');
//		Position<Character> child1=ej.addLeft(root,'*');
//		Position<Character> child2=ej.addRight(root,'4');
//		Position<Character> child1_1=ej.addLeft(child1,'+');
//		Position<Character> child2_2=ej.addRight(child1,'-');
//		Position<Character> child1_1_1=ej.addLeft(child1_1,'5');
//		Position<Character> child1_1_2=ej.addRight(child1_1,'2');
//		Position<Character> child2_1_1=ej.addLeft(child2_2,'8');
//		Position<Character> child2_1_2=ej.addRight(child2_2,'3');
//		for (Position<Character> i : ej.inorder()) {
//			System.out.print(i.getElement()+" ");
//		}
//		System.out.println();
//		System.out.println("Postorder");
//		for (Position<Character> i : ej.postorder()) {
//			System.out.print(i.getElement()+" ");
//		}
//		System.out.println("Profundidad: "+ej.depth(child2_1_2));
//		System.out.println("Altura: "+ej.height(root));
//		
		
		//ejercicio 2
//		CP6_TreeParentesis<String>ej1=new CP6_TreeParentesis<>();
//		Position<String> root=ej1.addRoot("Sales");
//		Position<String> child1=ej1.addChild(root, "Domestic");
//		Position<String> child2=ej1.addChild(root, "International");
//		Position<String> child2_1=ej1.addChild(child2, "Canada");
//		Position<String> child2_2=ej1.addChild(child2, "S.America");
//		Position<String> child2_3=ej1.addChild(child2, "Overseas");
//		Position<String> child2_2_1=ej1.addChild(child2_3, "Africa");
//		Position<String> child2_2_2=ej1.addChild(child2_3, "Europe");
//		Position<String> child2_2_3=ej1.addChild(child2_3, "Asia");
//		Position<String> child2_2_4=ej1.addChild(child2_3, "Australia");
//		System.out.println(ej1.preOrder(root, 0));

		
		//Clase práctica 7
//		CP7_Polinomio p1=new CP7_Polinomio(1,-2,1);
//		p1.imprimirPolinomio();
//		System.out.println();
//		System.out.println(p1.evaluarPolinomio(1));
		
		//Ejercicio 3
//		CP7_BinaryExpressionTree arbol=new CP7_BinaryExpressionTree();
//		Position<String> root=arbol.addRoot("+");
//		Position<String> uno=arbol.addRight(root,"1");
//		Position<String> menos=arbol.addLeft(root,"-");
//		Position<String> por_izq=arbol.addLeft(menos,"*");
//		Position<String> por_der=arbol.addRight(menos,"*");
//		Position<String> x1=arbol.addLeft(por_izq,"x");
//		Position<String> x2=arbol.addRight(por_izq,"x");
//		Position<String> dos=arbol.addLeft(por_der,"2");
//		Position<String> x3=arbol.addRight(por_der,"x");
//		System.out.println("Evalución en x=1: "+arbol.evaluarPolinomio(root, 1));
//		System.out.println("Inorder:");
//		for (Position<String> i : arbol.inorder()) {
//			System.out.print(i.getElement()+" ");
//		}
		//Estudio independiente 5
		//chainhadshmap
//		 ChainHashMap<Integer, String> hashMap = new ChainHashMap<>();
//	        hashMap.put(2, "A");
//	        hashMap.put(2, "B");
//	        hashMap.put(2, "C");
//	        for (Entry<Integer, String> entry : hashMap.entrySet()) {
//	            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
//	        }
//	      //probehadshmap
//	        ProbeHashMap<String, Integer> map = new ProbeHashMap<>();
//	        map.put("key1", 1);
//	        map.put("key2", 2);
//	        map.put("key3", 3);
//	        Integer value = map.get("key2");
//	        System.out.println("Valor de key2: " + value);
//	        Integer removedValue = map.remove("key1");
//	        System.out.println("Valor removido key1: " + removedValue);
//	        for(Entry<String,Integer> i:map.entrySet()) {
//				System.out.println(i.getValue());
//			}
//	      //doublehadshmap
//		DoubleHashMap<Integer, String> ej=new DoubleHashMap<Integer, String>(13);
//		ej.put(18, "Gian");
//		ej.put(41, "Jose");
//		ej.put(22, "Esteban");
//		ej.put(44, "María");
//		ej.put(59, "Carla");
//		ej.put(32, "Diego");
//		ej.put(31, "Andrés");
//		ej.put(73, "Antonio");
//		ej.put(73, "Marco");
//		for (Entry<Integer,String> i : ej.entrySet()) {
//			System.out.println(i.getValue());
//		}
//		System.out.println();
//		ej.remove(31);
//		for (Entry<Integer,String> i : ej.entrySet()) {
//			System.out.println(i.getValue());
//		}
//		System.out.println();
//		ej.put(31, "Andrés");
//		for (Entry<Integer,String> i : ej.entrySet()) {
//			System.out.println(i.getValue());
//		}
//		System.out.println();
//		System.out.println("Entrada con llave 32: "+ej.get(32));
//		System.out.println("!Brutal¡");
		//Examen 2
		//Ejercicio 1
//		System.out.println("----Ejercicio 1----");
//		Ex2_MapaEstudiantes usfq=new Ex2_MapaEstudiantes();
//		usfq.putEstudiante(new Ex2_Estudiante(36,"Gian Tituaña","Computación"));		
//		usfq.putEstudiante(new Ex2_Estudiante(65,"Jose aprez","matemática"));
//		usfq.putEstudiante(new Ex2_Estudiante(75,"melanie alvarez","psicología"));
//		usfq.putEstudiante(new Ex2_Estudiante(95,"matea","psicología"));
//		usfq.putEstudiante(new Ex2_Estudiante(77,"isabel","psicología"));
//		System.out.println("Estudiante con código 77: "+usfq.getEstudiante(0, 77).getNombre()); //0 para lograr recursividad
//		System.out.println("Estudiante con mayor código: "+usfq.getMaxCodigo(0, 0).getNombre()); //0 y 0 por default para lograr recursivida
//		//Ejercicio 2
//		System.out.println();
//		System.out.println("----Ejercicio 2----");
//		Ex2_Usfq usfq_2=new Ex2_Usfq();
//		usfq_2.putEstudiante(new Ex2_Estudiante(36,"Gian Tituaña","Computación"));		
//		usfq_2.putEstudiante(new Ex2_Estudiante(87,"Jose aprez","matemática"));
//		usfq_2.putEstudiante(new Ex2_Estudiante(75,"melanie alvarez","psicología"));
//		usfq_2.putEstudiante(new Ex2_Estudiante(95,"matea","psicología"));
//		usfq_2.putEstudiante(new Ex2_Estudiante(45,"isabel","psicología"));
//		System.out.println("Estudiante con codigo 95: "+usfq_2.get(95).getNombre());
//		System.out.println();
//		System.out.println("--Impresión en inorden para verificar la inserción ordenada--");
//		for (Entry<Integer,Ex2_Estudiante>i : usfq_2.entrySet() ) {
//			System.out.println("Nombre: "+i.getValue().getNombre()+" Codigo: "+i.getValue().getCodigo()+" Carrera: "+i.getValue().getCarrera());
//		}
//		System.out.println();
//		System.out.println("Remover estudiante con código 45: "+usfq_2.removeEstudiante(45).getNombre());
//		System.out.println();
//		for (Entry<Integer,Ex2_Estudiante>i : usfq_2.entrySet() ) {
//			System.out.println("Nombre: "+i.getValue().getNombre()+" Codigo: "+i.getValue().getCodigo()+" Carrera: "+i.getValue().getCarrera());
//		}
		
	//Clase práctica 8
		//Ejercicio 1
//		CP8_Ejercicio1 ej=new CP8_Ejercicio1();
//		ej.addElement(12, "12");
//		ej.addElement(44, "44");
//		ej.addElement(13, "13");
//		ej.addElement(88, "88");
//		ej.addElement(23, "23");
//		ej.addElement(94, "94");
//		ej.addElement(11, "11");
//		ej.addElement(39, "39");
//		ej.addElement(20, "20");
//		ej.addElement(20, "15"); //este valor se sobreescribe
//		ej.addElement(16, "16");
//		ej.addElement(5, "5");
//		System.out.print("Impresión de la inserción original:");
//		ej.printOriginal();
//		System.out.println();
//		ej.printResultante();
//		Integer ej2=45;
//		System.out.println("Hash code: "+ej2.hashCode());
//		DoubleHashMap<Integer, String> prueba=new DoubleHashMap<>();
//		prueba.put(18, "18");
//		prueba.put(41, "41");
//		prueba.put(22, "22");
//		prueba.put(44, "44");
//		prueba.put(59, "59");
//		prueba.put(32, "32");
//		prueba.put(31, "31");
//		prueba.put(73, "73");
//		System.out.println("Retonar un valor: "+prueba.get(73));
//		for (Entry<Integer,String> i :prueba.entrySet() ) {
//			System.out.println(i.getKey()+" "+"value: "+i.getValue());
//		}
//		//Ejercicio 2
//		System.out.println("--Ejercicio 2--");
//		CP8_SistemaRegistro iess=new CP8_SistemaRegistro();
//		iess.addPersona(new CP8_Persona("2751305145","Jose Martinez", "Loja,", 'm'));
//		iess.addPersona(new CP8_Persona("1751305119","Gian Tituaña", "Quito,hospital metropolitano", 'm'));
//		iess.addPersona(new CP8_Persona("1751305342","Teresa Arboleda", "Cuenca,", 'f'));
//		iess.printCiudadano("1751305342");
//		String cedula="1751305342";
//		System.out.println("Substring: "+cedula.substring(7));
//		System.out.println("Conversión: "+Integer.parseInt(cedula.substring(7)));
//		
		//Clase práctica 9
//		AdjacencyMapGraph ej1=new AdjacencyMapGraph(false);
//		Vertex<String> A=ej1.insertVertex("A");
//		Vertex<String> B=ej1.insertVertex("B");
//		Vertex<String> C=ej1.insertVertex("C");
//		Vertex<String> D=ej1.insertVertex("D");
//		Vertex<String> E=ej1.insertVertex("E");
//		Vertex<String> F=ej1.insertVertex("F");
//		Vertex<String> G=ej1.insertVertex("G");
//		Vertex<String> H=ej1.insertVertex("H");
//		ej1.insertEdge(A, B, 1);
//		ej1.insertEdge(A, C, 2);
//		ej1.insertEdge(A, D, 3);
//		ej1.insertEdge(A, E, 4);
//		ej1.insertEdge(B, C, 5);
//		ej1.insertEdge(B, G, 6);
//		ej1.insertEdge(B, E, 7);
//		ej1.insertEdge(E, H, 8);
//		ej1.insertEdge(E, F, 9);
//		ej1.insertEdge(E, D, 10);
//		System.out.println("---Vértices y edges---");
//		for (Object i: ej1.incomingEdges(A)) {
//			Edge<Integer> temp=(Edge<Integer>)i;
//			System.out.println(temp.getElement());
//		}
//		for (Object i: ej1.outgoingEdges(A)) { //en un grafo no dirigido outgoing e incoming son los mismos
//			Edge<Integer> temp=(Edge<Integer>)i;
//			System.out.println(temp.getElement());
//		}
//		for (Object i: ej1.edges()) {
//			Edge<Integer> temp=(Edge<Integer>)i;
//			Vertex<String>[] a= ej1.endVertices(temp);
//			System.out.println("Vértice: "+a[0].getElement()+" Edge: "+temp.getElement()+" Vértice: "+a[1].getElement());
//		}
		//Estudio independiente 6
		//Ejemplo dfs, mapa de calles de un barrio
//		AdjacencyMapGraph<EI6_Interseccion,EI6_Calle> ej1=new AdjacencyMapGraph<>(false);
//		Vertex<EI6_Interseccion> v1=ej1.insertVertex(new EI6_Interseccion("Entre San Gabriel y Mariana de Jesús "));
//		Vertex<EI6_Interseccion> v2=ej1.insertVertex(new EI6_Interseccion("Parque de 'La mujer'"));
//		Vertex<EI6_Interseccion> v3=ej1.insertVertex(new EI6_Interseccion("Edificio 'Picasso'"));
//		Vertex<EI6_Interseccion> v4=ej1.insertVertex(new EI6_Interseccion("Entre Mariana de Jesús, Crespo Toral, La Isla y Martín de Utreras"));
//		Vertex<EI6_Interseccion> v5=ej1.insertVertex(new EI6_Interseccion("Plaza circular 'José Martí'"));
//		Vertex<EI6_Interseccion> v6=ej1.insertVertex(new EI6_Interseccion("Entre Pizarro,Atahualpa,Bolívar y Galápagos"));
//		Vertex<EI6_Interseccion> v7=ej1.insertVertex(new EI6_Interseccion("Momumento a la independencia"));
//		Vertex<EI6_Interseccion> v8=ej1.insertVertex(new EI6_Interseccion("Parque 'Guanguiltagua'"));
//		Vertex<EI6_Interseccion> v9=ej1.insertVertex(new EI6_Interseccion("Entre Las Casas, La Gasca y América"));
//		Vertex<EI6_Interseccion> v10=ej1.insertVertex(new EI6_Interseccion("Edificio de empresa eléctrica")); //nombre de una calle
//		ej1.insertEdge(v1, v2,new EI6_Calle("San Gabriel"));
//		ej1.insertEdge(v1, v4,new EI6_Calle("Mariana de Jesús"));
//		ej1.insertEdge(v2, v3,new EI6_Calle("OE6B"));
//		ej1.insertEdge(v2, v5,new EI6_Calle("Santa Cruz"));
//		ej1.insertEdge(v3, v6,new EI6_Calle("Fernando Pizarro"));
//		ej1.insertEdge(v4, v5,new EI6_Calle("Crespo Toral"));
//		ej1.insertEdge(v4, v7,new EI6_Calle("Martín de Utreras"));
//		ej1.insertEdge(v4, v8,new EI6_Calle("La Isla"));
//		ej1.insertEdge(v5, v6,new EI6_Calle("Atahualpa"));
//		ej1.insertEdge(v5, v7,new EI6_Calle("Nuño de Valderrama"));
//		ej1.insertEdge(v6, v7,new EI6_Calle("Bolívar"));
//		ej1.insertEdge(v6, v10,new EI6_Calle("Galápagos"));
//		ej1.insertEdge(v7, v9,new EI6_Calle("Las Casas"));
//		ej1.insertEdge(v8, v9,new EI6_Calle("La Gasca"));
//		ej1.insertEdge(v9, v10,new EI6_Calle("América"));
//		System.out.println("Sistema de navegación para visitar todas las intersecciones de las calles de un barrio sin pasar dos veces por la misma intersección");
//		System.out.println("---DFS---");
//		//recorrida dfs
//		Map<Vertex<EI6_Interseccion>,Edge<EI6_Calle>> dfs=AdjacencyMapGraph.DFSComplete(ej1);
//		
//		for (Entry<Vertex<EI6_Interseccion>,Edge<EI6_Calle>> i: dfs.entrySet()) {
//			System.out.printf("Referencia: "+i.getKey().getElement().getReferencia()+ "\t\tCalle por la cual transitar: "+i.getValue().getElement().getNombre());
//			System.out.println();
//		}	
//		System.out.println("---BFS---");
//		//Ejermplo bfs
//		Map<Vertex<EI6_Interseccion>,Edge<EI6_Calle>> bfs=AdjacencyMapGraph.BFSComplete(ej1);
//		for (Entry<Vertex<EI6_Interseccion>,Edge<EI6_Calle>> i: dfs.entrySet()) {
//			System.out.printf("Referencia: "+i.getKey().getElement().getReferencia()+ "\t\tCalle por la cual transitar: "+i.getValue().getElement().getNombre());
//			System.out.println();
//		}
		//Clase práctica 10
		//Ejercicio 1
//		CP10_Grafo1 ej1=new CP10_Grafo1();
//		Vertex<String> A=ej1.insertVertex("A");
//		Vertex<String> B=ej1.insertVertex("B");
//		Vertex<String> C=ej1.insertVertex("C");
//		Vertex<String> D=ej1.insertVertex("D");
//		Vertex<String> E=ej1.insertVertex("E");
//		Vertex<String> F=ej1.insertVertex("F");
//		Vertex<String> G=ej1.insertVertex("G");
//		Vertex<String> H=ej1.insertVertex("H");	
//		ej1.insertEdge(A,C,1);
//		ej1.insertEdge(A,B,2);
//		ej1.insertEdge(A,E,3);
//		ej1.insertEdge(A,D,4);
//		ej1.insertEdge(B,C,5);
//		ej1.insertEdge(B,E,6);
//		ej1.insertEdge(B,G,7);
//		ej1.insertEdge(D,G,8);
//		ej1.insertEdge(D,E,9);
//		ej1.insertEdge(E,H,10);
//		ej1.insertEdge(E,F,11);
//		ej1.insertEdge(F,H,12);
//		ej1.printDFS();
//		ej1.printBFS();
//		//Camino más corto entre dos vertices, no tiene en cuanta la ponderación del edge, solo la cantidad de vertices en el path
//		ej1.printCaminoMasCorto(A,H);
//		AdjacencyMapGraph<Integer, Integer> ej2=new AdjacencyMapGraph(false);
//		Vertex<Integer> uno=ej2.insertVertex(1);	
//		Vertex<Integer> dos=ej2.insertVertex(2);	
//		Vertex<Integer> tres=ej2.insertVertex(3);	
//		Vertex<Integer> cuatro=ej2.insertVertex(4);	
//		Vertex<Integer> cinco=ej2.insertVertex(5);	
//		Vertex<Integer> seis=ej2.insertVertex(6);	
//		Vertex<Integer> siete=ej2.insertVertex(7);	
//		Vertex<Integer> ocho=ej2.insertVertex(8);	
//		ej2.insertEdge(uno,dos,null);
//		ej2.insertEdge(uno,tres,null);
//		ej2.insertEdge(uno,cuatro,null);
//		ej2.insertEdge(dos,tres,null);
//		ej2.insertEdge(dos,cuatro,null);
//		ej2.insertEdge(tres,cuatro,null);
//		ej2.insertEdge(cuatro,seis,null);
//		ej2.insertEdge(cinco,seis,null);
//		ej2.insertEdge(cinco,siete,null);
//		ej2.insertEdge(cinco,ocho,null);
//		ej2.insertEdge(seis,siete,null);
//		ej2.insertEdge(siete,ocho,null);
//		System.out.println("--DFS(Ejercicio 2)--");
//		Map<Vertex<Integer>,Edge<Integer>> dfs=AdjacencyMapGraph.DFSComplete2(ej2,uno);
//		for (Entry<Vertex<Integer>,Edge<Integer>> i: dfs.entrySet()) {
//			System.out.println("Vertice: "+i.getKey().getElement()+" Edge: "+i.getValue().getElement()+" Vértice: " +ej2.opposite(i.getKey(),i.getValue()).getElement());
//		}
//		System.out.println("--DFS(Ejercicio 2)--");
//		Map<Vertex<Integer>,Edge<Integer>> dfs2=AdjacencyMapGraph.DFSComplete(ej2);
//		for (Entry<Vertex<Integer>,Edge<Integer>> i: dfs2.entrySet()) {
//			System.out.println("Vertice: "+i.getKey().getElement()+" Edge: "+i.getValue().getElement()+" Vértice: " +ej2.opposite(i.getKey(),i.getValue()).getElement());
//		}
//		System.out.println("--BFS(Ejercicio 2)--");
//		Map<Vertex<Integer>,Edge<Integer>> bfs=AdjacencyMapGraph.BFSComplete(ej2);
//		for (Entry<Vertex<Integer>,Edge<Integer>> i: bfs.entrySet()) {
//			System.out.println("Vertice: "+i.getKey().getElement()+" Edge: "+i.getValue().getElement()+" Vértice: " +ej2.opposite(i.getKey(),i.getValue()).getElement());
//		}
//		System.out.println("--BFS(Ejercicio 2)--");
//		Map<Vertex<Integer>,Edge<Integer>> bfs2=AdjacencyMapGraph.BFSComplete2(ej2,uno);
//		for (Entry<Vertex<Integer>,Edge<Integer>> i: bfs.entrySet()) {
//			System.out.println("Vertice: "+i.getKey().getElement()+" Edge: "+i.getValue().getElement()+" Vértice: " +ej2.opposite(i.getKey(),i.getValue()).getElement());
//		}
		
		
		
		
//		System.out.println("--DFS--");
//		Map<Vertex<String>,Edge<Integer>> dfs=AdjacencyMapGraph.DFSComplete(ej1);
//		for (Entry<Vertex<String>,Edge<Integer>>i:dfs.entrySet()) {
//			System.out.println("Vértice: "+ej1.opposite(i.getKey(),i.getValue()).getElement()+" Edge: "+i.getValue().getElement()+" Vértice: "+i.getKey().getElement());
//		}
//		System.out.println("--BFS--");
//		Map<Vertex<String>,Edge<Integer>> bfs=AdjacencyMapGraph.BFSComplete(ej1);
//		for (Entry<Vertex<String>,Edge<Integer>>i:bfs.entrySet()) {
//			System.out.println("Vértice: "+ej1.opposite(i.getKey(),i.getValue()).getElement()+" Edge: "+i.getValue().getElement()+" Vértice: "+i.getKey().getElement());
//		}
//		//b, camino más corto, con bfs
//		System.out.println("--Camino más corto entre A y H--");
//		//hacerlo un grafo de nuevo y utilizar los outgoings
//		for (Entry<Vertex<String>,Edge<Integer>>i: bfs.entrySet()) {
//			if(i.getKey().getElement().equals("A")) { //encuentro A
//				while(ej1.opposite(i.getKey(), i.getValue())!=null) {
//					bfs.get(ej1.opposite(i.getKey(), i.getValue()));
//				}
//				ej1.opposite(i.getKey(), i.getValue());
//			}
//		}
		//Estudio independiente 7
//		AdjacencyMapGraph<EI7_Puerto,Integer> ex=new AdjacencyMapGraph<>(true);
//		Vertex<EI7_Puerto> gua=ex.insertVertex(new EI7_Puerto("Guayaquil", "Ecuador", 100000));
//		Vertex<EI7_Puerto> sin=ex.insertVertex(new EI7_Puerto("Singapur", "Singapur", 500000.23));
//		Vertex<EI7_Puerto> ham=ex.insertVertex(new EI7_Puerto("Hamburgo", "Alemania", 600500));
//		Vertex<EI7_Puerto> sha=ex.insertVertex(new EI7_Puerto("Shangai", "China", 104000.1));
//		Vertex<EI7_Puerto> san=ex.insertVertex(new EI7_Puerto("De Santos", "Brasil", 300700));
//		Vertex<EI7_Puerto> man=ex.insertVertex(new EI7_Puerto("Manzanillo", "México", 300000.45));
//		Vertex<EI7_Puerto> cal=ex.insertVertex(new EI7_Puerto("El Callao", "Perú", 800030.12));
//		Vertex<EI7_Puerto> nue=ex.insertVertex(new EI7_Puerto("Nueva York", "Estados Unidos", 410008));	
//		Vertex<EI7_Puerto> val=ex.insertVertex(new EI7_Puerto("Valencia", "España", 200890));
//		ex.insertEdge(gua,sin,15); //los edges son los días de viaje
//		ex.insertEdge(gua,sha,12);
//		ex.insertEdge(san,gua,18);
//		ex.insertEdge(ham,sin,21);
//		ex.insertEdge(sin,man,30);
//		ex.insertEdge(val,ham,14);
//		ex.insertEdge(cal,sha,20);
//		ex.insertEdge(sha,cal,34);
//		ex.insertEdge(san,man,12);
//		ex.insertEdge(val,san,19);
//		ex.insertEdge(man,nue,25);
//		ex.insertEdge(cal,nue,14);
//		System.out.println("---Antes de hacer transitive closure---");
//		for (Vertex<EI7_Puerto> i: ex.vertices()) {
//			System.out.println("Vértice: "+i.getElement().getNombre());
//			System.out.println("Outgoing edges: ");
//			for (Edge<Integer> j: ex.outgoingEdges(i)) {
//				System.out.println("Edge: "+j.getElement()+" Vértice destino: "+ex.opposite(i, j).getElement().getNombre());
//			}
//			System.out.println("Incoming edges: ");
//			for (Edge<Integer> k: ex.incomingEdges(i)) {
//				System.out.println("Edge: "+k.getElement()+" Vértice origen: "+ex.opposite(i, k).getElement().getNombre());
//			}
//			System.out.println();
//		}
//		System.out.println("---Después de hacer transitive closure(edges con (\"null\" son los creados por el algoritmo)---");
//		AdjacencyMapGraph.transitiveClosure(ex);
//		for (Vertex<EI7_Puerto> i: ex.vertices()) {
//			System.out.println("Vértice: "+i.getElement().getNombre());
//			System.out.println("Outgoing edges: ");
//			for (Edge<Integer> j: ex.outgoingEdges(i)) {
//				System.out.println("Edge: "+j.getElement()+" Vértice destino: "+ex.opposite(i, j).getElement().getNombre());
//			}
//			System.out.println("Incoming edges: ");
//			for (Edge<Integer> k: ex.incomingEdges(i)) {
//				System.out.println("Edge: "+k.getElement()+" Vértice origen: "+ex.opposite(i, k).getElement().getNombre());
//			}
//			System.out.println();
//		}
//		//Nuevas rutas de tráfico marítimo para considerar su creación
//		System.out.println("---Posibles nuevas rutas directas para mejorar eficiencia en las entregas---");
//		for (Vertex<EI7_Puerto> i: ex.vertices()) {
//			System.out.println("Puerto marítimo: "+i.getElement().getNombre()+", "+i.getElement().getPais()+", "+i.getElement().getCapacidad()+" toneladas");
//			for (Edge<Integer> j: ex.outgoingEdges(i)) {
//				if(j.getElement()==null) {
//					System.out.println("Puerto de destino: "+ex.opposite(i, j).getElement().getNombre()+", "+ex.opposite(i, j).getElement().getPais()+", "+ex.opposite(i, j).getElement().getCapacidad()+" toneladas");
//				}
//			}
//			for (Edge<Integer> k: ex.incomingEdges(i)) {
//				if(k.getElement()==null) {
//					System.out.println("Puerto de origen: "+ex.opposite(i, k).getElement().getNombre()+", "+ex.opposite(i, k).getElement().getPais()+", "+ex.opposite(i, k).getElement().getCapacidad()+" toneladas");
//				}
//			}
//			System.out.println();
//		}
//		//uso de topologicalsort
//		System.out.println("---Topological sort(detección de ciclos)---");
//		int count=0;
//		for (Vertex<EI7_Puerto> i: AdjacencyMapGraph.topologicalSort(ex)) {
//			System.out.println("Vértice: "+i.getElement().getNombre());
//			count++;
//		}
//		if(count!=ex.numVertices()) {
//			System.out.println("Existen problemas de eficiencia dentro de las rutas marímitmas(hay ciclos dentro del grafo)");
//		}
		//m
		
//		CP8_Registro oficina=new CP8_Registro();
//		oficina.addCliente(new CP8_Cliente("2751305145","Jose Martinez", "Loja", "M"));
//		oficina.addCliente(new CP8_Cliente("1751305119","Gian Tituaña", "Quito,hospital metropolitano", "F"));
//		oficina.addCliente(new CP8_Cliente("1751305342","Teresa Arboleda", "Cuenca,", "ND"));
//		oficina.addCliente(new CP8_Cliente("1753487311","Maria", "Cuenca,", "ND"));
//		oficina.addCliente(new CP8_Cliente("1753487457","Arturo", "Cuenca,", "ND"));
//		oficina.buscarCliente("2751305145");
//		oficina.imprimirBaseDeDatos();
//		ProbeHashMap<Integer, String> prueba=new ProbeHashMap<>(11);
//		prueba.put(12,null);
//		prueba.put(44,null);
//		prueba.put(13,null);
//		prueba.put(88,null);
//		prueba.put(23,null);
//		prueba.put(94,null);
//		prueba.put(11,null);
//		prueba.put(39,null);
//		prueba.put(20,null);
//		prueba.put(16,null);
//		prueba.put(5,null);
//		for (Entry<Integer,String>i : prueba.entrySet()) {
//			System.out.println(i.getKey());
//		}
//		
		
		//Clase práctica 11
		//a
//		CP11_Ejercicio1 grafo=new CP11_Ejercicio1();
//		Vertex<String> A=grafo.insertVertex("A");
//		Vertex<String> B=grafo.insertVertex("B");
//		Vertex<String> F=grafo.insertVertex("F");
//		Vertex<String> J=grafo.insertVertex("J");
//		Vertex<String> M=grafo.insertVertex("M");
//
//		grafo.insertEdge(B,A,"BA");
//		grafo.insertEdge(B,M,"BM");
//		grafo.insertEdge(B,J,"BJ");
//		grafo.insertEdge(M,A,"MA");
//		grafo.insertEdge(A,J,"AJ");
//		grafo.insertEdge(A,F,"AF");
//		grafo.isDAG();
//		//b
//		System.out.println("--Topological ordering--");
//		grafo.topologicalOrder();
//		//c
//		System.out.println();
//		System.out.println("--Transitive closure--");
//		grafo.transitiveClosure();
//		//Ejercicio 2
//		CP11_Malla usfq=new CP11_Malla();
//		Vertex<String> la15=usfq.addCurso("LA15");
//		Vertex<String> la16=usfq.addCurso("LA16");
//		Vertex<String> la22=usfq.addCurso("LA22");
//		Vertex<String> la31=usfq.addCurso("LA31");
//		Vertex<String> la32=usfq.addCurso("LA32");
//		Vertex<String> la126=usfq.addCurso("LA126");
//		Vertex<String> la127=usfq.addCurso("LA127");
//		Vertex<String> la141=usfq.addCurso("LA141");
//		Vertex<String> la169=usfq.addCurso("LA169");
//		usfq.addPrerrequisito(la16,la15);
//		usfq.addPrerrequisito(la31,la15);
//		usfq.addPrerrequisito(la32,la16);
//		usfq.addPrerrequisito(la32,la31);
//		usfq.addPrerrequisito(la126,la22);
//		usfq.addPrerrequisito(la126,la32);
//		usfq.addPrerrequisito(la127,la16);
//		usfq.addPrerrequisito(la141,la22);
//		usfq.addPrerrequisito(la141,la16);
//		usfq.addPrerrequisito(la169,la32);
//		usfq.tomarCursos();
//		//Ejercicio 3
//		Digraph<String, Integer> airport=new Digraph<>();
//		Vertex<String> bos=airport.insertVertex("BOS");
//		Vertex<String> jfk=airport.insertVertex("JFK");
//		Vertex<String> mia=airport.insertVertex("MIA");
//		Vertex<String> ord=airport.insertVertex("ORD");
//		Vertex<String> dfw=airport.insertVertex("DFW");
//		Vertex<String> sfo=airport.insertVertex("SFO");
//		Vertex<String> lax=airport.insertVertex("LAX");
//		airport.insertEdge(bos, jfk, null);
//		airport.insertEdge(bos, mia, null);
//		airport.insertEdge(bos, sfo, null);
//		airport.insertEdge(jfk, sfo, null);
//		airport.insertEdge(jfk, mia, null);
//		airport.insertEdge(jfk, dfw, null);
//		airport.insertEdge(ord, dfw, null);
//		airport.insertEdge(dfw, sfo, null);
//		airport.insertEdge(dfw, lax, null);
//		airport.insertEdge(mia, lax, null);
//		airport.insertEdge(mia, dfw, null);
//		System.out.println();
//		System.out.println("--Topological sort de los aeropuertos--");
//		for (Vertex<String> i: AdjacencyMapGraph.topologicalSort(airport)) {
//			System.out.println("Aeropuerto: "+i.getElement());
//		}
		//Ejercicio 4(dibujar únicamente)
		//Clase práctica 12
//		CP12_Hospital metro=new CP12_Hospital();
//		Vertex<CP12_SalaHospital> emergencia=metro.addSala(new CP12_SalaHospital("Emergencia"));
//		Vertex<CP12_SalaHospital> cardiologia=metro.addSala(new CP12_SalaHospital("Cardiología"));
//		Vertex<CP12_SalaHospital> pediatria=metro.addSala(new CP12_SalaHospital("Pediatría"));
//		Vertex<CP12_SalaHospital> anestesiologia=metro.addSala(new CP12_SalaHospital("Anestesiología"));
//		Vertex<CP12_SalaHospital> laboratorio=metro.addSala(new CP12_SalaHospital("Laboratorio"));
//		Vertex<CP12_SalaHospital> uci=metro.addSala(new CP12_SalaHospital("Unidad de cuidados intensivos"));
//		metro.addPasillo(emergencia, pediatria, 2);
//		metro.addPasillo(emergencia, cardiologia, 6);
//		metro.addPasillo(emergencia, anestesiologia, 4);
//		metro.addPasillo(pediatria, uci, 1);
//		metro.addPasillo(uci, anestesiologia, 5);
//		metro.addPasillo(uci, cardiologia, 5);
//		metro.addPasillo(cardiologia, laboratorio, 6);
//		metro.addPasillo(laboratorio, anestesiologia, 6);
//		//literal c
//		metro.rutaMasRapida(emergencia);
//		//literl d
//		metro.rutaDeRegreso(cardiologia);
//		//litearl e
//		metro.rutaDFS();
//		metro.rutaBFS();
//		//literal d(dibujar)	
		
		//Examne 3
//		AdjacencyMapGraph<String, Integer> red=new AdjacencyMapGraph(false);
//		Vertex<String> c1=red.insertVertex("C1");
//		Vertex<String> c4=red.insertVertex("C4");
//		Vertex<String> c7=red.insertVertex("C7");
//		Vertex<String> c8=red.insertVertex("C8");
//		Vertex<String> s2=red.insertVertex("S2");
//		Vertex<String> s3=red.insertVertex("S3");
//		Vertex<String> s5=red.insertVertex("S5");
//		Vertex<String> s6=red.insertVertex("S6");
//		red.insertEdge(c1, s2, 2);
//		red.insertEdge(c1, s3, 2);
//		red.insertEdge(s2, s5, 10);
//		red.insertEdge(s2, c4, 4);
//		red.insertEdge(s3, c4, 10);
//		red.insertEdge(s3, c8, 10);
//		red.insertEdge(s5, c4, 4);
//		red.insertEdge(c4, s6, 8);
//		red.insertEdge(s5, c7, 2);
//		red.insertEdge(c7, s6, 1);
//		red.insertEdge(s6, c8, 2);
//		Map<Vertex<String>,Integer> rutas_mas_cortas=AdjacencyMapGraph.shortestPathLengths(red, c1);
//		for (Entry<Vertex<String>,Integer> i: rutas_mas_cortas.entrySet()) {
//			System.out.println(" vertice: "+i.getKey().getElement()+"Edge: "+i.getValue());
//		}
		 // Creamos un mapa de árbol splay para almacenar las calificaciones de los estudiantes
		 S1_Tienda tienda = new S1_Tienda();
	        tienda.putArticulo(new S1_Articulo("Camiseta",21));
	        tienda.putArticulo(new S1_Articulo("Pantalon",15));
	        tienda.putArticulo(new S1_Articulo("Camisa",30));
	        tienda.putArticulo(new S1_Articulo("Chompa",18));

	        long startTime = System.nanoTime();
	        tienda.get(18); // Acceder por el precio
	        long endTime = System.nanoTime();
	        long duration = endTime - startTime;
	        System.out.println("Tiempo de acceso al elemento cercano a la raíz: " + duration + " nanosegundos");
	        
	        startTime = System.nanoTime();
	        tienda.get(21); // Acceder por el precio
	        endTime = System.nanoTime();
	        duration = endTime - startTime;
	        System.out.println("Tiempo de acceso al elemento más lejano de la raíz: " + duration + " nanosegundos");
	        
	        startTime = System.nanoTime();
	        tienda.get(21); // Acceder por el precio
	        endTime = System.nanoTime();
	        duration = endTime - startTime;
	        System.out.println("Tiempo de acceso al elemento 21: " + duration + " nanosegundos");
	    
	        startTime = System.nanoTime();
	        tienda.get(30); // Acceder por el precio
	        endTime = System.nanoTime();
	        duration = endTime - startTime;
	        System.out.println("Tiempo de acceso al elemento 30: " + duration + " nanosegundos");
	}
}