package negocio;

import javax.persistence.*;

@Entity
@Table(name = "Comisiones")
public class Comision {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idComision;

	public Comision() {
	}
}
