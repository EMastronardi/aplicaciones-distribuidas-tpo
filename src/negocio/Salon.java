package negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import negocio.Mozo;

public class Salon {
	private String nombre;
	private ArrayList<Mesa> mesas;
	private ArrayList<Reserva> reservas;
	private ArrayList<Venta> ventasAbiertas;
	private ArrayList<Comanda> comandas;
	
	public Salon(String nombre, ArrayList<Mesa> mesasSalon) {
		this.nombre = nombre;
		this.mesas = mesasSalon;
		this.reservas = new ArrayList<Reserva>();
		this.ventasAbiertas = new ArrayList<Venta>();
		this.comandas = new ArrayList<Comanda>();
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(ArrayList<Mesa> mesasSalon) {
		this.mesas = mesasSalon;
	}

	public boolean reservarMesa(Date fecha, Date hora, int cantComenzales){
		Reserva rsv = new Reserva(fecha, hora, cantComenzales);
		reservas.add(rsv);
		return true;
	}
	
	public boolean abrirMesa(Collection<Mesa> mesasParaAbrir, Mozo mozo, int cantComezales){
		int numeroMasAlto=0;
		
		//Comprobamos si existen lugares libres para abrir la mesa!
		
		if(this.getLugaresLibres() >= cantComezales){
			for (Mesa mesa : mesasParaAbrir) {
				mesa.setEstado("Ocupada");
				if(numeroMasAlto < mesa.getNumero()){
					numeroMasAlto = mesa.getNumero();
				}
			}
			//Generamos la venta!
			Venta nuevaVenta = new Venta(numeroMasAlto, mesasParaAbrir, mozo, "Abierta");
			
			return true;
		}else{
			return false;
		}
	}

	private int getLugaresLibres(){
		int cantDisponible=0;
		//Cantidad de lugares disponibles
		for (Mesa mesa : this.mesas) {
			if(mesa.getEstado().equals("habilitada")){
				cantDisponible += mesa.getCapacidad();
			}
		}
		//Descontamos la cantidad de lugares en las reservas
		for (Reserva reserva : reservas) {
			if(reserva.getEstado().equals("activa")){
				cantDisponible -= reserva.getCantComenzales();
			}
		}
		
		return cantDisponible;
	}
	
	public void generarComanda(ArrayList<ItemComanda> itemsComanda, Venta vta){
		Comanda cmd = new Comanda(vta, vta.getMozo());
		for (ItemComanda itemComanda : itemsComanda) {
			cmd.addItemComanda(itemComanda);
		}	
		comandas.add(cmd);
	}
	
	public void eliminarComanda(Comanda cmd){
		int i = 0;
		while(i < comandas.size() && this.comandas.get(i).equals(cmd)){
			i++;
		}
		if(i < comandas.size()){
			comandas.remove(i);
		}
	}
}
