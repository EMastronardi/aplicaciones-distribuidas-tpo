package negocio;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "Ventas")
public class Venta {
	@Transient
	private static int ultNumVenta = 0;
	@Id
	private int nroVenta;
	private int nroMesa;

	private static int getProxNroVenta() {
		ultNumVenta++;
		return ultNumVenta;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Collection<Mesa> mesas;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Mozo mozo;
	private String estado;

	@OneToMany(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Collection<ItemVenta> itemsVenta;

	public Venta(int nroMesa, Collection<Mesa> mesas, Mozo mozo, String estado) {
		super();
		this.nroMesa = nroMesa;
		this.mesas = mesas;
		this.mozo = mozo;
		this.estado = estado;
		this.itemsVenta = new ArrayList<ItemVenta>();
		this.nroVenta = this.getProxNroVenta();
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

	public void setItemsVenta(Collection<ItemVenta> itemsVenta) {
		this.itemsVenta = itemsVenta;
	}

	public void cerrarVenta() {
		for (Mesa mesa : mesas) {
			mesa.setEstado("Disponible");
		}
		this.estado = "Cerrada";
	}
}
