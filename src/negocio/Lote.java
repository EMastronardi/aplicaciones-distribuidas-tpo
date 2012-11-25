package negocio;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="Lotes")
public class Lote {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idLote;
	private String codigo;
	private Boolean estado;
	private Date vencimiento;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idProducto")
	private Producto producto;

	public Lote() {
	}
	public Lote(String codigo, Boolean estado, Date vencimiento,
			Producto producto) {
		this.codigo = codigo;
		this.estado = estado;
		this.vencimiento = vencimiento;
		this.producto = producto;
	}
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
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



}
