package negocio;

import javax.persistence.*;

@Entity
@Table(name = "ItemsBilletes")
public class ItemBillete {
	@Id
	private int id;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Billete billete;
	private int cantidad;

	public Billete getBillete() {
		return billete;
	}

	public void setBillete(Billete billete) {
		this.billete = billete;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public ItemBillete(Billete billete, int cantidad) {
		this.billete = billete;
		this.cantidad = cantidad;
	}

}
