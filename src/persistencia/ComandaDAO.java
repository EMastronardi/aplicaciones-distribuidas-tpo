package persistencia;

import java.util.ArrayList;
import java.util.List;

import negocio.Comanda;
import negocio.Producto;
import negocio.Venta;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ComandaDAO {

	private static ComandaDAO instancia = null;
	private static SessionFactory sf = null;

	public static ComandaDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new ComandaDAO();
		}
		return instancia;
	}

	public void grabarComanda(Comanda comanda) {
		Session session = sf.openSession();
		session.beginTransaction();
		session.persist(comanda);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public Comanda obtenerComanda(int idComanda){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Comanda com = (Comanda) s.createQuery("from Comanda where idComanda = :idComanda").setInteger("idComanda", idComanda).uniqueResult();
		
		return com;	
	}
	
	public List<Comanda> getComandasActivas(String sucursal, String nombre){
		Session s = HibernateUtil.getSessionFactory().openSession();
		List<Comanda> comandas = new ArrayList<Comanda>();
		
		ArrayList<Venta> ventasActivas = (ArrayList<Venta>) VentaDAO.getInstancia().getVentasActivas(sucursal, nombre);
		for(Venta v: ventasActivas){
			Comanda cmd = (Comanda) s.createQuery("from Comanda c where c.venta.idVenta = :idVenta").setInteger("idVenta", v.getIdVenta()).uniqueResult();
			if (cmd != null)
				comandas.add(cmd);	
		}
		
		return comandas;
	}
}
