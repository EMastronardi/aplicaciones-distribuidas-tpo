package negocio;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="ListasReposicion")
public class ListaReposicion {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idListaReposicion;
	private Date fecha;
	private String estado;
	
	@ManyToOne
	@JoinColumn(name="idSucursal")
	private Sucursal sucursal;
	
	@ManyToOne
	@JoinColumn(name="idArea")
	private Area area;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idListaReposicion")
	private List<ItemRepo> items;
	public ListaReposicion(){
		
	}
	public ListaReposicion(Date fecha, String estado, Sucursal sucursal,
			Area area, List<ItemRepo> items) {
		super();
		this.fecha = fecha;
		this.estado = estado;
		this.sucursal = sucursal;
		this.area = area;
		this.items = items;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Sucursal getSucursal() {
		return sucursal;
	}
	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}
	public Area getArea() {
		return area;
	}
	public void setArea(Area area) {
		this.area = area;
	}
	public List<ItemRepo> getItems() {
		return items;
	}
	public void setItems(List<ItemRepo> items) {
		this.items = items;
	}
}
