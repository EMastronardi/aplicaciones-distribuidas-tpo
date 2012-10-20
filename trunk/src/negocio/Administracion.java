package negocio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import vista.ViewItemPlanProduccion;

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
	
	public void CrearPlanProduccion(Sucursal sucursal, int tiempo,Date fecha, ArrayList<ViewItemPlanProduccion> items){
		PlanProduccion pp = new PlanProduccion(sucursal, tiempo, fecha, "");
		//creo objetos itemPlanProd, los agrego
		for (ViewItemPlanProduccion viewItmPlan : items) {
			pp.addItemPlaneado(viewItmPlan.getNombreSemielaborad(), viewItmPlan.getCantidad());
		}
		this.planesProduccion.add(pp);
	}

	public void ejecutarPlanProduccion(ArrayList<ViewItemPlanProduccion> itemsRealizados) {
		PlanProduccion pp = getPlanProduccionActual();
		//por cada itemRealizado, actualizo el plan de produccion con lo realizado
		for (ViewItemPlanProduccion viewItmPlanProd: itemsRealizados) {
			pp.modificarItemPlanProd(viewItmPlanProd.getNombreSemielaborad(), viewItmPlanProd.getCantidadFinalizada());
		}
		
		//genero y disminuyo el Stock de Productos
		/*
		 * 
		 * Uff aca se me complic�! tengo que poner el stock generado, en que dep�sito? Si cada area de producci�nn
		 * genera su propio stock, tenemos que tocar un poco el diagrama.. Desp lo charlamos!
		 * 
		 * */
		
		//
	}

	private PlanProduccion getPlanProduccionActual() {
		Date fechaActual = new Date();
		for (PlanProduccion pp : planesProduccion) {
			if(pp.getFecha().compareTo(fechaActual) == 0 )
				return pp;
		}
		return null;
	}
}
