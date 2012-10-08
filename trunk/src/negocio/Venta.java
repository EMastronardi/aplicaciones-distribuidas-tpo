package negocio;

import java.util.Collection;

public class Venta {
	private int nroMesa;
	private Collection<Mesa> mesas;
	private Collection<Comanda> comandas;
	private Mozo mozo;
	private String estado;
	private Collection<ItemVenta> itemsVenta;

	public Collection<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(Collection<Mesa> mesas) {
		this.mesas = mesas;
	}

	public Collection<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(Collection<Comanda> comandas) {
		this.comandas = comandas;
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
}
