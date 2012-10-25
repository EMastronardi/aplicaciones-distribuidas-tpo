package persistencia;

import negocio.*;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory;
	static {
		try {
			AnnotationConfiguration config = new AnnotationConfiguration();
			// Aca agregar todas las clases persistibles!
			// config.addAnnotatedClass(UnaClase.class);
			config.addAnnotatedClass(Mesa.class);
			config.addAnnotatedClass(Administrativo.class);
			config.addAnnotatedClass(Empleado.class);
			config.addAnnotatedClass(Encargado.class);
			config.addAnnotatedClass(Factura.class);
			config.addAnnotatedClass(Ingrediente.class);
			config.addAnnotatedClass(Insumo.class);
			config.addAnnotatedClass(ItemFactura.class);
			config.addAnnotatedClass(ItemProveedor.class);
			config.addAnnotatedClass(ItemReceta.class);
			config.addAnnotatedClass(Mozo.class);
			config.addAnnotatedClass(Producto.class);
			config.addAnnotatedClass(Proveedor.class);
			config.addAnnotatedClass(Receta.class);
			config.addAnnotatedClass(SemiElaborado.class);
			config.addAnnotatedClass(Simple.class);
			config.addAnnotatedClass(Venta.class);
			sessionFactory = config.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}