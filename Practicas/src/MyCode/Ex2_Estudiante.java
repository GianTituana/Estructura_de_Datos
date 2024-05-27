package MyCode;

public class Ex2_Estudiante {
	int codigo;
	String nombre;
	String carrera;
	public Ex2_Estudiante(int codigo, String nombre, String carrera){
		this.codigo=codigo; 
		this.carrera=carrera;
		this.nombre=nombre; 
	}
	public String getCarrera() {
		return carrera;
	}
	public int getCodigo() {
		return codigo;
	}
	public String getNombre() {
		return nombre;
	}
}
