package negocio;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Recetas")
public class Receta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReceta;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="idReceta")
	private List<ItemReceta> itemsReceta;
	private String nombre;

	public List<ItemReceta> getItemsReceta() {
		return itemsReceta;
	}

	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public void setItemsReceta(List<ItemReceta> itemsReceta) {
		this.itemsReceta = itemsReceta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Receta(List<ItemReceta> itemsReceta, String nombre) {
		this.itemsReceta = itemsReceta;
		this.nombre = nombre;
	}
	public Receta() {
	
	}

}
