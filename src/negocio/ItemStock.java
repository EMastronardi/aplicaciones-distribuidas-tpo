package negocio;

import javax.persistence.*;

@Entity
@Table(name="ItemsStock")
public class ItemStock {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idItemStock;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn( name = "idLote")
	private Lote lote;
	private float cantidad;
	
	public ItemStock() {
	}

	public ItemStock(Lote lote, float cantidad) {
		this.lote = lote;
		this.cantidad = cantidad;
	}

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
}
