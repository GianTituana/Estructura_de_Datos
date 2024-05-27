package MyCode;

public class CP8_Persona {
	String cedula, nombre, direccion;
	char genero;
	public CP8_Persona(String cedula, String nombre, String direccion, char genero) {
	this.cedula=cedula;
	this.nombre=nombre;
	this.direccion=direccion;
	}
	public String getCedula() {
		return cedula;
	}
	public String getDireccion() {
		return direccion;
	}
	public char getGenero() {
		return genero;
	}
	public String getNombre() {
		return nombre;
	}
}