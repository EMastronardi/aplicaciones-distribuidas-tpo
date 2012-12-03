package negocio;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import controlador.Sistema;

@Entity
@Table(name="PlanesProduccion")
public class PlanProduccion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idPlanProduccion;
	@ManyToOne
	@JoinColumn(name="idSucursal")
	private Sucursal sucursal;
	@ManyToOne
	@JoinColumn(name="idArea")
	private Area area;
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idPlanProduccion")
	private List<ItemPlanProduccion> itemsPlaneados;
	private int tiempo;
	private Date fecha;
	private String estado;
	
	public int getIdPlanProduccion() {
		return idPlanProduccion;
	}

	public void setIdPlanProduccion(int idPlanProduccion) {
		this.idPlanProduccion = idPlanProduccion;
	}

	public Sucursal getSucursal() {
		return sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public int getTiempo() {
		return tiempo;
	}

	public void setTiempo(int tiempo) {
		this.tiempo = tiempo;
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

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}
	
	public PlanProduccion(Sucursal sucursal, Area area, int tiempo,
			Date fecha, String estado) {
		super();
		this.sucursal = sucursal;
		this.area = area;
		this.itemsPlaneados = new ArrayList<ItemPlanProduccion>();
		this.tiempo = tiempo;
		this.fecha = fecha;
		this.estado = estado;
	}

	public PlanProduccion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void addItemPlaneado(String nombreSemielaborad, float cantidad) {
		SemiElaborado semi = (SemiElaborado) Sistema.getInstance()
				.buscarProductoPorNombre(nombreSemielaborad);
		for (ItemPlanProduccion itmPlan : itemsPlaneados) {
			if (itmPlan.getItem().getNombre().equals(semi.getNombre()))
				itmPlan.setCantidad(itmPlan.getCantidad() + cantidad);
			return;
		}
		ItemPlanProduccion iplan = new ItemPlanProduccion(semi, cantidad, 0);
		itemsPlaneados.add(iplan);
	}

	public void modificarItemPlanProd(String nombreSemielaborado, float cantidadProducida) {
		for (ItemPlanProduccion itmPlaneado : itemsPlaneados) {
			if (itmPlaneado.getItem().getNombre().equals(nombreSemielaborado))
				itmPlaneado.setCantidad(cantidadProducida);
		}
	};

}
