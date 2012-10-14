package negocio;

public class ItemPlanProduccion {
	private SemiElaborado item;
	private float cantidad;
	private float estadoProcentual;
	public SemiElaborado getItem() {
		return item;
	}
	public void setItem(SemiElaborado item) {
		this.item = item;
	}
	public float getCantidad() {
		return cantidad;
	}
	public void setCantidad(float cantidad) {
		this.cantidad = cantidad;
	}
	public float getEstadoProcentual() {
		return estadoProcentual;
	}
	public void setEstadoProcentual(float estadoProcentual) {
		this.estadoProcentual = estadoProcentual;
	}
	public ItemPlanProduccion(SemiElaborado item, float cantidad,
			float estadoProcentual) {
		this.item = item;
		this.cantidad = cantidad;
		this.estadoProcentual = estadoProcentual;
	}
	

}
