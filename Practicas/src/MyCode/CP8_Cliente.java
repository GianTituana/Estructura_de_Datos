package MyCode;

public class CP8_Cliente {
	String cedula, nombre, direccion, genero;
	public CP8_Cliente(String cedula, String nombre, String direccion, String genero) {
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
	public String getGenero() {
		return genero;
	}
	public String getNombre() {
		return nombre;
	}
}
