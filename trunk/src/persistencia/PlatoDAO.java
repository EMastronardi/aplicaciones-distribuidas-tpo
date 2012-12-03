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
	
	public List<Plato> getPlatos(String sucursal){
		List<Plato> platos = session.createQuery("Select p from Carta c join Rubro r join Plato p where c.sucursal.nombre =:nombre").setString("nombre", sucursal).list();
		return platos;
	}
}
