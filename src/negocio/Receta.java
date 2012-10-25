package negocio;

import java.util.Collection;

import javax.persistence.*;

@Entity
@Table(name = "Recetas")
public class Receta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idReceta;
	@OneToMany(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Collection<ItemReceta> itemsReceta;
	private String nombre;

	public Collection<ItemReceta> getItemsReceta() {
		return itemsReceta;
	}

	public int getIdReceta() {
		return idReceta;
	}

	public void setIdReceta(int idReceta) {
		this.idReceta = idReceta;
	}

	public void setItemsReceta(Collection<ItemReceta> itemsReceta) {
		this.itemsReceta = itemsReceta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Receta(Collection<ItemReceta> itemsReceta, String nombre) {
		this.itemsReceta = itemsReceta;
		this.nombre = nombre;
	}

}
