package rmi;

import interfaz.InterfazRemota;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import beans.SucursalVO;

import controlador.Sistema;

public class ServerRMI extends UnicastRemoteObject implements InterfazRemota {

	
	public ServerRMI() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public boolean abrirMesa(String nombreSucursal, List<Integer> nrosMesas, String nombreMozo, int cantComenzales) throws RemoteException {
		return Sistema.getInstance().AbrirMesa(nombreSucursal, nrosMesas,nombreMozo, cantComenzales );
		
	}

	@Override
	public List<SucursalVO> getSucursales() throws RemoteException {
		List<SucursalVO> lista = Sistema.getInstance().getSucursalesVO();
		return lista;
	}

}
