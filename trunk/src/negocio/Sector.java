package negocio;

import java.util.Collection;
import java.util.List;

public class Sector {
	private String nombre;
	private List<Mesa> mesas;
	private List<Mozo> mozos;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}

	public Collection<Mozo> getMozos() {
		return mozos;
	}

	public void setMozos(List<Mozo> mozos) {
		this.mozos = mozos;
	}

	public Sector(String nombre, List<Mesa> mesas, List<Mozo> mozos) {
		this.nombre = nombre;
		this.mesas = mesas;
		this.mozos = mozos;
	}

}
