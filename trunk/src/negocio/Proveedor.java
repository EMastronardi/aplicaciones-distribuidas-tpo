package negocio;

import javax.persistence.*;

@Entity
public class Proveedor {
	@Id
	private int idProveedor;
	private String nombre;
	
	public Proveedor(int idProveedor, String nombre) {
		super();
		this.idProveedor = idProveedor;
		this.nombre = nombre;
	}
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Proveedor() {
	}
}
