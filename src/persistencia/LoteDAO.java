package persistencia;

import negocio.Lote;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class LoteDAO {
	private static LoteDAO instancia;
	private static SessionFactory sf;
	
	private LoteDAO(){
		
	}
	
	public static LoteDAO getIntancia(){
		if(instancia==null){
			instancia = new LoteDAO();
			sf = HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public boolean setEstado(Lote l){
		Session sesion = sf.openSession();
		sesion.update(l);
		return true;
	}
}
