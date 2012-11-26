package negocio;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Depositos")
@Inheritance(strategy = InheritanceType.JOINED)
public class Deposito {
	@Id
	private int idDeposito;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idDeposito")
	protected List<Movimiento> movimientos;
	
	public Deposito() {
	}

	public Deposito(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}

	public List<Movimiento> getmovimientos() {
		return movimientos;
	}

	public void setMovimientos(List<Movimiento> movimientos) {
		this.movimientos = movimientos;
	}
	
	public boolean ajustarInventario(Producto p, float cant){
		 
			return false;
	}
	
//	private ItemStock buscarLoteMasViejo(Producto p){
//		ItemStock itViejo;
//		itViejo = null;
//		Date hoy = new Date();
//		for(ItemStock it : stock){
//			//Pregunto si el Lote no esta dado de Baja
//			if(it.getLote().getEstado()){
//				//Pregunto si este lote tiene este producto y si es mas viejo que el anterior
//				if(it.getLote().getProducto()==p && ((hoy.getTime()-it.getLote().getVencimiento().getTime())>(hoy.getTime()-itViejo.getLote().getVencimiento().getTime()))){
//					itViejo = it;
//				}
//			}
//		}
//		return itViejo;
//	}

	private ArrayList<Object[]> getStockProducto(Producto p){
		ArrayList<Object[]> loteCantidad = new ArrayList<Object[]>();
		Boolean find = false;
		for(Movimiento m : this.movimientos){
			if(m.getLote().getEstado()==true && m.getLote().getProducto() == p){
				for(Object[] lc: loteCantidad){
					if((Lote)lc[0] == m.getLote()){
						lc[1] = (float)lc[1] + m.getCantidad();
						find = true;
					}
				}
				if(find==false){
					Object[] aux = null;
					aux[0] = m.getLote();
					aux[1] = m.getCantidad();
					loteCantidad.add(aux);
				}
			}
		}
		return loteCantidad;
	}
	
	
	
//	public void controlVencimientoLotes(){
//		Date hoy = new Date();
//		for(ItemStock it : stock){
//			if(it.getLote().getVencimiento().getTime()<hoy.getTime()){
//				it.getLote().setEstado(false);
//			}
//		}
//	}
}
