package persistencia;

import java.util.List;

import negocio.Sucursal;

import org.hibernate.Session;

public class SucursalDAO {
	private static SucursalDAO instancia;
	public static SucursalDAO getInstancia() {
		if (instancia == null)
			instancia = new SucursalDAO();
				
		return instancia;
	}
	private SucursalDAO(){
		
	}
	public Sucursal obtenerSucursal(String usuario){
		System.out.println("(SERVER) MEtodo obtenerSucursal llamado");
		Session s = HibernateUtil.getSessionFactory().openSession();
		List<Sucursal> suc = s.createQuery("from Sucursal s inner join s.salon sa inner join sa.sectores sec inner join sec.mozos m where m.nombre = :nombre").setString("nombre", usuario).list();
		System.out.println(suc.get(0).getNombre());
		
		return suc.get(0);	
	}

}
