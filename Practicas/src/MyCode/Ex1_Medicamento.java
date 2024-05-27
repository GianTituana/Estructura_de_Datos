package MyCode;

public class Ex1_Medicamento {
	String nombre;
	String tipo;
	int stock;
	public Ex1_Medicamento(String nombre,String tipo,int stock) {
		this.nombre=nombre;
		this.stock=stock;
		this.tipo=tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public int getStock() {
		return stock;
	}
	public String getTipo() {
		return tipo;
	}
}
