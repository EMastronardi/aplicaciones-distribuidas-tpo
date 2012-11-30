package negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Ventas")
public class Venta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idVenta;
	private int nroMesa;
	
	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Mesa> mesas;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idMozo")
	private Mozo mozo;
	private String estado;

	@OneToMany(cascade = CascadeType.ALL)
	private List<ItemVenta> itemsVenta;
	@OneToOne
	@JoinColumn(name = "idFactura")
	private Factura factura;
	public Venta(int nroMesa, Collection<Mesa> mesas, Mozo mozo, String estado) {
		super();
		this.nroMesa = nroMesa;
		this.mesas = mesas;
		this.mozo = mozo;
		this.estado = estado;
		this.itemsVenta = new ArrayList<ItemVenta>();
	}

	public Collection<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(Collection<Mesa> mesas) {
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
	public Venta() {
	
	}
}
