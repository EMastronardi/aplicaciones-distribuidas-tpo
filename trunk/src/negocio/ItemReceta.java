package negocio;

import javax.persistence.*;

@Entity
@Table(name="ItemsReceta")
public class ItemReceta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idItemReceta;
	private float cantidad;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Ingrediente ingrediente;

	public float getCantidad() {
		return cantidad;
	}

	public int getIdItemReceta() {
		return idItemReceta;
	}

	public void setIdItemReceta(int idItemReceta) {
		this.idItemReceta = idItemReceta;
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

	public ItemReceta(int id, float cantidad, Ingrediente ingrediente) {
		this.cantidad = cantidad;
		this.ingrediente = ingrediente;
		this.idItemReceta = id;
	}

}
