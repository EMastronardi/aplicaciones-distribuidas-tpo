package negocio;

import java.util.ArrayList;
import java.util.Collection;

public class Producto {
	protected String categorizacion;
	protected String nombre;
	protected ArrayList<ItemProveedor> proveedores;

	public String getCategorizacion() {
		return categorizacion;
	}

	public void setCategorizacion(String categorizacion) {
		this.categorizacion = categorizacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public ArrayList<ItemProveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(ArrayList<ItemProveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Producto(String categorizacion, String nombre,
			ArrayList<ItemProveedor> proveedores) {
		super();
		this.categorizacion = categorizacion;
		this.nombre = nombre;
		this.proveedores = proveedores;
	}

}
