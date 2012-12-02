package persistencia;

import java.util.List;

import negocio.Plato;

import org.hibernate.Session;

public class PlatoDAO {

	private static PlatoDAO instancia;
	private Session session;
	public static PlatoDAO getInstancia() {
		if (instancia == null)
			instancia = new PlatoDAO();
			instancia.session =  HibernateUtil.getSessionFactory().openSession();	
		return instancia;
	}
	private PlatoDAO(){
		
	}
	public List<Plato> getPlatos(){
		List<Plato> platos = session.createQuery("Select p from Plato p").list();
		return platos;
	}
}
