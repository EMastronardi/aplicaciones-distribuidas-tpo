package persistencia;

import java.util.List;

import negocio.Carta;
import negocio.Plato;
import negocio.Producto;

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
		
		//Carta carta = (Carta)session.createQuery("Select c from Carta c where c.sucursal.nombre = :nombre").setParameter("nombre", sucursal).uniqueResult();
		List<Plato> platos = session.createQuery("Select p from Carta c join c.rubros r join r.platos p where c.sucursal.nombre =:nombre").setString("nombre", sucursal).list();
		
		
		return platos;
	}
	
	public Plato obtenerPlato(int idPlato){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Plato plato = (Plato) s.createQuery("from Plato where idPlato = :idPlato").setInteger("idPlato", idPlato).uniqueResult();
		
		return plato;	
	}
}
