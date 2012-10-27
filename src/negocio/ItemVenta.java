package negocio;

import javax.persistence.*;

@Entity
@Table(name="ItemsVentas")
public class ItemVenta {
	@Id
	private int id;
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Plato item;
	private int cantidad;
	private String estado;

	public Plato getItem() {
		return item;
	}

	public void setItem(Plato item) {
		this.item = item;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ItemVenta(Plato item, int cantidad, String estado) {
		this.item = item;
		this.cantidad = cantidad;
		this.estado = estado;
	}

}
