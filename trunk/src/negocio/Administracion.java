package negocio;

import java.util.ArrayList;

import controlador.Sistema;

public class Administracion {
	private ArrayList<PlanProduccion> planesProduccion;
	private ArrayList<OrdenCompra> ordenesCompra;
	private ArrayList<NotaDevolucion> notasDevolucion;
	
	public Administracion() {
		super();
	}
	
	public ArrayList<PlanProduccion> getPlanesProduccion() {
		return planesProduccion;
	}
	
	public void setPlanesProduccion(ArrayList<PlanProduccion> planesProduccion) {
		this.planesProduccion = planesProduccion;
	}
	
	public ArrayList<OrdenCompra> getOrdenesCompra() {
		return ordenesCompra;
	}
	
	public void setOrdenesCompra(ArrayList<OrdenCompra> ordenesCompra) {
		this.ordenesCompra = ordenesCompra;
	}
	
	public ArrayList<NotaDevolucion> getNotasDevolucion() {
		return notasDevolucion;
	}
	
	public void setNotasDevolucion(ArrayList<NotaDevolucion> notasDevolucion) {
		this.notasDevolucion = notasDevolucion;
	}
	
	public void generarOrdenesCompra(){
		ArrayList<OrdenCompra> ordenesNuevas = new ArrayList<OrdenCompra>();
		
		ordenesNuevas = Sistema.getInstance().generarOrdenesCompra();
		
		if (ordenesNuevas != null)
			ordenesCompra.addAll(ordenesNuevas);
	}
}
