package MyCode;

public class CP4_Paciente {
	String nombre;
	int historia_clinica;
	int edad;
	char sexo;
	public CP4_Paciente() {
		
	}
	public CP4_Paciente(String n,int h,int e, char s) {
		nombre=n;
		historia_clinica=h;
		edad=e;
		sexo=s;
	}
	public String getNombre() {
		return nombre;
	}
	public int getHistoria_clinica() {
		return historia_clinica;
	}
	public int getEdad() {
		return edad;
	}
	public char getSexo() {
		return sexo;
	}
	
}
