package persistencia;

import java.util.List;

import negocio.Movimiento;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MovimientoDAO {
	private static MovimientoDAO instancia = null;
	private static SessionFactory sf = null;

	public static MovimientoDAO getInstancia() {
		if (instancia == null) {
			sf = HibernateUtil.getSessionFactory();
			instancia = new MovimientoDAO();
		}
		return instancia;
	}

	public void grabarMovimientos(List<Movimiento> movimientos) {
		Session session = sf.openSession();
		session.beginTransaction();
		for (Movimiento m : movimientos) {
			session.persist(m);
		}
		session.flush();
		session.getTransaction().commit();
		session.close();
	}
}
