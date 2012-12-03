package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idDeposito;
	private String descripcion;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idDeposito")
	protected List<Movimiento> movimientos;

	public Deposito() {
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public void sumarInventario(float cant, Lote l) {
		ArrayList<Movimiento> auxMovimientos = new ArrayList<Movimiento>();
		auxMovimientos.add(new Movimiento(new Date(), this, l, cant,
				"Incremento de Stock", "prueba"));
		MovimientoDAO.getInstancia().grabarMovimientos(auxMovimientos);
	}

	public boolean restarInventario(Producto p, float cant, Deposito depSucursal) {
		ArrayList<Movimiento> auxMovimientos = new ArrayList<Movimiento>();
		List<LoteCantidad> cantidadLote = getStockProducto(p);
		
		while (cant > 0 && !cantidadLote.isEmpty()) {
			LoteCantidad loteMasViejo = null;
			for (LoteCantidad lc : cantidadLote) {
				if (loteMasViejo == null
						|| (lc.getLote().getVencimiento().compareTo(loteMasViejo.getLote().getVencimiento())) < 0) {
					loteMasViejo = lc;
				}
			}
			
			if (cant <= loteMasViejo.getCantidad()) {
				auxMovimientos.add(new Movimiento(new Date(), this,
						loteMasViejo.getLote(), cant * -1, "Resta de Stock",
						"prueba"));
				cant = 0;
			} else {
					Lote l = loteMasViejo.getLote();
					l.setEstado(false);
					auxMovimientos.add(new Movimiento(new Date(), this, l,
							loteMasViejo.getCantidad() * -1, "Resta de Stock",
							"prueba"));
					cant = cant - loteMasViejo.getCantidad();
					cantidadLote.remove(loteMasViejo);
				}
			}
		
		if (cant == 0){
			System.out.println("Pude Grabar los movimientos");
			MovimientoDAO.getInstancia().grabarMovimientos(auxMovimientos);
			return true;
		}else{
			System.out.println("No me da el Stock amigo, le pido al deposito Sucursal. Intentelo mas tarde.");
			//Resto la cantidad del deposito sucursal
			depSucursal.traspasoDepSucursalDepArea(p, cant, this);
			return false;
		}
	}
	
	public boolean traspasoDepSucursalDepArea(Producto p, float cant, Deposito depArea) {
		ArrayList<Movimiento> auxMovimientos = new ArrayList<Movimiento>();
		List<LoteCantidad> cantidadLote = getStockProducto(p);
		
		while (cant > 0 && !cantidadLote.isEmpty()) {
			LoteCantidad loteMasViejo = null;
			for (LoteCantidad lc : cantidadLote) {
				if (loteMasViejo == null
						|| (lc.getLote().getVencimiento().compareTo(loteMasViejo.getLote().getVencimiento())) < 0) {
					loteMasViejo = lc;
				}
			}
			
			if (cant <= loteMasViejo.getCantidad()) {
				auxMovimientos.add(new Movimiento(new Date(), this,
						loteMasViejo.getLote(), cant * -1, "Traspaso Baja Suc",
						"prueba"));
				auxMovimientos.add(new Movimiento(new Date(), depArea,
						loteMasViejo.getLote(), cant, "Traspaso Alta Area",
						"prueba"));
				cant = 0;
			} else {
					Lote l = loteMasViejo.getLote();
					auxMovimientos.add(new Movimiento(new Date(), this, l,
							loteMasViejo.getCantidad() * -1, "Traspaso Baja Suc",
							"prueba"));
					auxMovimientos.add(new Movimiento(new Date(), depArea, l,
							loteMasViejo.getCantidad(), "Traspaso Alta Suc",
							"prueba"));
					cant = cant - loteMasViejo.getCantidad();
					cantidadLote.remove(loteMasViejo);
				}
			}
		
		if (cant == 0){
			System.out.println("Pude Grabar los movimientos de traspaso");
			MovimientoDAO.getInstancia().grabarMovimientos(auxMovimientos);
			return true;
		}else{
			System.out.println("No me da el Stock en el depósito Sucursal");
			return false;
		}
	}

	
	private List<LoteCantidad> getStockProducto(Producto p) {
		List<LoteCantidad> loteCantidad = new ArrayList<LoteCantidad>();
		
		for (Movimiento m : this.movimientos) {
			Boolean find = false;
			if (m.getLote().getEstado() == true
					&& m.getLote().getProducto().getIdProducto() == p
							.getIdProducto()) {
				for (LoteCantidad lc : loteCantidad) {
					if (lc.getLote() == m.getLote()) {
						lc.sumarCantidad(m.getCantidad());
						find = true;
					}
				}
				if (find == false) {
					loteCantidad.add(new LoteCantidad(m.getLote(), m.getCantidad()));
				}
			}
		}
		return loteCantidad;
	}

}
