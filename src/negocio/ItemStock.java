package negocio;

import javax.persistence.*;

@Entity
@Table(name="ItemsStock")
public class ItemStock {
	@Id
	private int id;
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Lote lote;
	private float cantidad;

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public ItemStock(Lote lote, float cantidad) {
		this.lote = lote;
		this.cantidad = cantidad;
	}

}
