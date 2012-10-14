package controlador;

public class ViewItemPlanProduccion {
	private String nombreSemielaborad;
	private float cantidad;
	public ViewItemPlanProduccion(String nombreSemielaborad, float cantidad) {
		this.nombreSemielaborad = nombreSemielaborad;
		this.cantidad = cantidad;
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
