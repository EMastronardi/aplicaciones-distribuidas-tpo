package negocio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ItemsPlanesProduccion")
public class ItemPlanProduccion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idItemPlanProduccion;
	@ManyToOne
	@JoinColumn(name="idSemiElaborado")
	private SemiElaborado item;
	private float cantidad;
	private float cantidadFinalizada;
	

	public ItemPlanProduccion( SemiElaborado item,
			float cantidad, float cantidadFinalizada) {
		super();
		this.item = item;
		this.cantidad = cantidad;
		this.cantidadFinalizada = cantidadFinalizada;
	}
	public ItemPlanProduccion() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdItemPlanProduccion() {
		return idItemPlanProduccion;
	}
	public void setIdItemPlanProduccion(int idItemPlanProduccion) {
		this.idItemPlanProduccion = idItemPlanProduccion;
	}
	public float getCantidadFinalizada() {
		return cantidadFinalizada;
	}
	public void setCantidadFinalizada(float cantidadFinalizada) {
		this.cantidadFinalizada = cantidadFinalizada;
	}
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
		return cantidadFinalizada;
	}
	public void setEstadoProcentual(float estadoProcentual) {
		this.cantidadFinalizada = estadoProcentual;
	}
	
	

}
