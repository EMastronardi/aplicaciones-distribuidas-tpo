package negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import controlador.Sistema;

public class PlanProduccion {
	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	private Sucursal sucursal;
	private Area area;
	private Collection<ItemPlanProduccion> itemsPlaneados;
	private int tiempo;
	private Date fecha;
	private String estado;

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

	public PlanProduccion(Sucursal sucursal, Area area, int tiempo, Date fecha,
			String estado) {
		this.sucursal = sucursal;
		this.area = area;
		this.tiempo = tiempo;
		this.fecha = fecha;
		this.estado = estado;
		itemsPlaneados = new ArrayList<ItemPlanProduccion>();
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
