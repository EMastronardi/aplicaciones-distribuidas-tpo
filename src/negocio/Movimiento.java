package negocio;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Movimientos")
public class Movimiento {

	@Id
	@Column(name = "idMovimiento")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int nroMovimiento;
	private Date fecha;
	
	@ManyToOne
	@JoinColumn(name = "idLote")
	private Lote lote;
	
	private float cantidad;
	private String motivo;
	private String usuario;

	public Movimiento() {
	
	}

	public Movimiento(Date fecha, Deposito deposito,
			Lote lote, float cantidad, String motivo, String usuario) {
		super();
		this.fecha = fecha;
		this.deposito = deposito;
		this.lote = lote;
		this.cantidad = cantidad;
		this.motivo = motivo;
		this.usuario = usuario;
	}

	public int getNroMovimiento() {
		return nroMovimiento;
	}

	public void setNroMovimiento(int nroMovimiento) {
		this.nroMovimiento = nroMovimiento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@ManyToOne
	@JoinColumn(name = "idDeposito")
	private Deposito deposito;
	public Deposito getDeposito() {
		return deposito;
	}

	public void setDeposito(Deposito deposito) {
		this.deposito = deposito;
	}

	public Lote getLote() {
		return lote;
	}

	public void setLote(Lote lote) {
		this.lote = lote;
	}

	public float getCantidad() {
		return cantidad;
	}

	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
}
