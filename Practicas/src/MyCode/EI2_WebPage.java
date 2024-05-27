package MyCode;

public class EI2_WebPage {
	private String url;
	private String nombre;
	public EI2_WebPage(String nombre,String url) {
		this.url=url;
		this.nombre=nombre;
	}
	public String getNombre() {
		return nombre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url=url;
	}
	public void setNombre(String nombre) {
		this.nombre=nombre;
	}
}
