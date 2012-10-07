package negocio;

import java.util.Collection;

public class Area {
	protected Collection<Plato> platos;
	protected Collection<ItemStock> stock;
	protected Collection<ListaReposicion> listasReposicion;

	public Collection<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(Collection<Plato> platos) {
		this.platos = platos;
	}

	public Collection<ItemStock> getStock() {
		return stock;
	}

	public void setStock(Collection<ItemStock> stock) {
		this.stock = stock;
	}

	public Collection<ListaReposicion> getListasReposicion() {
		return listasReposicion;
	}

	public void setListasReposicion(Collection<ListaReposicion> listasReposicion) {
		this.listasReposicion = listasReposicion;
	}

	public Area(Collection<Plato> platos, Collection<ItemStock> stock,
			Collection<ListaReposicion> listasReposicion) {
		this.platos = platos;
		this.stock = stock;
		this.listasReposicion = listasReposicion;
	}
	
}
