package negocio;

import javax.persistence.*;

@Entity
@Table(name="ItemsProveedores")
public class ItemProveedor {
	@Id
	private int id;
	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Proveedor proveedor;
	private float precio;

	public ItemProveedor(Proveedor proveedor, float precio) {
		super();
		this.proveedor = proveedor;
		this.precio = precio;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
}
