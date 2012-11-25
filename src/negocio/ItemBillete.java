package negocio;

import javax.persistence.*;

@Entity
@Table(name = "ItemsBilletes")
public class ItemBillete {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idItemBillete;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idBillete")
	private Billete billete;
	private int cantidad;

	public Billete getBillete() {
		return billete;
	}

	public ItemBillete() {
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
