package controlador;

import interfaz.InterfazRemota;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;

import rmi.ServerRMI;

import beans.SucursalVO;

import vista.ViewItemPlanProduccion;

import negocio.*;

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
	public static void main(String[] args) {
		System.out.println("Arrancó el sistema");
		SessionFactory sf = persistencia.HibernateUtil.getSessionFactory();
		sf.openSession();
		try {
			LocateRegistry.createRegistry(1099);
			InterfazRemota gestion = new ServerRMI();
			Naming.rebind("//localhost/Server", gestion);
			System.out.println("Fijado en //localhost/Server");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		
		
		
	}
	private Sistema() {
		sucursales = new ArrayList<Sucursal>();

		cargarDatosIniciales(); // Datos hardcoreados

	}

	private void cargarDatosIniciales() {

		Sucursal suc1 = new Sucursal("Belgrano");
		sucursales.add(suc1);

		Sucursal suc2 = new Sucursal("Caballito");
		sucursales.add(suc2);

		Sucursal suc3 = new Sucursal("Puerto Madero");
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

	

	public void crearPlanProduccion(String nombreSucursal, String nombreArea, int tiempo, Date fecha, ArrayList<ViewItemPlanProduccion> items) {
		administracion.CrearPlanProduccion(buscarSucursalPorNombre(nombreSucursal), buscarArea(nombreSucursal, nombreArea),tiempo, fecha, items);
	}
	private Area buscarArea(String nombreSucursal, String nombreArea) {
		Sucursal suc = buscarSucursalPorNombre(nombreSucursal);
		for (Area a : suc.getAreas()) {
			if(a.getNombre().equals(nombreArea))
				return a;
		}
		return null;
	}

	public void ejecutarPlanProduccion(ArrayList<ViewItemPlanProduccion> itemsRealizados, String nombreSucursal, String nombreArea){
		administracion.ejecutarPlanProduccion(itemsRealizados, nombreSucursal, nombreArea);
		
	}
	public Producto buscarProductoPorNombre(String nombreProducto) {
		for (Producto prod : productos) {
			if (prod.getNombre().equals(nombreProducto))
				return prod;
		}
		return null;
	}
	public boolean AbrirMesa(String nombreSucursal, List<Integer> nrosMesas,String nombreMozo, int cantComenzales) {
		Sucursal suc = buscarSucursalPorNombre(nombreSucursal);
		Mozo mozo  = suc.buscarMozo(nombreMozo);
		Collection<Mesa> mesas = suc.getSalon().buscarMesas(nrosMesas);
		return suc.getSalon().abrirMesa(mesas, mozo, cantComenzales);
	}
	public List<SucursalVO> getSucursalesVO() {
		List<SucursalVO> lista = new ArrayList<SucursalVO>();
		for (Sucursal s : this.sucursales) {
			SucursalVO svo = new SucursalVO();
			svo.setIdSucursal(s.getIdSucursal());
			svo.setNombre(s.getNombre());
			lista.add(svo);
		}
		return lista;
	}
}
