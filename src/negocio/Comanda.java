package negocio;

import java.util.*;

import controlador.Sistema;
public class Comanda {

	private Venta venta;
	private Mozo mozo;
	private Date fecha;
	private ArrayList<ItemComanda> itemsComanda;
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
