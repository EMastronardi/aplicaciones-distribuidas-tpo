package negocio;

import java.util.Collection;

public class Area {
	protected Collection<Plato> platos;
	//protected Collection<ItemStock> stock;
	protected Collection<ListaReposicion> listasReposicion;
	protected String nombre;
	protected DepositoSucursal deposito;

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public DepositoSucursal getDeposito() {
		return deposito;
	}

	public void setDeposito(DepositoSucursal deposito) {
		this.deposito = deposito;
	}

	public Collection<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(Collection<Plato> platos) {
		this.platos = platos;
	}

//	public Collection<ItemStock> getStock() {
//		return stock;
//	}
//
//	public void setStock(Collection<ItemStock> stock) {
//		this.stock = stock;
//	}

	public Collection<ListaReposicion> getListasReposicion() {
		return listasReposicion;
	}

	public void setListasReposicion(Collection<ListaReposicion> listasReposicion) {
		this.listasReposicion = listasReposicion;
	}

	public Area(Collection<Plato> platos, Collection<ItemStock> stock, Collection<ListaReposicion> listasReposicion, String nombre, DepositoSucursal depo) {
		this.platos = platos;
//		this.stock = stock;
		this.nombre = nombre;
		this.listasReposicion = listasReposicion;
		this.deposito = depo;
	}

	public String getNombre() {
		return nombre;
	}

	
	
}
