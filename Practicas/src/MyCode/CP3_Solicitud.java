package MyCode;

public class CP3_Solicitud {
	private String nombre;
	private int codigo; 
	private String hotel;
	private boolean tipocliente; //0 vip,1 ordinario
	private int estancia; 
	public CP3_Solicitud(String nombre,int codigo,String hotel,boolean tipocliente, int estancia){
		this.nombre=nombre;
		this.codigo=codigo;
		this.hotel=hotel;
		this.tipocliente=tipocliente;
		this.estancia=estancia;
	}
	public String getNombre() {
		return nombre;
	}
	public String getHotel() {
		return hotel;
	}
	public int getCodigo() {
		return codigo;
	}
	public boolean getTipoCliente() {
		return tipocliente;
	}
	public int getEstancia() {
		return estancia;
	}
}
