package negocio;

import javax.persistence.*;

public class ItemProveedor {
	private int idItemProveedor;	
	private int idProducto;
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
