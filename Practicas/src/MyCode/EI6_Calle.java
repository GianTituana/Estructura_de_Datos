package MyCode;

public class EI6_Calle {
	String nombre;
	//se asume que las calles son de doble vía, para ajustarlo al concepto de grafo no dirigido
	public EI6_Calle(String nombre) {
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
