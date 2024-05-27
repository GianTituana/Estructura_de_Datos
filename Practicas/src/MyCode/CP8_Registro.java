package MyCode;

import ADT.ProbeHashMap;
import ADT.Entry;
public class CP8_Registro extends ProbeHashMap<Integer,CP8_Cliente > {
	//en La clase probehashmap se hizo override del método put
	//para hacer inserciones con la nueva función de hash
	public CP8_Registro() {
	}
	public void addCliente(CP8_Cliente cliente) {
		put(Integer.parseInt(cliente.getCedula().substring(7)),cliente); //ultimos tres digitos de la cedula
	}
	public void buscarCliente(String cedula) {
		int key=Integer.parseInt(cedula.substring(7));
		System.out.println("Cédula: "+get(key).getCedula());
		System.out.println("Nombre completo: "+get(key).getNombre());
		System.out.println("Género: "+get(key).getGenero());
		System.out.println("Dirección completa: "+get(key).getDireccion());
	}
	public void imprimirBaseDeDatos() {
		for (Entry<Integer,CP8_Cliente> i: entrySet()) {
			System.out.println("Cedula: "+i.getValue().getCedula()+" Nombre: "+i.getValue().getNombre());
		}
	}
}
