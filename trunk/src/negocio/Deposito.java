package negocio;

import java.util.Collection;
import java.util.Date;

public class Deposito {
	protected Collection<ItemStock> stock;
	protected Collection<ListaReposicion> pedidosPendientes;
	
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

	public Collection<ItemStock> getStock() {
		return stock;
	}

	public void setStock(Collection<ItemStock> stock) {
		this.stock = stock;
	}
	
	public boolean ajustarInventario(Producto p, float cant){
		if(buscarLoteMasViejo(p)!=null){
			ItemStock it = buscarLoteMasViejo(p); 
			if(it.getCantidad()>cant){
				it.setCantidad(it.getCantidad()-cant);
				return true;
			}
			return false;
		}
		else 
			return false;
	}
	
	private ItemStock buscarLoteMasViejo(Producto p){
		ItemStock itViejo;
		itViejo = null;
		Date hoy = new Date();
		for(ItemStock it : stock){
			//Pregunto si el Lote no esta dado de Baja
			if(it.getLote().getEstado()){
				//Pregunto si este lote tiene este producto y si es mas viejo que el anterior
				if(it.getLote().getProducto()==p && ((hoy.getTime()-it.getLote().getVencimiento().getTime())>(hoy.getTime()-itViejo.getLote().getVencimiento().getTime()))){
					itViejo = it;
				}
			}
		}
		return itViejo;
	}
	
	public void controlVencimientoLotes(){
		Date hoy = new Date();
		for(ItemStock it : stock){
			if(it.getLote().getVencimiento().getTime()<hoy.getTime()){
				it.getLote().setEstado(false);
			}
		}
	}
}
