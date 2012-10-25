package negocio;

import javax.persistence.Entity;

@Entity
public class Administrativo extends Empleado {

	public Administrativo(int nro, String nombre, String clave) {
		super(nro, nombre, clave);
		// TODO Auto-generated constructor stub
	}
}
