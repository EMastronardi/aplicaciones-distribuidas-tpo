package persistencia;

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
	
	
	
}
