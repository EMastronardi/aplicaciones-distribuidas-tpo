package negocio;

public class ItemStock {
	private Lote lote;
	private float cantidad;

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

	public ItemStock(Lote lote, float cantidad) {
		this.lote = lote;
		this.cantidad = cantidad;
	}

}
