package persistencia;

import java.util.List;

import negocio.Lote;
import negocio.Movimiento;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class MovimientoDAO {
	private static MovimientoDAO instancia = null;

	public static MovimientoDAO getInstancia() {
		if (instancia == null) {
			instancia = new MovimientoDAO();
		}
		return instancia;
	}

	public void grabarMovimientos(List<Movimiento> movimientos) {
		Session session = HibernateUtil.getCurrent();
		session.beginTransaction();
		for (Movimiento m : movimientos) {
			session.persist(m);
			if(m.getLote().getEstado()==false){
				session.update(m.getLote());
			}
		}
		session.getTransaction().commit();
//		session.flush();
//		session.getTransaction().commit();
//		session.close();
	}
}
