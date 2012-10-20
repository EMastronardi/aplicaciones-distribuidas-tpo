package vista;

public class ViewItemPlanProduccion {
	private String nombreSemielaborad;
	private float cantidad;
	private float cantidadFinalizada;
	public float getCantidadFinalizada() {
		return cantidadFinalizada;
	}
	public void setCantidadFinalizada(float cantidadFinalizada) {
		this.cantidadFinalizada = cantidadFinalizada;
	}
	public ViewItemPlanProduccion(String nombreSemielaborad, float cantidad) {
		this.nombreSemielaborad = nombreSemielaborad;
		this.cantidad = cantidad;
		this.cantidadFinalizada = 0;
	}
	public String getNombreSemielaborad() {
		return nombreSemielaborad;
	}
	public void setNombreSemielaborad(String nombreSemielaborad) {
		this.nombreSemielaborad = nombreSemielaborad;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
