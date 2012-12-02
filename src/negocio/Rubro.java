package negocio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Rubros")
public class Rubro {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idRubro;
	private String nombre;
	@OneToMany
	@JoinColumn(name="idRubro")
	private List<Plato> platos;
	
	public Rubro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Rubro(int idRubro, String nombre, List<Plato> platos) {
		super();
		this.idRubro = idRubro;
		this.nombre = nombre;
		this.platos = platos;
	}
	
	public int getIdRubro() {
		return idRubro;
	}
	public void setIdRubro(int idRubro) {
		this.idRubro = idRubro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Plato> getPlatos() {
		return platos;
	}
	public void setPlatos(List<Plato> platos) {
		this.platos = platos;
	}
	
}
