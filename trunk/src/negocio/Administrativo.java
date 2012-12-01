package negocio;

import javax.persistence.*;

@Entity
@Table(name="Administrativos")
public class Administrativo extends Empleado {
	
	public Administrativo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Administrativo(int nro, String nombre, String clave) {
		super(nro, nombre, clave);
		// TODO Auto-generated constructor stub
	}
}
