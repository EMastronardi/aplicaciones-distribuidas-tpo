package negocio;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name="Insumos")
public class Insumo extends Producto {

	
	public Insumo(String categorizacion, String nombre,
			ArrayList<ItemProveedor> proveedores) {
		super(categorizacion, nombre, proveedores);
		// TODO Auto-generated constructor stub
	}

}
