package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import persistencia.MovimientoDAO;

@Entity
@Table(name = "Depositos")
@Inheritance(strategy = InheritanceType.JOINED)
public class Deposito {
	@Id
	private int idDeposito;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idDeposito")
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
			ArrayList<Object[]> cantidadLote = getStockProducto(p); 
			ArrayList<Movimiento> auxMovimientos = new ArrayList<Movimiento>();
			
			while(cant>0 && cantidadLote!=null){
				Object[] masViejo = null;
				for(Object[] aux: cantidadLote){
					Lote auxLoteMasViejo= (Lote)masViejo[0];
					Lote auxLote = (Lote)aux[0];
					if(masViejo==null||(auxLote.getVencimiento().compareTo(auxLoteMasViejo.getVencimiento()))<0){
						masViejo = aux;
					}
				}
				float cantidadLoteMasViejo = (float)masViejo[1];
				if(cant<=cantidadLoteMasViejo){
					auxMovimientos.add(new Movimiento(new Date(),this,(Lote) masViejo[0],cant*-1,"Ajuste de Stock","prueba"));
					cant = 0;
				}
				else{
					if(cant>cantidadLoteMasViejo){
						Lote l = (Lote) masViejo[0];
						l.setEstado(false);
						auxMovimientos.add(new Movimiento(new Date(),this,l,cantidadLoteMasViejo*-1,"Ajuste de Stock","prueba"));
						cant = cant - cantidadLoteMasViejo;
						cantidadLote.remove(masViejo);
					}
				}
			}
			if(cant>0)
				//Si devuelvo false si no tengo la cantidad necesaria en el stock
				return false;
			else {
				MovimientoDAO.getInstancia().grabarMovimientos(auxMovimientos);
				return true;
			}
				
	}

	private ArrayList<Object[]> getStockProducto(Producto p) {
		ArrayList<Object[]> loteCantidad = new ArrayList<Object[]>();
		Boolean find = false;
		for (Movimiento m : this.movimientos) {
			if (m.getLote().getEstado() == true && m.getLote().getProducto() == p) {
				for (Object[] lc : loteCantidad) {
					if ((Lote) lc[0] == m.getLote()) {
						lc[1] = (float) lc[1] + m.getCantidad();
						find = true;
					}
				}
				if (find == false) {
					Object[] aux = null;
					aux[0] = m.getLote();
					aux[1] = m.getCantidad();
					loteCantidad.add(aux);
				}
			}
		}
		return loteCantidad;
	}

	// public void controlVencimientoLotes(){
	// Date hoy = new Date();
	// for(ItemStock it : stock){
	// if(it.getLote().getVencimiento().getTime()<hoy.getTime()){
	// it.getLote().setEstado(false);
	// }
	// }
	// }
}
