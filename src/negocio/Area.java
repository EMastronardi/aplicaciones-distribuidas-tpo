package negocio;

import java.util.Collection;

public class Area {
	private Collection<Plato> platos;
	private Collection<ListaReposicion> listasReposicion;
	private Deposito deposito;
	private String nombre;
	private int cantHoras;
	
	public int getCantHoras() {
		return cantHoras;
	}

	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

	public Deposito getDeposito() {
		return deposito;
	}

	public Collection<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(Collection<Plato> platos) {
		this.platos = platos;
	}

	public Collection<ListaReposicion> getListasReposicion() {
		return listasReposicion;
	}

	public void setListasReposicion(Collection<ListaReposicion> listasReposicion) {
		this.listasReposicion = listasReposicion;
	}

	public Area(Collection<Plato> platos, Collection<ItemStock> stock, Collection<ListaReposicion> listasReposicion, String nombre, Deposito depo, int cantHoras) {
		this.platos = platos;
		this.listasReposicion = listasReposicion;
		this.deposito = depo;
		this.nombre = nombre;
		this.cantHoras = cantHoras;
	}
}
