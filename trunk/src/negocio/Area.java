package negocio;


import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "Areas")
public class Area {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idArea;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idArea")
	private List<Plato> platos;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idArea")
	private List<ListaReposicion> listasReposicion;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idArea")
	private Deposito deposito;
	private String nombre;
	private int cantHoras;

	public Area() {
	}

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

	public List<Plato> getPlatos() {
		return platos;
	}

	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}

	public List<ListaReposicion> getListasReposicion() {
		return listasReposicion;
	}

	public void setListasReposicion(List<ListaReposicion> listasReposicion) {
		this.listasReposicion = listasReposicion;
	}

	public Area(List<Plato> platos,
			List<ListaReposicion> listasReposicion, String nombre,
			Deposito depo, int cantHoras) {
		this.platos = platos;
		this.listasReposicion = listasReposicion;
		this.deposito = depo;
		this.nombre = nombre;
		this.cantHoras = cantHoras;
	}

	public int getIdArea() {
		return idArea;
	}

	public void setIdArea(int idArea) {
		this.idArea = idArea;
	}
}
