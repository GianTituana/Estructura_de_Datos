package MyCode;

public class EI7_Puerto {
	String nombre;
	String pais;
	double capacidad; //toneladas de mercancía diaria
	public EI7_Puerto(String nombre,String pais,double capacidad) {
		this.nombre=nombre;
		this.pais=pais;
		this.capacidad=capacidad;
	}
	public void setCapacidad(double capacidad) {
		this.capacidad = capacidad;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	public double getCapacidad() {
		return capacidad;
	}
	public String getNombre() {
		return nombre;
	}
	public String getPais() {
		return pais;
	}
}
