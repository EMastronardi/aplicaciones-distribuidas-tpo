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

	public static ComandaDAO getInstancia() {
		if (instancia == null) {
			instancia = new ComandaDAO();
		}
		return instancia;
	}

	public void grabarComanda(Comanda comanda) {
		Session session = HibernateUtil.getCurrent();
		session.beginTransaction();
		session.persist(comanda);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
	
	public Comanda obtenerComanda(int idComanda){
		Session s = HibernateUtil.getNewSession();
		Comanda com = (Comanda) s.createQuery("from Comanda where idComanda = :idComanda").setInteger("idComanda", idComanda).uniqueResult();
		return com;	
	}
	
	public List<Comanda> getComandasActivas(String sucursal, String nombre){
		Session s = HibernateUtil.getCurrent();
		List<Comanda> comandas = new ArrayList<Comanda>();
		
		ArrayList<Venta> ventasActivas = (ArrayList<Venta>) VentaDAO.getInstancia().getVentasActivas(sucursal, nombre);
		for(Venta v: ventasActivas){
			List<Comanda> cmds =  s.createQuery("from Comanda c where c.venta.idVenta = :idVenta and c.estado = 1").setInteger("idVenta", v.getIdVenta()).list();
			for (Comanda c : cmds) {
				comandas.add(c);
			}
		}
		
		return comandas;
	}
	
}
