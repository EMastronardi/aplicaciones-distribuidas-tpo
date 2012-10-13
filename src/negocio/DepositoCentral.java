package negocio;

import java.util.ArrayList;
import java.util.Collection;

public class DepositoCentral extends Deposito {
	public DepositoCentral(Collection<ItemStock> stock,
			Collection<ListaReposicion> pedidosPendientes) {
		super(stock, pedidosPendientes);
		// TODO Auto-generated constructor stub
	}
	
	private Collection<OrdenCompra> ordenesCompras; 

	public ArrayList<OrdenCompra> generarCompra(){
		return null;
	}
}
