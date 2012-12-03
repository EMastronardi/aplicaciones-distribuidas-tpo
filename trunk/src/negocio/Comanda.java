package negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import persistencia.DepositoDAO;
import persistencia.IngredienteDAO;
import persistencia.VentaDAO;

@Entity
@Table(name = "Comandas")
public class Comanda {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idComanda;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idVenta")
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "idMozo")
	private Mozo mozo;
	private Date fecha;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idComanda")
	private List<ItemComanda> itemsComanda;

	public Comanda() {
	}

	public Comanda(Venta venta, Mozo mozo) {
		super();
		this.venta = venta;
		this.mozo = mozo;
		this.fecha = new Date();
		this.itemsComanda = new ArrayList<ItemComanda>();
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Mozo getMozo() {
		return mozo;
	}

	public void setMozo(Mozo mozo) {
		this.mozo = mozo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Collection<ItemComanda> getItemsComanda() {
		return itemsComanda;
	}

	public void setItemsComanda(ArrayList<ItemComanda> itemsComanda) {
		this.itemsComanda = itemsComanda;
	}

	public void addItemComanda(ItemComanda itmComanda) {
		this.itemsComanda.add(itmComanda);
	}

	public void deleteItemComanda(ItemComanda itmComanda) {
		int i = 0;
		while (i < this.itemsComanda.size()
				&& this.itemsComanda.get(i).equals(itmComanda)) {
			i++;
		}
		if (i < this.itemsComanda.size()) {
			this.itemsComanda.remove(i);
		}
	}

	public boolean confirmarComanda() {
		//Recupero el deposito de Sucursal para esta comanda, por si tengo que pedirle Stock
		Sucursal suc = DepositoDAO.getInstancia().obtenerSucursal(this.idComanda);
		ArrayList<ItemVenta> itemsVenta = new ArrayList<ItemVenta>();
		
		Deposito depPlato = null;
		Deposito depSucursal = suc.getDeposito();
		for (ItemComanda ic : itemsComanda) {
			//Creo el ItemVenta
			itemsVenta.add(new ItemVenta(ic.getPlato(),ic.getCantidad(),"No Facturado"));
			// Obtengo el deposito desde donde va a salir el plato
			// Desde este deposito se descontar� el Stock
			for(Area area: suc.getAreas()){
				for(Plato pla: area.getPlatos()){
					if (pla.getIdPlato()==ic.getPlato().getIdPlato())
						depPlato = area.getDeposito();
				}
			}
			
			//Primera Opcion: Descontar el producto "Compra a Venta" o "Elevaraci�n a venta" directamente
			for (ItemReceta ir: ic.getPlato().getReceta().getItemsReceta()){
				//Creo el movimiento de Baja del Ingrediente por la cantidad de la receta y la cantidad en la comanda
				if (!depPlato.restarInventario(ir.getIngrediente(),ic.getCantidad()*ir.getCantidad(), depSucursal)){
					//Si no puedo restar el producto directamente, intento que el sector lo prepare
					//Pido la receta, si es un Semielaborado
					//IngredienteDao.getInstancia().isSemielaborado()
					SemiElaborado semi = IngredienteDAO.getInstancia().obtenerSemielaborado(ir.getIngrediente().getIdProducto());
					for (ItemReceta ir_semi: semi.getReceta().getItemsReceta()){
						//En este punto pienso que el deposito siempre puede realizar el pedido
						depPlato.restarInventario(ir_semi.getIngrediente(), ic.getCantidad()*ir.getCantidad()*ir_semi.getCantidad(),depSucursal);
					}
				}
			}
		}
		
		//Le agrego a la venta los Items
		this.venta.setItemsVenta(itemsVenta);
		//Persisto los Items
		VentaDAO.getInstancia().grabarVenta(this.venta);
		
		//Harcodeado que devuelva True porque siempre voy a poder cumplir con los pedidos (REVEER)
		return true;
	}

	public int getIdComanda() {
		return idComanda;
	}

	public void setIdComanda(int idComanda) {
		this.idComanda = idComanda;
	}

	public void setItemsComanda(List<ItemComanda> itemsComanda) {
		this.itemsComanda = itemsComanda;
	}
	
}
