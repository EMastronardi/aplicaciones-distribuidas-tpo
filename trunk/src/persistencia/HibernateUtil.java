package persistencia;

import negocio.Administracion;
import negocio.Administrativo;
import negocio.Area;
import negocio.Billete;
import negocio.Caja;
import negocio.CajaDiaria;
import negocio.Carta;
import negocio.Comanda;
import negocio.Comision;
import negocio.Deposito;
import negocio.DepositoCentral;
import negocio.Empleado;
import negocio.Encargado;
import negocio.Factura;
import negocio.Ingrediente;
import negocio.Insumo;
import negocio.ItemBillete;
import negocio.ItemComanda;
import negocio.ItemFactura;
import negocio.ItemPlanProduccion;
import negocio.ItemProveedor;
import negocio.ItemReceta;
import negocio.ItemRepo;
import negocio.ItemVenta;
import negocio.ListaReposicion;
import negocio.Lote;
import negocio.Mesa;
import negocio.Movimiento;
import negocio.Mozo;
import negocio.Pago;
import negocio.PlanProduccion;
import negocio.Plato;
import negocio.Producto;
import negocio.Proveedor;
import negocio.Receta;
import negocio.Reserva;
import negocio.Rubro;
import negocio.Salon;
import negocio.Sector;
import negocio.SemiElaborado;
import negocio.Simple;
import negocio.Sucursal;
import negocio.Venta;

import org.hibernate.Session;
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
			config.addAnnotatedClass(Area.class);
			config.addAnnotatedClass(Plato.class);
			config.addAnnotatedClass(Sucursal.class);
			config.addAnnotatedClass(ItemRepo.class);
			config.addAnnotatedClass(ListaReposicion.class);
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
			config.addAnnotatedClass(Comision.class);
			config.addAnnotatedClass(ItemVenta.class);
			config.addAnnotatedClass(Deposito.class);
			config.addAnnotatedClass(DepositoCentral.class);
			config.addAnnotatedClass(Lote.class);
			config.addAnnotatedClass(Comanda.class);
			config.addAnnotatedClass(Salon.class);
			config.addAnnotatedClass(Reserva.class);
			config.addAnnotatedClass(ItemComanda.class);
			config.addAnnotatedClass(Caja.class);
			config.addAnnotatedClass(CajaDiaria.class);
			config.addAnnotatedClass(Pago.class);
			config.addAnnotatedClass(Billete.class);
			config.addAnnotatedClass(ItemBillete.class);
			config.addAnnotatedClass(Sector.class);
			config.addAnnotatedClass(Movimiento.class);
			config.addAnnotatedClass(Carta.class);
			config.addAnnotatedClass(Rubro.class);
			config.addAnnotatedClass(PlanProduccion.class);
			config.addAnnotatedClass(ItemPlanProduccion.class);
			config.addAnnotatedClass(Administracion.class);
			sessionFactory = config.buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	private static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getNewSession() {
		return getSessionFactory().openSession();
	}

	public static Session getCurrent() {
//		if (getSessionFactory().getCurrentSession() == null) {
			return getSessionFactory().openSession();
//		}

//		return getSessionFactory().getCurrentSession();
	}
}