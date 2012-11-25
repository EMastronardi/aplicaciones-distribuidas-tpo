package negocio;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name="SemiElaborados")
@PrimaryKeyJoinColumn(name="idIngrediente")
public class SemiElaborado extends Ingrediente {
	@OneToOne(cascade = CascadeType.REFRESH)
	@PrimaryKeyJoinColumn
	private Receta receta;

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public SemiElaborado(String categorizacion, String nombre,
			ArrayList<ItemProveedor> proveedores, boolean fresco, Receta receta) {
		super(categorizacion, nombre, proveedores, fresco);
		this.receta = receta;
	}
	

}
