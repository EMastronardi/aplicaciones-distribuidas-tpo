package negocio;

public class Mozo extends Empleado {
	private float porcentajeComision;

	public float getPorcentajeComision() {
		return porcentajeComision;
	}

	public void setPorcentajeComision(float porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
	}

	public Mozo(String nombre, String clave, float porcentajeComision) {
		super(nombre, clave);
		this.porcentajeComision = porcentajeComision;
	}
	


}
