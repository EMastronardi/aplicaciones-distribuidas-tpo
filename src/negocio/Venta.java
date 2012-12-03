package negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name = "Ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idVenta;
	private int nroMesa;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Mesa> mesas;
	@ManyToOne
	@JoinColumn(name="idMozo")
	private Mozo mozo;
	private String estado;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idVenta")
	private List<ItemVenta> itemsVenta;
	
	public Venta(int nroMesa, List<Mesa> mesas, Mozo mozo, String estado) {
		super();
		this.nroMesa = nroMesa;
		this.mesas = mesas;
		this.mozo = mozo;
		this.estado = estado;
		this.itemsVenta = new ArrayList<ItemVenta>();
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getNroMesa() {
		return nroMesa;
	}

	public void setNroMesa(int nroMesa) {
		this.nroMesa = nroMesa;
	}

	public Collection<ItemVenta> getItemsVenta() {
		return itemsVenta;
	}

	public void setItemsVenta(List<ItemVenta> itemsVenta) {
		this.itemsVenta = itemsVenta;
	}

	public void cerrarVenta() {
		for (Mesa mesa : mesas) {
			mesa.setEstado("Disponible");
		}
		this.estado = "Cerrada";
	}
	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Venta() {
	
	}
}
