package negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import controlador.Sistema;

public class PlanProduccion {
	private Sucursal sucursal;
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
	public PlanProduccion(Sucursal sucursal, int tiempo, Date fecha,
			String estado) {
		this.sucursal = sucursal;
		this.tiempo = tiempo;
		this.fecha = fecha;
		this.estado = estado;
		itemsPlaneados = new ArrayList<ItemPlanProduccion>();
	}
	
	public void addItemPlaneado(String nombreSemielaborad, float cantidad) {
		SemiElaborado semi = (SemiElaborado)Sistema.getInstance().buscarProductoPorNombre(nombreSemielaborad);
		ItemPlanProduccion iplan = new ItemPlanProduccion(semi, cantidad, 0);
		itemsPlaneados.add(iplan);
	}

}
