package negocio;

import javax.persistence.*;

@Entity
@Table(name="Mesas")
public class Mesa {
	@Id
	private int numero;
	private String estado;
	private int capacidad;
	private int capacidadMaxima;
	
	public Mesa(int numero, String estado, int capacidad) {
		this.numero = numero;
		this.estado = estado;
		this.capacidad = capacidad;
		//Setemaos la capacidad maxima de la mesa
		switch (this.capacidad){
		case 6:
			this.capacidadMaxima = this.capacidad +2;
			break;
		case 8:
			this.capacidadMaxima = this.capacidad + 1;	
			break;
		default:
			this.capacidadMaxima = this.capacidad ;
			break;
		}	
	}
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	
}
