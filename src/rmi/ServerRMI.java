package rmi;

import interfaz.InterfazRemota;

import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import beans.SucursalVO;

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

		List<SucursalVO> lista = Sistema.getInstance().getSucursalesVO();
		return lista;
	}


	public String getCadena() throws RemoteException {
		System.out.println("Llamado al metodo getCadena en el server!");
		return "Hola";
	}

}
