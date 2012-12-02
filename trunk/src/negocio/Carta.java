package negocio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Cartas")
public class Carta {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCarta;
	private String nombre;
	@OneToOne
	@JoinColumn(name="idSucursal")
	private Sucursal sucursal;
	@OneToMany
	@JoinColumn(name="idCarta")
	private List<Rubro>  rubros;
	
	public Carta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Carta(int idCarta, String nombre, Sucursal sucursal,
			List<Rubro> rubros) {
		super();
		this.idCarta = idCarta;
		this.nombre = nombre;
		this.sucursal = sucursal;
		this.rubros = rubros;
	}

	public int getIdCarta() {
		return idCarta;
	}

	public void setIdCarta(int idCarta) {
		this.idCarta = idCarta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public List<Rubro> getRubros() {
		return rubros;
	}

	public void setRubros(List<Rubro> rubros) {
		this.rubros = rubros;
	}
	
	
	
}
