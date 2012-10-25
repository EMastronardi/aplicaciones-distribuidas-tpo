package negocio;

import javax.persistence.Entity;

@Entity
public class Encargado extends Empleado {

	public Encargado(int nro, String nombre, String clave) {
		super(nro, nombre, clave);
		// TODO Auto-generated constructor stub
	}


}
