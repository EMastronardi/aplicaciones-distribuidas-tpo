package persistencia;

import negocio.Deposito;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DepositoDAO {
	private static DepositoDAO instancia;
	private static SessionFactory sf;
	
	private DepositoDAO(){
		
	}
	
	public static DepositoDAO getInstancia(){
		if(instancia==null){
			instancia = new DepositoDAO();
			sf = HibernateUtil.getSessionFactory();
		}
		return instancia;
	}
	
	public Deposito obtenerDepositoSucursal(int idComanda){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Deposito dep = (Deposito) s.createQuery("Select suc.deposito from Sucursal suc join suc.salon sal join sal.comandas where sal.comandas.idComanda = :idComanda").setInteger("idComanda", idComanda).uniqueResult();
		
		return dep;	
	}
}
