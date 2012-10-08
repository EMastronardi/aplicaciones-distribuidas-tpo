package negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

public class Factura {
	private static int ultimoNroFactura;
	private int numero;
	private Date fecha;
	private Venta venta;
	private float total;
	private Collection<ItemFactura> itemsFactura;

	private static int getProximoNroFactura() {
		ultimoNroFactura++;
		return ultimoNroFactura;
	}

	public int getNumero() {
		return numero;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Collection<ItemFactura> getItemsFactura() {
		return itemsFactura;
	}

	public void setItemsFactura(Collection<ItemFactura> itemsFactura) {
		this.itemsFactura = itemsFactura;
	}

	public Factura(Venta vta) {
		float total=0;
		this.numero = getProximoNroFactura();
		itemsFactura = new ArrayList<ItemFactura>();

		for (ItemVenta itemVenta : vta.getItemsVenta()) {
			if (itemVenta.getEstado().equals("facturable")) {
				ItemFactura itmFact = new ItemFactura(itemVenta.getItem(),
						itemVenta.getCantidad());
				this.itemsFactura.add(itmFact);
				total += itemVenta.getCantidad() * itemVenta.getItem().getPrecio();
			}
		}
		this.total = total;
		this.fecha = new Date();
		this.venta = vta;
	}

}
