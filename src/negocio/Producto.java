package negocio;

import java.util.Collection;

public class Producto {
	protected String categorizacion;
	protected String nombre;
	protected Collection<Proveedor> proveedores;

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

	public Collection<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(Collection<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}

	public Producto(String categorizacion, String nombre,
			Collection<Proveedor> proveedores) {
		super();
		this.categorizacion = categorizacion;
		this.nombre = nombre;
		this.proveedores = proveedores;
	}

}
