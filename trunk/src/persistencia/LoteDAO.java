package persistencia;

import negocio.Lote;

import org.hibernate.Session;

public class LoteDAO {
	private static LoteDAO instancia;
	
	private LoteDAO(){
		
	}
	
	public static LoteDAO getIntancia(){
		if(instancia==null){
			instancia = new LoteDAO();
		}
		return instancia;
	}
	
	public boolean setEstado(Lote l){
		Session sesion = HibernateUtil.getCurrent();
		sesion.update(l);
		return true;
	}
	
	public Lote obtenerLote(int idLote){
		Session s = HibernateUtil.getCurrent();
		Lote lote = (Lote) s.createQuery("from Lote where idLote = :idLote").setInteger("idLote", idLote).uniqueResult();
		
		return lote;	
	}
}
