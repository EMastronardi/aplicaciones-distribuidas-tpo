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
import javax.persistence.Table;

import org.hibernate.Session;

import persistencia.HibernateUtil;

@Entity
@Table(name = "CajasDiarias")
public class CajaDiaria {
	@Id
	private int idCajaDiaria;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idCajaDiaria")
	private List<Factura> facturas;
	private String estado;
	private Date fecha;
	private float total;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idCajaDiaria")
	private List<ItemBillete> efectivoTotal;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idCajaDiaria")
	private List<Pago> pagos;
	private Date fechaCierre;

	public CajaDiaria(String estado, Date fecha) {
		this.facturas = new ArrayList<Factura>();
		this.estado = estado;
		this.fecha = fecha;

	}

	public CajaDiaria() {
	}

	public void generarFactura(Venta venta) {
		Factura fact = new Factura(venta);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.save(fact);
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

	public void setFacturas(List<Factura> facturas) {
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

	public void setEfectivoTotal(List<ItemBillete> efectivoTotal) {
		this.efectivoTotal = efectivoTotal;
	}

	public Collection<Pago> getPagos() {
		return pagos;
	}

	public void setPagos(List<Pago> pagos) {
		this.pagos = pagos;
	}
}
