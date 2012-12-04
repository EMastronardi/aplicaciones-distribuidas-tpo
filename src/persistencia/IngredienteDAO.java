package persistencia;

import negocio.SemiElaborado;

import org.hibernate.Session;

public class IngredienteDAO {

	private static IngredienteDAO instancia;
	public static IngredienteDAO getInstancia() {
		if (instancia == null)
			instancia = new IngredienteDAO();
				
		return instancia;
	}
	private IngredienteDAO(){
		
	}
	
	public SemiElaborado obtenerSemielaborado(int idIngrediente){
		Session s = HibernateUtil.getCurrent();
		SemiElaborado sem = (SemiElaborado) s.createQuery("from SemiElaborado where idIngrediente = :idIngrediente").setInteger("idIngrediente", idIngrediente).uniqueResult();
		return sem;	
	}
	
}
