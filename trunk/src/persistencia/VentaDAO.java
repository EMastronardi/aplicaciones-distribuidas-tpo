package persistencia;

import java.util.List;

import org.hibernate.Session;

import negocio.Plato;
import negocio.Venta;

public class VentaDAO {

	private static VentaDAO instancia;
	private static Session session;
	public static VentaDAO getInstancia() {
		if (instancia == null){
			instancia = new VentaDAO();
			session = HibernateUtil.getSessionFactory().openSession();
		}
		return instancia;
	}
	private VentaDAO(){
		
	}
	public List<Venta> getVentasActivas(String sucursal, String nombre){
		List<Venta> ventas = session.createQuery("Select v from Sucursal s join s.salon.ventasAbiertas v where s.nombre=:sucursal and v.mozo.nombre=:nombre").setString("sucursal", sucursal).setParameter("nombre", nombre).list();
		return ventas;
	}
}
