package negocio;

import java.util.Collection;

public class Plato {
	private String nombre;
	private float precio;
	private Collection<Plato> platosAlternativos;
	private Area area;
	private float comisionExtra;
	private Receta receta;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public Collection<Plato> getPlatosAlternativos() {
		return platosAlternativos;
	}

	public void setPlatosAlternativos(Collection<Plato> platosAlternativos) {
		this.platosAlternativos = platosAlternativos;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public float getComisionExtra() {
		return comisionExtra;
	}

	public void setComisionExtra(float comisionExtra) {
		this.comisionExtra = comisionExtra;
	}

	public Receta getReceta() {
		return receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

	public Plato(String nombre, float precio,
			Collection<Plato> platosAlternativos, Area area,
			float comisionExtra, Receta receta) {
		this.nombre = nombre;
		this.precio = precio;
		this.platosAlternativos = platosAlternativos;
		this.area = area;
		this.comisionExtra = comisionExtra;
		this.receta = receta;
	}

}
