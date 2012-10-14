package negocio;

import java.util.ArrayList;
import java.util.Date;

import controlador.Sistema;
import controlador.ViewItemPlanProduccion;

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
	
	public void CrearPlanProduccion(Sucursal sucursal, int tiempo,Date fecha, ArrayList<ViewItemPlanProduccion> items){
		PlanProduccion pp = new PlanProduccion(sucursal, tiempo, fecha, "");
		//creo objetos itemPlanProd, los agrego
		for (ViewItemPlanProduccion viewItmPlan : items) {
			pp.addItemPlaneado(viewItmPlan.getNombreSemielaborad(), viewItmPlan.getCantidad());
		}
		this.planesProduccion.add(pp);
	}
}
