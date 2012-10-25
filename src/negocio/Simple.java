package negocio;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name="Simples")
public class Simple extends Ingrediente {

	public Simple(String categorizacion, String nombre,
			ArrayList<ItemProveedor> proveedores, boolean fresco) {
		super(categorizacion, nombre, proveedores, fresco);
		// TODO Auto-generated constructor stub
	}

}
