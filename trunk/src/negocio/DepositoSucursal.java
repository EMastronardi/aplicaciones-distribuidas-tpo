package negocio;

import java.util.Collection;

public class DepositoSucursal extends Deposito {

	public DepositoSucursal(Collection<ItemStock> stock,
			Collection<ListaReposicion> pedidosPendientes) {
		super(stock, pedidosPendientes);
	}

}
