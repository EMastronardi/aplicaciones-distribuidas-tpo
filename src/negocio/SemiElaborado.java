package negocio;

import java.util.Collection;

public class SemiElaborado extends Ingrediente {
	private Receta receta;

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public SemiElaborado(String categorizacion, String nombre,
			Collection<Proveedor> proveedores, boolean fresco, Receta receta) {
		super(categorizacion, nombre, proveedores, fresco);
		this.receta = receta;
	}
	

}
