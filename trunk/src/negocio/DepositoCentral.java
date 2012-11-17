package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class DepositoCentral extends Deposito {
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idDeposito")
	private List<ListaReposicion> pedidos;

	public DepositoCentral(List<ItemStock> stock,
			List<ListaReposicion> pedidosPendientes,
			ArrayList<ListaReposicion> pedidos) {
		super(stock);
		this.pedidos = pedidos;
	}

	public DepositoCentral() {
	}

	public List<ListaReposicion> getPedidos() {
		return pedidos;
	}

	public void setPedidos(ArrayList<ListaReposicion> pedidos) {
		this.pedidos = pedidos;
	}
	
	public ArrayList<ListaReposicion> controlarExistencias(){
		return null;
	}
	
}
