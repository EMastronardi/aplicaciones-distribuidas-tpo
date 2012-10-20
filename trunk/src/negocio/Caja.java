package negocio;

import java.util.Date;
import java.util.ArrayList;
import java.util.Collection;

public class Caja {
	private Collection<CajaDiaria> cajas;
	private CajaDiaria cajaActual;
	private ArrayList<Factura> facturas;
	
	public Caja() {
		cajas = new ArrayList<CajaDiaria>();
		this.facturas = new ArrayList<Factura>();
	}
	
	public void generarFactura(Venta venta) {
		Factura fact = new Factura(venta);
		facturas.add(fact);
	}
	
	private void calcularComisiones() {

	}

	public void aperturaCajaDiaria(ArrayList<ItemBillete> billetes) {

		if (cajaActual == null) {

			cajaActual = new CajaDiaria(null, "Abierta", new Date());

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
