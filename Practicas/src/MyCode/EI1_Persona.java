package MyCode;

public class EI1_Persona {
	private String nombre;
	private Long id; 
	public EI1_Persona(String nombre,Long id){
		this.nombre=nombre;
		this.id=id;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
	public void setId(Long id) {
		this.id=id;
	}
	public String getNombre() {
		return nombre;
	}
	public Long getId() {
		return id;
	}
}
