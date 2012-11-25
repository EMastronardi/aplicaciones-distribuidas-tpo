package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Productos")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int idProducto;
	protected String categorizacion;
	protected String nombre;

	@Transient
	protected List<ItemProveedor> proveedores;
	
	public Producto() {
	}
	
	public Producto(String categorizacion, String nombre,
			ArrayList<ItemProveedor> proveedores) {
		super();
		this.categorizacion = categorizacion;
		this.nombre = nombre;
		this.proveedores = proveedores;
	}
	
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

	public List<ItemProveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(ArrayList<ItemProveedor> proveedores) {
		this.proveedores = proveedores;
	}

}
