package negocio;

import java.util.Collection;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Sectores")
public class Sector {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSector;
	private String nombre;
	@OneToMany
	@JoinColumn(name = "idSector")
	private List<Mesa> mesas;

	@OneToMany
	@JoinColumn(name = "idSector")
	private List<Mozo> mozos;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}

	public List<Mozo> getMozos() {
		return mozos;
	}

	public void setMozos(List<Mozo> mozos) {
		this.mozos = mozos;
	}

	public Sector() {
	}

	public Sector(String nombre, List<Mesa> mesas, List<Mozo> mozos) {
		this.nombre = nombre;
		this.mesas = mesas;
		this.mozos = mozos;
	}

}
