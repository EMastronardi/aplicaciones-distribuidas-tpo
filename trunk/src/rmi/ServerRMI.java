package rmi;

import interfaz.InterfazRemota;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import negocio.Mesa;
import negocio.Mozo;

import controlador.Sistema;

public class ServerRMI extends UnicastRemoteObject implements InterfazRemota {

	
	protected ServerRMI() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	@Override
	public boolean abrirMesa(String nombreSucursal, int[] nrosMesas, String nombreMozo, int cantComenzales) throws RemoteException {
		return Sistema.getInstance().AbrirMesa(nombreSucursal, nrosMesas,nombreMozo, cantComenzales );
		
	}

}
