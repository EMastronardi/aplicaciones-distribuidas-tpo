package negocio;

public class LoteCantidad {
	private Lote lote;
	private float cantidad;

	public LoteCantidad(Lote lote, float cantidad) {
		super();
		this.lote = lote;
		this.cantidad = cantidad;
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
	
	public void sumarCantidad(float cant) {
		this.cantidad = this.cantidad + cant;
	}
}
