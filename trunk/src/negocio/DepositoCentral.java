package negocio;

import java.util.ArrayList;
import java.util.Collection;

public class DepositoCentral extends Deposito {
	private ArrayList<ListaReposicion> pedidos;

	public DepositoCentral(Collection<ItemStock> stock,
			Collection<ListaReposicion> pedidosPendientes,
			ArrayList<ListaReposicion> pedidos) {
		super(stock);
		this.pedidos = pedidos;
	}

	public ArrayList<ListaReposicion> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<ListaReposicion> pedidos) {
		this.pedidos = pedidos;
	}
	
	public ArrayList<ListaReposicion> controlarExistencias(){
		return null;
	}
	
}
