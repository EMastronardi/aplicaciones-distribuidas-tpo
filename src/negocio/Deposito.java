package negocio;

import java.util.Collection;

public class Deposito {
	protected Collection<ItemStock> stock;
	protected Collection<ListaReposicion> pedidosPendientes;
	public Collection<ItemStock> getStock() {
		return stock;
	}

	public void setStock(Collection<ItemStock> stock) {
		this.stock = stock;
	}

	public Deposito(Collection<ItemStock> stock,
			Collection<ListaReposicion> pedidosPendientes) {
		this.stock = stock;
		this.pedidosPendientes = pedidosPendientes;
	}

	public Collection<ListaReposicion> getPedidosPendientes() {
		return pedidosPendientes;
	}

	public void setPedidosPendientes(Collection<ListaReposicion> pedidosPendientes) {
		this.pedidosPendientes = pedidosPendientes;
	}

	
}
