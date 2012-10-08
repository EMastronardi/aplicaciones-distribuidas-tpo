package negocio;

import java.util.Collection;
import java.util.Date;

public class CajaDiaria {
	private Collection<Factura> facturas;
	private String estado;
	private Date fecha;
	private float total;
	private Collection<ItemBillete> efectivoTotal;
	private Collection<Pago> pagos;
	private Date fechaCierre;
	
	public CajaDiaria(Collection<Factura> facturas, String estado, Date fecha) {
		this.facturas = facturas;
		this.estado = estado;
		this.fecha = fecha;

	}

	public Date getFechaCierre() {
		return fechaCierre;
	}

	public void setFechaCierre(Date fechaCierre) {
		this.fechaCierre = fechaCierre;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Collection<Factura> getFacturas() {
		return facturas;
	}

	public void setFacturas(Collection<Factura> facturas) {
		this.facturas = facturas;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Collection<ItemBillete> getEfectivoTotal() {
		return efectivoTotal;
	}

	public void setEfectivoTotal(Collection<ItemBillete> efectivoTotal) {
		this.efectivoTotal = efectivoTotal;
	}

	public Collection<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(Collection<Pago> pagos) {
		this.pagos = pagos;
	}
}
