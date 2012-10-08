package negocio;

import java.util.Collection;

public class Salon {
	private String nombre;
	private Collection<Mesa> mesas;

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

	public Salon(String nombre, Collection<Mesa> mesas) {
		this.nombre = nombre;
		this.mesas = mesas;
	}

}
