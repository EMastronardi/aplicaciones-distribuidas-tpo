package controlador;

import interfaz.InterfazRemota;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import negocio.Administracion;
import negocio.Area;
import negocio.DepositoCentral;
import negocio.ItemBillete;
import negocio.Mesa;
import negocio.Mozo;
import negocio.Plato;
import negocio.Producto;
import negocio.Sucursal;

import org.hibernate.Session;

import persistencia.HibernateUtil;
import persistencia.MesaDAO;
import persistencia.PlatoDAO;
import persistencia.SucursalDAO;
import persistencia.UsuarioDAO;
import rmi.ServerRMI;
import vista.ViewItemPlanProduccion;
import beans.PlatoVO;
import beans.SucursalVO;
import beans.VentaVO;

public class Sistema {

	private List<Sucursal> sucursales;
	private Administracion administracion;
	private DepositoCentral depositoCentral;
	private List<Producto> productos;

	private static Sistema instance = null;

	public static Sistema getInstance() {
		if (instance == null)
			instance = new Sistema();
		return instance;
	}

	public static void main(String[] args) {

		System.out.println("Arranco el sistema");
		
		List<Integer> nrosMesas = new ArrayList<>();
		nrosMesas.add(2);
		
		//Sistema.getInstance().AbrirMesa("Belgrano", nrosMesas , "mozo1", 2);
		try {
			/*
			 * System.setProperty("java.security.policy", "java.policy"); if
			 * (System.getSecurityManager() == null) System.setSecurityManager (
			 * new RMISecurityManager() );
			 */
			LocateRegistry.createRegistry(1099);
			InterfazRemota gestion = new ServerRMI();
			Naming.rebind("//127.0.0.1:1099/Server", gestion);
			System.out.println("Fijado en //127.0.0.1:1099/Server");

		} catch (RemoteException e) {

			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

	private Sistema() {
		sucursales = new ArrayList<Sucursal>();

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
		Session s = HibernateUtil.getSessionFactory().openSession();
		List<Sucursal> list = s.createQuery("From Sucursal s where s.nombre = :nombre").setParameter("nombre", nombre).list();
		if(!list.isEmpty())
			return list.get(0);
		else
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
		administracion.generarOrdenesCompra(depositoCentral
				.controlarExistencias());
	}

	public void crearPlanProduccion(String nombreSucursal, String nombreArea,
			int tiempo, Date fecha, ArrayList<ViewItemPlanProduccion> items) {
		administracion.CrearPlanProduccion(
				buscarSucursalPorNombre(nombreSucursal),
				buscarArea(nombreSucursal, nombreArea), tiempo, fecha, items);
	}

	private Area buscarArea(String nombreSucursal, String nombreArea) {
		Sucursal suc = buscarSucursalPorNombre(nombreSucursal);
		for (Area a : suc.getAreas()) {
			if (a.getNombre().equals(nombreArea))
				return a;
		}
		return null;
	}

	public void ejecutarPlanProduccion(
			ArrayList<ViewItemPlanProduccion> itemsRealizados,
			String nombreSucursal, String nombreArea) {
		administracion.ejecutarPlanProduccion(itemsRealizados, nombreSucursal,
				nombreArea);

	}

	public Producto buscarProductoPorNombre(String nombreProducto) {
		for (Producto prod : productos) {
			if (prod.getNombre().equals(nombreProducto))
				return prod;
		}
		return null;
	}

	public boolean AbrirMesa(String nombreSucursal, List<Integer> nrosMesas,String nombreMozo, int cantComenzales) {
		//Sucursal suc = buscarSucursalPorNombre(nombreSucursal);
		
		Session s = HibernateUtil.getSessionFactory().openSession();
		s.beginTransaction();
		Sucursal suc = (Sucursal) s.createQuery("From Sucursal s where s.nombre = :nombre").setParameter("nombre", nombreSucursal).uniqueResult();
		
		//Mozo mozo = suc.buscarMozo(nombreMozo);
		Mozo mozo = suc.getSalon().obtenerMozo(nombreMozo);
		
		
		List<Mesa> mesas = suc.getSalon().buscarMesas(nrosMesas);
		boolean resultado  = suc.getSalon().abrirMesa(mesas, mozo, cantComenzales);
		if(resultado) {
			s.getTransaction().commit();
			s.close();
		}
		return resultado;
	}

	public List<SucursalVO> getSucursalesVO() {
		return SucursalDAO.getInstancia().obtenerSucursales();
	}

	public boolean validarUsuario(String usuario, String password) {
		return UsuarioDAO.getInstancia().validarUsuario(usuario, password);

	}

	public SucursalVO getSucursal(String usuario) {
		SucursalVO vo = new SucursalVO();
		Sucursal suc = SucursalDAO.getInstancia().obtenerSucursal(usuario);

		vo.setIdSucursal(suc.getIdSucursal());
		vo.setNombre(suc.getNombre());

		return vo;
	}
	
	public List<PlatoVO> getPlatos(String sucursal){
		List<PlatoVO> lista = new ArrayList<PlatoVO>();
		List<Plato> platos = PlatoDAO.getInstancia().getPlatos(sucursal);
		
		for (Plato plato : platos) {
			PlatoVO plvo = new PlatoVO();
			plvo.setIdPlato(plato.getIdPlato());
			plvo.setNombre(plato.getNombre());
			plvo.setPrecio(plato.getPrecio());
			lista.add(plvo);
		}
		return lista;		
	}
	public List<VentaVO> getVentasAbiertas(String sucursal, String nombre){
		List<VentaVO> lista = new ArrayList<VentaVO>();
		
		
		return lista;
	}

	
}
