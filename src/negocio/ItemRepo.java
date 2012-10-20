package negocio;

public class ItemRepo {
	private Producto prod;
	private float cant;
	
	public ItemRepo(Producto prod, float cant) {
		super();
		this.prod = prod;
		this.cant = cant;
	}
	
	public Producto getProd() {
		return prod;
	}
	
	public void setProd(Producto prod) {
		this.prod = prod;
	}
	
	public float getCant() {
		return cant;
	}
	
	public void setCant(float cant) {
		this.cant = cant;
	}
}
