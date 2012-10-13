package negocio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import negocio.Mozo;

public class Salon {
	private String nombre;
	private Collection<Mesa> mesas;
	private Collection<Reserva> reservas;
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Collection<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(Collection<Mesa> mesas) {
		this.mesas = mesas;
	}

	public Salon(String nombre, Collection<Mesa> mesas) {
		this.nombre = nombre;
		this.mesas = mesas;
		this.reservas = new ArrayList<Reserva>();
	}
	
	public boolean reservarMesa(Date fecha, Date hora, int cantComenzales){
		Reserva rsv = new Reserva(fecha, hora, cantComenzales);
		reservas.add(rsv);
		return true;
	}
	public boolean abrirMesa(Collection<Mesa> mesas, Mozo mozo, int canComezales){
		
		
		return true;
	}

}
