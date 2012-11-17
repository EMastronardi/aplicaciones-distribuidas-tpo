package negocio;

import javax.persistence.*;

@Entity
@Table(name="ItemsComanda")
public class ItemComanda {
	@Id
	private int idItemComanda;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idPlato")
	private Plato plato;
	private int cantidad;
	
	public ItemComanda(Plato plato, int cantidad) {
		super();
		this.plato = plato;
		this.cantidad = cantidad;
	}

	public ItemComanda() {
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
