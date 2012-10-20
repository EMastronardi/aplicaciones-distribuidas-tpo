package negocio;

import java.util.ArrayList;
import java.util.Collection;

public class Venta {
	private int nroMesa;
	private Collection<Mesa> mesas;
	private Mozo mozo;
	private String estado;
	private Collection<ItemVenta> itemsVenta;

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

	public void setItemsVenta(Collection<ItemVenta> itemsVenta) {
		this.itemsVenta = itemsVenta;
	}
	
	public void cerrarVenta(){
		for (Mesa mesa : mesas) {
			mesa.setEstado("Disponible");
		}
		this.estado = "Cerrada";
	}
}
