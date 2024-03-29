package persistencia;

import negocio.Deposito;
import negocio.Sucursal;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class DepositoDAO {
	private static DepositoDAO instancia;
	
	private DepositoDAO(){
		
	}
	
	public static DepositoDAO getInstancia(){
		if(instancia==null){
			instancia = new DepositoDAO();
		}
		return instancia;
	}
	
	public Deposito obtenerDepositoSucursal(int idComanda){
		Session s = HibernateUtil.getCurrent();
		Deposito dep = (Deposito) s.createQuery("Select suc.deposito from Sucursal suc join suc.salon.comandas com where com.idComanda = :idComanda").setInteger("idComanda", idComanda).uniqueResult();
		
		return dep;	
	}
	
	public Sucursal obtenerSucursal(int idComanda){
		Session s = HibernateUtil.getCurrent();
		Sucursal suc = (Sucursal) s.createQuery("Select suc from Sucursal suc join suc.salon.comandas com where com.idComanda = :idComanda").setInteger("idComanda", idComanda).uniqueResult();
		return suc;	
	}
}
