package negocio;

public class Mesa {
	private int numero;
	private String estado;
	private int capacidad;

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

	public Mesa(int numero, String estado, int capacidad) {
		this.numero = numero;
		this.estado = estado;
		this.capacidad = capacidad;
	}

}
