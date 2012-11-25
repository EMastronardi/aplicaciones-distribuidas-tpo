package negocio;

import javax.persistence.*;

@Entity
@Table(name="ItemsFacturas")
public class ItemFactura {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idItemFactura;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idPlato")
	private Plato plato;
	private int cantidad;
	public ItemFactura() {}
	public ItemFactura(Plato plato, int cantidad) {
		this.plato = plato;
		this.cantidad = cantidad;
	}
	
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



}
