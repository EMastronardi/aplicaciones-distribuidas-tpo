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
import javax.persistence.OneToMany;

import org.hibernate.Session;

import persistencia.HibernateUtil;

@Entity
public class Salon {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idSalon;
	private String nombre;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idSalon")
	private List<Mesa> mesas;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idSalon")
	private List<Reserva> reservas;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idSalon")
	private List<Sector> sectores;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idSalon")
	private List<Venta> ventasAbiertas;

	public List<Venta> getVentasAbiertas() {
		return ventasAbiertas;
	}

	public void setVentasAbiertas(List<Venta> ventasAbiertas) {
		this.ventasAbiertas = ventasAbiertas;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "idSalon")
	private List<Comanda> comandas;

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

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(ArrayList<Mesa> mesasSalon) {
		this.mesas = mesasSalon;
	}

	public boolean reservarMesa(Date fecha, Date hora, int cantComenzales) {
		Reserva rsv = new Reserva(fecha, hora, cantComenzales);
		reservas.add(rsv);
		return true;
	}

	public boolean abrirMesa(List<Mesa> mesasParaAbrir, Mozo mozo,int cantComezales) {
		int numeroMasAlto = 0;
		
		// Comprobamos si existen lugares libres para abrir la mesa!
	
		if (this.getLugaresLibres() >= cantComezales) {
			boolean seguir = true;
			for (Mesa mesa : mesasParaAbrir) {
				if(mesa.getEstado().equals("Ocupada")){
					seguir =false;
				}
			}
			if(seguir){
				for (Mesa mesa : mesasParaAbrir) {
					mesa.setEstado("Ocupada");
					if (numeroMasAlto < mesa.getNumero()) {
						numeroMasAlto = mesa.getNumero();
					}
				}
				// Generamos la venta!
				Venta nuevaVenta = new Venta(numeroMasAlto, mesasParaAbrir, mozo,"Abierta");
				this.ventasAbiertas.add(nuevaVenta);
				return true;
			}else{
				return false;
			}
			
		} else {
			return false;
		}
	}

	public List<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}

	private int getLugaresLibres() {
		int cantDisponible = 0;
		// Cantidad de lugares disponibles
		for (Mesa mesa : this.mesas) {
			if (mesa.getEstado().equals("Habilitada")) {
				cantDisponible += mesa.getCapacidad();
			}
		}
		// Descontamos la cantidad de lugares en las reservas
		for (Reserva reserva : reservas) {
			if (reserva.getEstado().equals("activa")) {
				cantDisponible -= reserva.getCantComenzales();
			}
		}

		return cantDisponible;
	}

	public void generarComanda(ArrayList<ItemComanda> itemsComanda, Venta vta) {
		Comanda cmd = new Comanda(vta, vta.getMozo());
		for (ItemComanda itemComanda : itemsComanda) {
			cmd.addItemComanda(itemComanda);
		}
		comandas.add(cmd);
	}

	public void eliminarComanda(Comanda cmd) {
		int i = 0;
		while (i < comandas.size() && this.comandas.get(i).equals(cmd)) {
			i++;
		}
		if (i < comandas.size()) {
			comandas.remove(i);
		}
	}

	public List<Mesa> buscarMesas(List<Integer> nrosMesas) {
		List<Mesa> mesasBuscadas = new ArrayList<Mesa>();
		
		for (int i = 0; i < nrosMesas.size(); i++) {
			for (Mesa m : this.mesas) {
				if (m.getNumero() == nrosMesas.get(i)) {
					mesasBuscadas.add(m);
				}
			}
		}
		return mesasBuscadas;
	}

	public Salon() {

	}

	public Mozo obtenerMozo(String nombreMozo) {
		List<Sector> sectores2 = this.getSectores();
		for (Sector sector : sectores2) {
			List<Mozo> mozos = sector.getMozos();
			for (Mozo mozo : mozos) {
				if(mozo.getNombre().equals(nombreMozo))
					return mozo;
			}
		}
		return null;
	}

	public List<Comanda> getComandas() {
		return comandas;
	}

	public void setComandas(List<Comanda> comandas) {
		this.comandas = comandas;
	}

}
