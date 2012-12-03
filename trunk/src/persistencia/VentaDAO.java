package persistencia;

import java.util.List;

import org.hibernate.Session;

import negocio.Plato;
import negocio.Venta;

public class VentaDAO {

	private static VentaDAO instancia;
	private Session session;
	public static VentaDAO getInstancia() {
		if (instancia == null)
			instancia = new VentaDAO();
				
		return instancia;
	}
	private VentaDAO(){
		
	}
	public List<Venta> getVentasActivas(String sucursal, String nombre){
		List<Venta> ventas = session.createQuery("Select v from Sucursal s join s.Salon.ventasAbiertas v where s.nomnbre=:sucursal and v.Mozo.nombre=:nombre").setString("sucursal", sucursal).setParameter("nombre", nombre).list();
		return ventas;
	}
}
