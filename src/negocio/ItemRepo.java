package negocio;

import javax.persistence.*;

@Entity
public class ItemRepo {
	@Id
	private int id;

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Producto prod;
	private float cant;
	private String estado;
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public ItemRepo(Producto prod, float cant, String estado) {
		super();
		this.estado=estado;
		this.prod = prod;
		this.cant = cant;
	}
	
	public Producto getProd() {
		return prod;
	}
	
	public void setProd(Producto prod) {
		this.prod = prod;
	}
	
	public float getCant() {
		return cant;
	}
	
	public void setCant(float cant) {
		this.cant = cant;
	}
}
