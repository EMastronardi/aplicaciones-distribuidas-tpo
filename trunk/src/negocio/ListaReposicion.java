package negocio;

import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="ListasReposicion")
public class ListaReposicion {
	@Id
	private int id;
	private Date fecha;
	private String estado;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Sucursal sucursal;
	
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Area area;

	@OneToMany(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private List<ItemRepo> items;

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
