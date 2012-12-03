package negocio;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import controlador.Sistema;
import vista.ViewItemPlanProduccion;

public class Administracion {
	@OneToMany
	@JoinColumn(name="idPlanProduccion")
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
	
	public void generarOrdenesCompra(ArrayList<ListaReposicion> listaRepo){
		ArrayList<OrdenCompra> ordenesNuevas = new ArrayList<OrdenCompra>();

		if (ordenesNuevas != null)
			ordenesCompra.addAll(ordenesNuevas);
	}

	public void CrearPlanProduccion(Sucursal sucursal, Area area, int tiempo,
			Date fecha, ArrayList<ViewItemPlanProduccion> items) {
		PlanProduccion pp = getPlanProduccionPorFecha(fecha);
		if (pp == null)
			pp = new PlanProduccion(sucursal, area, tiempo, fecha, "");

		// creo objetos itemPlanProd, los agrego buscando si primero no existen,
		// y en caso que existan solo incremento su cantidad.
		for (ViewItemPlanProduccion viewItmPlan : items) {
			pp.addItemPlaneado(viewItmPlan.getNombreSemielaborad(),
					viewItmPlan.getCantidad());
		}
		this.planesProduccion.add(pp);
	}

	private PlanProduccion getPlanProduccionPorFecha(Date fecha) {
		for (PlanProduccion plan : planesProduccion) {
			if (plan.getFecha().equals(fecha))
				return plan;
		}
		return null;
	}

	public void ejecutarPlanProduccion(
			ArrayList<ViewItemPlanProduccion> itemsRealizados,
			String nombreSucursal, String nombreArea) {
		PlanProduccion pp = getPlanProduccionActual(nombreSucursal, nombreArea);
		// por cada itemRealizado, actualizo el plan de produccion con lo
		// realizado
		if (pp != null) {
			Deposito dep = pp.getArea().getDeposito();

			for (ViewItemPlanProduccion viewItmPlanProd : itemsRealizados) {
				pp.modificarItemPlanProd(viewItmPlanProd.getNombreSemielaborad(),viewItmPlanProd.getCantidadFinalizada());
				// alta de semielaborados
				Producto p = Sistema.getInstance().buscarProductoPorNombre(viewItmPlanProd.getNombreSemielaborad());
				Date d = new Date();
				d.setYear(d.getYear()+1);
				dep.sumarInventario(viewItmPlanProd.getCantidadFinalizada(),new Lote("PP",true,d,p));
				// baja de insumos consumidos
				//obtengo receta
				SemiElaborado semi = (SemiElaborado)p;
				Receta rec = semi.getReceta();
				for (ItemReceta ir : rec.getItemsReceta()) { // Descuento los items correspondientes
					dep.restarInventario((Producto)ir.getIngrediente(), ir.getCantidad()*viewItmPlanProd.getCantidadFinalizada());
				}
			}
		}
	}

	private PlanProduccion getPlanProduccionActual(String nombreSucursal,
			String nombreArea) {
		Date fechaActual = new Date();
		for (PlanProduccion pp : planesProduccion) {
			if (pp.getFecha().compareTo(fechaActual) == 0
					&& pp.getSucursal().getNombre().equals(nombreSucursal)
					&& pp.getArea().getNombre().equals(nombreArea))
				return pp;
		}
		return null;
	}
}
