package persistencia;

import java.util.ArrayList;
import java.util.List;

import negocio.Sucursal;

import org.hibernate.Session;

import beans.SucursalVO;

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
		List<Sucursal> suc = s.createQuery("Select s from Sucursal s inner join s.salon sa inner join sa.sectores sec inner join sec.mozos m where m.nombre = :nombre").setString("nombre", usuario).list();
		System.out.println(suc.get(0).getNombre());
		
		return suc.get(0);	
	}
	
	public Sucursal obtenerSucursal(int idSucursal){
		Session s = HibernateUtil.getSessionFactory().openSession();
		Sucursal suc = (Sucursal) s.createQuery("from Sucursal where idSucursal = :idSucursal").setInteger("idSucursal", idSucursal).uniqueResult();
	
		return suc;	
	}
	
	public List<SucursalVO> obtenerSucursales() {
		List<SucursalVO> lista = new ArrayList<SucursalVO>();
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Sucursal> sucursales = session.createQuery("from Sucursal").list();
		System.out.println("Metodo en server encontro:");
		for (Sucursal s : sucursales) {
			System.out.println("Sucursal: " + s.getNombre());
			SucursalVO svo = new SucursalVO();
			svo.setIdSucursal(s.getIdSucursal());
			svo.setNombre(s.getNombre());
			lista.add(svo);
		}
		return lista;
	}

}
