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
}
