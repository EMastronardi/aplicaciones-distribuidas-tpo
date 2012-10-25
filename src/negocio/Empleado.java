package negocio;

import javax.persistence.*;


@Entity
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Empleado {
	@Id
	protected int nroEmpleado;
	protected String nombre;
	protected String clave;

	public Empleado(int nro, String nombre, String clave) {
		this.nroEmpleado = nro;
		this.nombre = nombre;
		this.clave = clave;
	}

	public int getNroEmpleado() {
		return nroEmpleado;
	}

	public void setNroEmpleado(int nroEmpleado) {
		this.nroEmpleado = nroEmpleado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

}
