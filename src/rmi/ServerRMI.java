package rmi;

import interfaz.InterfazRemota;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import negocio.Mesa;
import persistencia.MesaDAO;
import beans.ComandaVO;
import beans.MesaVO;
import beans.PlatoVO;
import beans.SucursalVO;
import beans.VentaVO;
import controlador.Sistema;

public class ServerRMI extends UnicastRemoteObject implements InterfazRemota {

	
	/** 
	 * 
	 */
	private static final long serialVersionUID = -6783278426212059747L;

	public ServerRMI() throws RemoteException {
		super();
	}

	
	public boolean abrirMesa(String nombreSucursal, List<Integer> nrosMesas, String nombreMozo, int cantComenzales) throws RemoteException {
		return Sistema.getInstance().AbrirMesa(nombreSucursal, nrosMesas,nombreMozo, cantComenzales );
		
	}

	public List<SucursalVO> getSucursales() throws RemoteException {
		System.out.println("Llamado al metodo getSucursales en el server!");
		
		List<SucursalVO> lista = Sistema.getInstance().getSucursalesVO();
		return lista;
	}


	public String getCadena() throws RemoteException {
		System.out.println("Llamado al metodo getCadena en el server!");
		return "Hola";
	}


	
	public boolean validarUsuario(String usuario, String password)
			throws RemoteException {
	
		return Sistema.getInstance().validarUsuario(usuario, password);
		
		
	}


	public SucursalVO getSucursal(String usuario) throws RemoteException {
		System.out.println("Llamado al metodo getSucursales en el server!");
		
		return Sistema.getInstance().getSucursal(usuario);
	}

	
	public List<PlatoVO> getPlatos(String sucursal) throws RemoteException {
		return Sistema.getInstance().getPlatos(sucursal);
	}


	@Override
	public List<VentaVO> getVentasAbiertas(String sucursal, String nombre) {
		return Sistema.getInstance().getVentasAbiertas(sucursal, nombre);
		
	}


	public boolean cerrarVenta(String sucursal, int nroMesa) throws RemoteException {
		
		return Sistema.getInstance().cerrarVenta(sucursal, nroMesa);
	}


	@Override
	public boolean generarComanda(String sucursal, String nombre, Integer mesa, String[] platos,
			String[] cantidad) throws RemoteException {
		// TODO Auto-generated method stub
		return Sistema.getInstance().generarComanda(sucursal, nombre, mesa, platos, cantidad);
	}


	@Override
	public List<ComandaVO> getComandasAbiertas(String sucursal, String nombre)
			throws RemoteException {
		
		return Sistema.getInstance().getComandasAbiertas(sucursal, nombre);
	}


	@Override
	public boolean confirmarComandaRealizada(String idComanda)
			throws RemoteException {
		return Sistema.getInstance().confirmarComanda(idComanda);
	}

}
