package MyCode;

public class CP2_TEstud {
	String nombre;
	int edad;
	double[] notas; 
	public CP2_TEstud(String nombre, int edad){
		this.nombre=nombre;
		this.edad=edad;
		//this.notas=notas;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public Double getPromedio() {
		double suma=0;
		for(int i=0;i<5;i++) {
			suma=suma+notas[i];
		}
		return suma/5;
	}
}
