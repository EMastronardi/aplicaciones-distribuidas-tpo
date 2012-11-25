package negocio;

import javax.persistence.*;

@Entity
@Table(name="Billetes")
public class Billete {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idBillete;
	private String denominacion;
	private float valor;
	
	public Billete() {
	}
	public Billete(String denominacion, float valor) {
		this.denominacion = denominacion;
		this.valor = valor;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
}
