package persistencia;

import java.util.List;

import negocio.Venta;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class VentaDAO {

	private static VentaDAO instancia;
	
	private VentaDAO(){
		
	}
	
	public static VentaDAO getInstancia(){
		if(instancia==null){
			instancia = new VentaDAO();
		}
		return instancia;
	}
	
	public List<Venta> getVentasActivas(String sucursal, String nombre){
		Session session = HibernateUtil.getCurrent();
		List<Venta> ventas = session.createQuery("Select v from Sucursal s join s.salon.ventasAbiertas v where s.nombre=:sucursal and v.mozo.nombre=:nombre").setString("sucursal", sucursal).setParameter("nombre", nombre).list();
		return ventas;
	}
	
	public void grabarVenta(Venta venta){
		Session session = HibernateUtil.getCurrent();
//		session.beginTransaction();
		session.saveOrUpdate(venta);
//		session.flush();
//		session.getTransaction().commit();
//		session.close();
	}
}
