package negocio;

import javax.persistence.*;

@Entity
@Table(name="mozos")
public class Mozo extends Empleado {
	private float porcentajeComision;

	public float getPorcentajeComision() {
		return porcentajeComision;
	}

	public void setPorcentajeComision(float porcentajeComision) {
		this.porcentajeComision = porcentajeComision;
	}

	public Mozo(int nro, String nombre, String clave, float porcentajeComision) {
		super(nro, nombre, clave);
		this.porcentajeComision = porcentajeComision;
	}
}
