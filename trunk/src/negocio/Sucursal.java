package negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;

import persistencia.HibernateUtil;

import controlador.Sistema;

@Entity
@Table(name = "Sucursales")
public class Sucursal {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idSucursal;
	private String nombre;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idSucursal")
	private List<Area> areas;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idSalon")
	private Salon salon;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idDeposito")
	private Deposito deposito;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idCaja")
	private Caja caja;


	//private List<Comision> comisiones;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idSucursal")
	private List<Venta> ventas;

	public Sucursal(String nombre) {
		this.nombre = nombre;
		areas = new ArrayList<Area>();
		salon = new Salon("salon1", null);
		deposito = new Deposito(null);
		caja = new Caja();
		//comisiones = new ArrayList<Comision>();
		ventas = new ArrayList<Venta>();
	}

	public String getNombre() {
		return nombre;
	}

	public int getIdSucursal() {
		return idSucursal;
	}

	public void setIdSucursal(int idSucursal) {
		this.idSucursal = idSucursal;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	/*public Collection<Comision> getComisiones() {
		return comisiones;
	}

	public void setComisiones(List<Comision> comisiones) {
		this.comisiones = comisiones;
	}*/

	public void agregarArea(Area area) {
		areas.add(area);
	}


	public void abrirCaja(ArrayList<ItemBillete> billetes) {
		this.caja.aperturaCajaDiaria(billetes);

	}

	public void cerrarCaja(ArrayList<ItemBillete> efectivoEnCaja) {
		this.caja.cerrarCajaDiaria(efectivoEnCaja);
	}

	public void cerrarVenta(Venta venta) {
		caja.generarFactura(venta);
		venta.cerrarVenta();
	}

	public Mozo buscarMozo(String nombreMozo) {
		 Session s = HibernateUtil.getSessionFactory().openSession();
		 Mozo m = (Mozo)s.createQuery("From Mozo m where m.nombre = "+nombreMozo).list();
		 return m;
	}
	
	public Venta buscarVenta(int venta){
		Session s = HibernateUtil.getSessionFactory().openSession();
		return (Venta)s.createQuery("From Venta v where v.nroMesa = "+venta).list();
	}
}
