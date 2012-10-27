package negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Sucursales")
public class Sucursal {
	@Id
	private int id;
	private String nombre;
	
	@OneToMany(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private List<Area> areas;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Salon salon;

	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Deposito deposito;
	
	@OneToOne(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Caja caja;
	
	@OneToMany(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private List<Comision> comisiones;
	
	@OneToMany(cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private List<Venta> ventas;
	
	public Sucursal(String nombre) {
		this.nombre = nombre;
		areas = new ArrayList<Area>();
		salon = new Salon("salon1", null);
		deposito = new Deposito(null);
		caja = new Caja();
		comisiones = new ArrayList<Comision>();
		ventas = new ArrayList<Venta>();
	}

	public String getNombre() {
		return nombre;
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

	public Collection<Comision> getComisiones() {
		return comisiones;
	}

	public void setComisiones(List<Comision> comisiones) {
		this.comisiones = comisiones;
	}

	public void agregarArea(Area area) {
		areas.add(area);
	}

	private Venta buscarVenta(int nroMesa) {
		for (Venta v : ventas) {
			if (v.getNroMesa() == nroMesa)
				return v;
		}
		return null;
	}


	public void abrirCaja(ArrayList<ItemBillete> billetes) {
		this.caja.aperturaCajaDiaria(billetes);
		
	}

	public void cerrarCaja(ArrayList<ItemBillete> efectivoEnCaja) {
		this.caja.cerrarCajaDiaria(efectivoEnCaja);
	}
	
	public void cerrarVenta(Venta venta){
		caja.generarFactura(venta);
		venta.cerrarVenta();
	}
}
