package controlador;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import vista.ViewItemPlanProduccion;

import negocio.Administracion;
import negocio.Area;
import negocio.Barra;
import negocio.Cafeteria;
import negocio.Cocina;
import negocio.DepositoCentral;
import negocio.ItemBillete;
import negocio.OrdenCompra;
import negocio.Producto;
import negocio.Sucursal;

public class Sistema {

	private Collection<Sucursal> sucursales;
	private Administracion administracion;
	private DepositoCentral depositoCentral;
	private Collection<Producto> productos;

	private static Sistema instance = null;

	public static Sistema getInstance() {
		if (instance == null)
			instance = new Sistema();
		return instance;
	}

	private Sistema() {
		sucursales = new ArrayList<Sucursal>();

		cargarDatosIniciales(); // Datos hardcoreados

	}

	private void cargarDatosIniciales() {

		Sucursal suc1 = new Sucursal("Belgrano");
		Area cocina = new Cocina(null, null, null);
		Area bar = new Barra(null, null, null);
		Area cafeteria = new Cafeteria(null, null, null);
		suc1.agregarArea(cocina);
		suc1.agregarArea(bar);
		suc1.agregarArea(cafeteria);
		sucursales.add(suc1);

		Sucursal suc2 = new Sucursal("Caballito");
		Area cocina2 = new Cocina(null, null, null);
		Area bar2 = new Barra(null, null, null);
		Area cafeteria2 = new Cafeteria(null, null, null);
		suc2.agregarArea(cocina2);
		suc2.agregarArea(bar2);
		suc2.agregarArea(cafeteria2);
		sucursales.add(suc2);

		Sucursal suc3 = new Sucursal("Puerto Madero");
		Area cocina3 = new Cocina(null, null, null);
		Area bar3 = new Barra(null, null, null);
		Area cafeteria3 = new Cafeteria(null, null, null);
		suc3.agregarArea(cocina3);
		suc3.agregarArea(bar3);
		suc3.agregarArea(cafeteria3);
		sucursales.add(suc3);
	}

	public void abrirCaja(String nombreSucursal, ArrayList<ItemBillete> billetes) {
		for (Sucursal suc : sucursales) {
			if (suc.getNombre().equals(nombreSucursal)) {
				suc.abrirCaja(billetes);
			}

		}

	}

	public void cerrarCaja(String nombreSucursal,
			ArrayList<ItemBillete> efectivoEnCaja) {
		for (Sucursal suc : sucursales) {
			if (suc.getNombre().equals(nombreSucursal)) {
				suc.cerrarCaja(efectivoEnCaja);
			}
		}
	}

	public Sucursal buscarSucursalPorNombre(String nombre) {
		for (Sucursal suc : sucursales) {
			if (suc.getNombre().equals(nombre)) {
				return suc;
			}
		}
		return null;
	}

	public void generarFactura(String nombreSucursal, int nroMesa) {

		for (Sucursal suc : sucursales) {
			if (suc.getNombre().equals(nombreSucursal)) {
				suc.generarFactura(nroMesa);
			}

		}
	}

	public Administracion getAdministracion() {
		return administracion;
	}

	public void setAdministracion(Administracion administracion) {
		this.administracion = administracion;
	}

	public DepositoCentral getDepositoCentral() {
		return depositoCentral;
	}

	public void setDepositoCentral(DepositoCentral depositoCentral) {
		this.depositoCentral = depositoCentral;
	}

	public void generarOrdenesCompra() {
		administracion.generarOrdenesCompra(depositoCentral.controlarExistencias());
	}

	public void AbrirMesa() {

	}

	public void crearPlanProduccion(String nombreSucursal, int tiempo,
			Date fecha, ArrayList<ViewItemPlanProduccion> items) {
		administracion.CrearPlanProduccion(
				buscarSucursalPorNombre(nombreSucursal), tiempo, fecha, items);
	}
	public void ejecutarPlanProduccion(ArrayList<ViewItemPlanProduccion> itemsRealizados){
		administracion.ejecutarPlanProduccion(itemsRealizados);
		
	}
	public Producto buscarProductoPorNombre(String nombreProducto) {
		for (Producto prod : productos) {
			if (prod.getNombre().equals(nombreProducto))
				return prod;
		}
		return null;
	}

}
