package negocio;

import java.util.Collection;

public class Receta {
	private Collection<ItemReceta> itemsReceta;
	private String nombre;

	public Collection<ItemReceta> getItemsReceta() {
		return itemsReceta;
	}

	public void setItemsReceta(Collection<ItemReceta> itemsReceta) {
		this.itemsReceta = itemsReceta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Receta(Collection<ItemReceta> itemsReceta, String nombre) {
		this.itemsReceta = itemsReceta;
		this.nombre = nombre;
	}

}