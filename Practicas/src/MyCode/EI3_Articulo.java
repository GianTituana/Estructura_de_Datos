package MyCode;

public class EI3_Articulo {
	private String nombre;
	private double precio;
	private boolean existe; //0 no existe, 1 existe 
	public EI3_Articulo(String nombre,double precio,boolean existe) {
		// TODO Auto-generated constructor stub
		this.nombre=nombre;
		this.precio=precio;
		this.existe=existe;
	}
	public String getNombre() {
		return nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public boolean exist() {
		return existe;
	}
}
