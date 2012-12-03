package negocio;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name = "Ingredientes")
@PrimaryKeyJoinColumn(name = "idProducto")
@Inheritance(strategy = InheritanceType.JOINED)
public class Ingrediente extends Producto {
	protected boolean fresco;

	public boolean isFresco() {
		return fresco;
	}

	public void setFresco(boolean fresco) {
		this.fresco = fresco;
	}

	public Ingrediente() {
	}

	public Ingrediente(String categorizacion, String nombre,
			ArrayList<ItemProveedor> proveedores, boolean fresco) {
		super(categorizacion, nombre, proveedores);
		this.fresco = fresco;
	}
}
