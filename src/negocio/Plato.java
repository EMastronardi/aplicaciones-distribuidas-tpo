package negocio;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Platos")
public class Plato {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPlato;
	private String nombre;
	private float precio;
	@ManyToMany
	private List<Plato> platosAlternativos;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idArea")
	private Area area;

	public Plato(){}
	
	public Plato(String nombre, float precio, List<Plato> platosAlternativos,
			Area area, float comisionExtra, Receta receta) {
		this.nombre = nombre;
		this.precio = precio;
		this.platosAlternativos = platosAlternativos;
		this.area = area;
		this.comisionExtra = comisionExtra;
		this.receta = receta;
	}
	public int getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	private float comisionExtra;
	@OneToOne(cascade = CascadeType.ALL)
	private Receta receta;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Collection<Plato> getPlatosAlternativos() {
		return platosAlternativos;
	}

	public void setPlatosAlternativos(List<Plato> platosAlternativos) {
		this.platosAlternativos = platosAlternativos;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public float getComisionExtra() {
		return comisionExtra;
	}

	public void setComisionExtra(float comisionExtra) {
		this.comisionExtra = comisionExtra;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	

}
