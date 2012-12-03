package negocio;

import javax.persistence.*;

@Entity
@Table(name="ItemsReceta")
public class ItemReceta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idItemReceta;
	private float cantidad;
	
	@ManyToOne
	@JoinColumn(name="idIngrediente")
	private Ingrediente ingrediente;

	public ItemReceta() {}
	
	public ItemReceta(int id, float cantidad, Ingrediente ingrediente) {
		this.cantidad = cantidad;
		this.ingrediente = ingrediente;
		this.idItemReceta = id;
	}

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


}
