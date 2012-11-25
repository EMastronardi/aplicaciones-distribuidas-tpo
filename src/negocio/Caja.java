package negocio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="Cajas")
public class Caja {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCaja;	
	@OneToMany(cascade=CascadeType.ALL)
	private List<CajaDiaria> cajas;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="idCaja")
	private CajaDiaria cajaActual;
	
	public Caja() {
		cajas = new ArrayList<CajaDiaria>();
	}
	
	public void generarFactura(Venta venta) {
		cajaActual.generarFactura(venta);
	}
	
	private void calcularComisiones() {

	}

	public void aperturaCajaDiaria(ArrayList<ItemBillete> billetes) {

		if (cajaActual == null) {

			cajaActual = new CajaDiaria("Abierta", new Date());

			cajaActual.setEfectivoTotal(billetes);
			float total = 0;
			for (ItemBillete itemBillete : billetes) {
				total += itemBillete.getCantidad()
						* itemBillete.getBillete().getValor();
			}
			cajaActual.setTotal(total);

		}

	}

	public void cerrarCajaDiaria(ArrayList<ItemBillete> efectivoEnCaja) {
		if (this.cajaActual != null) {
			float totalEnCaja = 0;
			
			for (ItemBillete itemBillete : efectivoEnCaja) {
				totalEnCaja += itemBillete.getCantidad() * itemBillete.getBillete().getValor(); 
			}
			if(totalEnCaja != cajaActual.getTotal())
				System.out.println("DIFERENCIA DE CAJA ! Total en caja: " + totalEnCaja + " Total en Sistema: "+cajaActual.getTotal());

			cajaActual.setEstado("Cerrada");
			this.cajas.add(cajaActual);
			cajaActual = null;

		}

	}

}
