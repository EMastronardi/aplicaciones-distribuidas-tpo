package controlador;

import java.util.ArrayList;
import java.util.Collection;

import negocio.Area;
import negocio.Barra;
import negocio.Cafeteria;
import negocio.Cocina;
import negocio.Sucursal;

public class Sistema {

	private Collection<Sucursal> sucursales;
	private static Sistema instance = null;

	public static Sistema getInstance() {
		if (instance == null)
			instance = new Sistema();
		return instance;
	}

	private Sistema() {
		sucursales = new ArrayList<Sucursal>();

		cargarDatosIniciales(); // Datos hardcoreados

	}

	private void cargarDatosIniciales() {

		Sucursal suc1 = new Sucursal("Belgrano");
		Area cocina = new Cocina(null, null, null);
		Area bar = new Barra(null, null, null);
		Area cafeteria = new Cafeteria(null, null, null);
		suc1.agregarArea(cocina);
		suc1.agregarArea(bar);
		suc1.agregarArea(cafeteria);
		sucursales.add(suc1);

		Sucursal suc2 = new Sucursal("Caballito");
		Area cocina2 = new Cocina(null, null, null);
		Area bar2 = new Barra(null, null, null);
		Area cafeteria2 = new Cafeteria(null, null, null);
		suc2.agregarArea(cocina2);
		suc2.agregarArea(bar2);
		suc2.agregarArea(cafeteria2);
		sucursales.add(suc2);
		
		Sucursal suc3 = new Sucursal("Puerto Madero");
		Area cocina3 = new Cocina(null, null, null);
		Area bar3 = new Barra(null, null, null);
		Area cafeteria3 = new Cafeteria(null, null, null);
		suc3.agregarArea(cocina3);
		suc3.agregarArea(bar3);
		suc3.agregarArea(cafeteria3);
		sucursales.add(suc3);
	}

	public void generarFactura(String nombreSucursal, int nroMesa) {
		for (Sucursal suc : sucursales) {
			if(suc.getNombre().equals(nombreSucursal)){
				suc.generarFactura(nroMesa);
			}
			
		}
	}

}
