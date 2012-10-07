package negocio;

import java.util.Date;

public class Lote {
	private String codigo;
	private String estado;
	private Date vencimiento;
	private Producto producto;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getVencimiento() {
		return vencimiento;
	}

	public void setVencimiento(Date vencimiento) {
		this.vencimiento = vencimiento;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Lote(String codigo, String estado, Date vencimiento,
			Producto producto) {
		this.codigo = codigo;
		this.estado = estado;
		this.vencimiento = vencimiento;
		this.producto = producto;
	}

}
