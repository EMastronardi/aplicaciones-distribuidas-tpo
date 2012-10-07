package negocio;

import java.util.Collection;

public class Ingrediente extends Producto {
	protected boolean fresco;

	public boolean isFresco() {
		return fresco;
	}

	public void setFresco(boolean fresco) {
		this.fresco = fresco;
	}

	public Ingrediente(String categorizacion, String nombre,
			Collection<Proveedor> proveedores, boolean fresco) {
		super(categorizacion, nombre, proveedores);
		this.fresco = fresco;
	}
	
}
