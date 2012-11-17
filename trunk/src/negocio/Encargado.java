package negocio;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Encargados")
public class Encargado extends Empleado {

	public Encargado(int nro, String nombre, String clave) {
		super(nro, nombre, clave);
		
	}
	public Encargado(){
		
	}


}
