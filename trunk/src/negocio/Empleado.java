package negocio;

import javax.persistence.*;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Empleado {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	protected int idEmpleado;
	protected String nombre;
	protected String clave;

	public Empleado(int nro, String nombre, String clave) {
		this.idEmpleado = nro;
		this.nombre = nombre;
		this.clave = clave;
	}

	public Empleado() {
	}

	public int getNroEmpleado() {
		return idEmpleado;
	}

	public void setNroEmpleado(int nroEmpleado) {
		this.idEmpleado = nroEmpleado;
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
