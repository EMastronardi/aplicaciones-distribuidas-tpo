package negocio;

import javax.persistence.*;

@Entity
@Table(name="ItemsFacturas")
public class ItemFactura {
	@Id
	private int idItemFactura;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idPlato")
	private Plato plato;
	private int cantidad;

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) {
		this.plato = plato;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ItemFactura(Plato plato, int cantidad) {
		this.plato = plato;
		this.cantidad = cantidad;
	}

}
