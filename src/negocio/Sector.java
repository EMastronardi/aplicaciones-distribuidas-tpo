package negocio;

import java.util.Collection;

public class Sector {
	private String nombre;
	private Collection<Mesa> mesas;
	private Collection<Mozo> mozos;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(Collection<Mesa> mesas) {
		this.mesas = mesas;
	}

	public Collection<Mozo> getMozos() {
		return mozos;
	}

	public void setMozos(Collection<Mozo> mozos) {
		this.mozos = mozos;
	}

	public Sector(String nombre, Collection<Mesa> mesas, Collection<Mozo> mozos) {
		this.nombre = nombre;
		this.mesas = mesas;
		this.mozos = mozos;
	}

}
