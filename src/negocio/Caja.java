package negocio;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

public class Caja {
	private Collection<CajaDiaria> cajas;
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
