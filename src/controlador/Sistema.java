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
import negocio.Comanda;
import negocio.DepositoCentral;
import negocio.ItemBillete;
import negocio.ItemComanda;
import negocio.ItemVenta;
import negocio.Mesa;
import negocio.Mozo;
import negocio.Plato;
import negocio.Producto;
import negocio.Sucursal;
import negocio.Venta;

import org.hibernate.Session;

import persistencia.ComandaDAO;
import persistencia.HibernateUtil;
import persistencia.PlatoDAO;
import persistencia.SucursalDAO;
import persistencia.UsuarioDAO;
import persistencia.VentaDAO;
import rmi.ServerRMI;
import vista.ViewItemPlanProduccion;
import beans.ComandaVO;
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
		
		try {
		
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
		Session s = HibernateUtil.getCurrent();
		List<Sucursal> list = s
				.createQuery("From Sucursal s where s.nombre = :nombre")
				.setParameter("nombre", nombre).list();
		if (!list.isEmpty())
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

	public boolean AbrirMesa(String nombreSucursal, List<Integer> nrosMesas,
			String nombreMozo, int cantComenzales) {
		// Sucursal suc = buscarSucursalPorNombre(nombreSucursal);

		Session s = HibernateUtil.getCurrent();
		s.beginTransaction();
		Sucursal suc = (Sucursal) s
				.createQuery("From Sucursal s where s.nombre = :nombre")
				.setParameter("nombre", nombreSucursal).uniqueResult();

		// Mozo mozo = suc.buscarMozo(nombreMozo);
		Mozo mozo = suc.getSalon().obtenerMozo(nombreMozo);

		List<Mesa> mesas = suc.getSalon().buscarMesas(nrosMesas);
		boolean resultado = suc.getSalon().abrirMesa(mesas, mozo,
				cantComenzales);
		if (resultado) {
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

	public List<PlatoVO> getPlatos(String sucursal) {
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

	public List<VentaVO> getVentasAbiertas(String sucursal, String nombre) {
		List<VentaVO> lista = new ArrayList<VentaVO>();
		List<Venta> ventasActivas = VentaDAO.getInstancia().getVentasActivas(
				sucursal, nombre);
		for (Venta venta : ventasActivas) {
			VentaVO vvo = new VentaVO();
			vvo.setEstado(venta.getEstado());
			vvo.setIdVenta(venta.getIdVenta());
			vvo.setNroMesa(venta.getNroMesa());
			System.out
					.println("(SERVER) getVEntasABIERTAS " + vvo.getNroMesa());
			lista.add(vvo);
		}
		return lista;
	}

	public boolean cerrarVenta(String sucursal, int nroMesa) {

		Session s = HibernateUtil.getCurrent();
		Venta venta = (Venta) s
				.createQuery(
						"Select v from Sucursal s join s.salon.ventasAbiertas v where s.nombre = :nombre and v.nroMesa = :nroMesa")
				.setParameter("nombre", sucursal)
				.setParameter("nroMesa", nroMesa).uniqueResult();

		return false;
	}

	public boolean generarComanda(String sucursal, String nombreMozo,
			Integer mesa, String[] platos, String[] cantidades) {
		Session s = HibernateUtil.getCurrent();
		s.beginTransaction();
		Sucursal suc = (Sucursal) s
				.createQuery("From Sucursal s where s.nombre = :nombre")
				.setParameter("nombre", sucursal).uniqueResult();

		Mozo mozo = suc.getSalon().obtenerMozo(nombreMozo);
		List<Venta> vtas = suc.getSalon().getVentasAbiertas();
		Venta vta = null;
		for (Venta venta : vtas) {
			if (venta.getNroMesa() == mesa) {
				vta = venta;
				break;
			}
		}
		Comanda cmd = new Comanda();
		cmd.setFecha(new Date());
		cmd.setMozo(mozo);
		cmd.setEstado(true);
		cmd.setVenta(vta);
		ArrayList<ItemComanda> listaItems = new ArrayList<ItemComanda>();
		for (int i = 0; i < platos.length; i++) {
			ItemComanda itms = new ItemComanda();
			itms.setCantidad(Integer.parseInt(cantidades[i]));
			itms.setPlato(PlatoDAO.getInstancia().obtenerPlato(
					Integer.parseInt(platos[i])));
			listaItems.add(itms);
		}

		cmd.setItemsComanda(listaItems);

		suc.getSalon().addComanda(cmd);
		s.getTransaction().commit();
		s.close();
		// Guardar La comanda
		// ComandaDAO.getInstancia().grabarComanda(cmd);
		return true;
	}

	public boolean confirmarComanda(String idComanda) {
		Comanda comanda = ComandaDAO.getInstancia().obtenerComanda(Integer.parseInt(idComanda));
		return comanda.confirmarComanda();
	}

	public List<ComandaVO> getComandasAbiertas(String sucursal, String nombre) {
		List<ComandaVO> lista = new ArrayList<ComandaVO>();
		List<Comanda> comandasActivas = ComandaDAO.getInstancia()
				.getComandasActivas(sucursal, nombre);
		for (Comanda comanda : comandasActivas) {
			ComandaVO cvo = new ComandaVO();
			cvo.setIdComanda(comanda.getIdComanda());
			cvo.setFecha(comanda.getFecha());
			System.out.println("(SERVER) getComandasABIERTAS ");
			lista.add(cvo);
		}
		return lista;
	}

}
