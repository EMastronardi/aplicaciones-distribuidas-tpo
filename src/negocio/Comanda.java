package negocio;

import java.util.*;

import javax.persistence.*;

import controlador.Sistema;

@Entity
@Table(name="Comandas")
public class Comanda {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idComanda;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idVenta")
	private Venta venta;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idMozo")
	private Mozo mozo;
	private Date fecha;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="idComanda")
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
	
	public void addItemComanda(ItemComanda itmComanda){
		this.itemsComanda.add(itmComanda);
	}
	
	public void deleteItemComanda(ItemComanda itmComanda){
		int i=0;
		while(i < this.itemsComanda.size() &&  this.itemsComanda.get(i).equals(itmComanda)){
			i++;
		}
		if(i < this.itemsComanda.size()){
			this.itemsComanda.remove(i);
		}
	}
}
