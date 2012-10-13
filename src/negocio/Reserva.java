package negocio;

import java.util.Collection;
import java.util.Date;

public class Reserva {
	private Date fecha;
	private Date hora;
	private String estado;
	private int cantComenzales;
	
	public Reserva(Date fecha, Date hora, int cantComenzales) {
		super();
		this.fecha = fecha;
		this.hora = hora;
		this.estado = "Activa";
		this.cantComenzales = cantComenzales;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCantComenzales() {
		return cantComenzales;
	}

	public void setCantComenzales(int cantComenzales) {
		this.cantComenzales = cantComenzales;
	}
}
