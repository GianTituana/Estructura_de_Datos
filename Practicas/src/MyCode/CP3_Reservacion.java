package MyCode;

public class CP3_Reservacion {
	CP3_Solicitud solicitud;
	int habitacion;
	CP3_Reservacion(CP3_Solicitud solicitud,int habitacion){
		this.solicitud=solicitud;
		this.habitacion=habitacion;
	}
	public CP3_Solicitud getSolicitud() {
		return solicitud;
	}
	public int getHabitacion() {
		return habitacion;
	}
	public int getCodigo() {
		return solicitud.getCodigo();
	}
	public String getNombreCliente() {
		return solicitud.getNombre();
	}
}
