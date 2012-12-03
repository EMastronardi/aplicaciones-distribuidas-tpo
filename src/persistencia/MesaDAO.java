package persistencia;

public class MesaDAO {
	private static MesaDAO instancia;
	public static MesaDAO getInstancia(){
		if(instancia == null){
			instancia = new MesaDAO();
		}
		return instancia;
	}
	private MesaDAO(){
		
	}
	
}
