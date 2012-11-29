package negocio;

import java.util.List;

import javax.persistence.*;


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

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="idReceta")
	private Receta receta;
	private float comisionExtra;

	
	public Plato(){
		
	}
	
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

	public List<Plato> getPlatosAlternativos() {
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
