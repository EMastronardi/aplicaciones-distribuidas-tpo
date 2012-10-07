package negocio;

import java.util.Collection;

public class ItemReceta {
	private float cantidad;
	private Ingrediente ingrediente;

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public Ingrediente getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(Ingrediente ingrediente) {
		this.ingrediente = ingrediente;
	}

	public ItemReceta(float cantidad, Ingrediente ingrediente) {
		this.cantidad = cantidad;
		this.ingrediente = ingrediente;
	}

}
