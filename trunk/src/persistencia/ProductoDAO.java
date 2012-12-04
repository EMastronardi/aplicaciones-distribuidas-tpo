package persistencia;

import java.util.List;

import negocio.Producto;

import org.hibernate.Session;

public class ProductoDAO {
	private static ProductoDAO instancia;
	public static ProductoDAO getInstancia() {
		if (instancia == null)
			instancia = new ProductoDAO();
				
		return instancia;
	}
	private ProductoDAO(){
		
	}
	public List<Producto> getProductos(){
		return null;
	}
	
	public Producto obtenerProducto(int idProducto){
		Session s = HibernateUtil.getCurrent();
		Producto prod = (Producto) s.createQuery("from Producto where idProducto = :idProducto").setInteger("idProducto", idProducto).uniqueResult();
		
		return prod;	
	}
}
