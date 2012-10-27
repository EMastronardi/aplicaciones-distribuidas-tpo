package negocio;

import java.util.ArrayList;

import javax.persistence.*;

@Entity
@Table(name="Ingredientes")
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Ingrediente extends Producto {
	protected boolean fresco;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	protected int idIngrediente;
	public boolean isFresco() {
		return fresco;
	}

	public void setFresco(boolean fresco) {
		this.fresco = fresco;
	}

	public Ingrediente(String categorizacion, String nombre,
			ArrayList<ItemProveedor> proveedores, boolean fresco) {
		super(categorizacion, nombre, proveedores);
		this.fresco = fresco;
	}
	
}
