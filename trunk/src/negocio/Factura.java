package negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="Facturas")
public class Factura {
	private static int ultimoNroFactura;
	@Id
	private int idFactura;
	private Date fecha;

	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="idFactura")
    private Venta venta;
	private float total;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idFactura")
	private List<ItemFactura> itemsFactura;

	private static int getProximoNroFactura() {
		ultimoNroFactura++;
		return ultimoNroFactura;
	}

	public int getNumero() {
		return idFactura;
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

	public void setItemsFactura(List<ItemFactura> itemsFactura) {
		this.itemsFactura = itemsFactura;
	}

	public Factura() {
	}

	public Factura(Venta vta) {
		float total=0;
		this.idFactura = getProximoNroFactura();
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
