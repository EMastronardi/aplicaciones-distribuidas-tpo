package negocio;

import javax.persistence.*;

@Entity
@Table(name="Mesas")
public class Mesa {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idMesa;
	private String estado;
	private int capacidad;
	private int capacidadMaxima;
	
	public Mesa(int numero, String estado, int capacidad) {
		this.idMesa = numero;
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
		return idMesa;
	}

	public void setNumero(int numero) {
		this.idMesa = numero;
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
