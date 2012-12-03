package persistencia;

import negocio.Comanda;

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
}
